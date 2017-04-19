package com.lpc.struts;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 导入excel
 * Created by liupengcheng1 on 2017/4/18.
 */
public class ImportExcelAction extends ActionSupport {

    private File excelFile; //上传的文件
    private String excelFileFileName; //保存原始文件名
    private ExcelWorkSheet<Sku> excelWorkSheet; //将Excel文件解析完毕后信息存放到这个对象中

    public String execute() throws Exception {
        Workbook workbook = createWorkBook(new FileInputStream(excelFile));
        // 第一个sheet页面
        Sheet sheet = workbook.getSheetAt(0);
        excelWorkSheet = new ExcelWorkSheet<Sku>();

        // 获得表头
        Row rowHead = sheet.getRow(0);

        // 数据总行数
        int totalRowNum = sheet.getLastRowNum();
        System.out.println("totalRowNum ---------- " + totalRowNum);
        if (totalRowNum > 100) {
            System.out.println("----数据大于100条-----");
            return ERROR;
        }

        // 表头数量
        int rowCells = rowHead.getPhysicalNumberOfCells();
        System.out.println("rowCells ----------- " + rowCells);
        if (rowCells != 2) {
            System.out.println("------表头列数不符合规范！------");
            return ERROR;
        }

        // 判断表头是否符合规范
        int flag = 0;
        while (flag < rowCells) {
            Cell cell = rowHead.getCell(flag);
            String cellName = cell.getStringCellValue();
            System.out.println("cellName-----------" + cellName);
            if (!(cellName.equals("sku") || cellName.equals("促销价"))) {
                System.out.println("------表头不符合规范！------");
                return ERROR;
            }
            flag++;
        }

        Iterator<Cell> iterator = rowHead.iterator();
        // 保存列名
        List<String> cellNames = new ArrayList<String>();
        while (iterator.hasNext()) {
            cellNames.add(iterator.next().getStringCellValue());
        }
        excelWorkSheet.setColumns(cellNames);

        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            Sku sku = new Sku();
            sku.setSkuId((long) row.getCell(0).getNumericCellValue());
            sku.setProPrice(row.getCell(1).getNumericCellValue());
            excelWorkSheet.getData().add(sku);
        }

        System.out.println("excelWorkSheet ---------- " + excelWorkSheet);

        return SUCCESS;
    }


    private Workbook createWorkBook(FileInputStream fileInputStream) throws IOException {
        if (excelFileFileName.toLowerCase().endsWith("xls")) {
            return new HSSFWorkbook(fileInputStream);
        }
        if (excelFileFileName.toLowerCase().endsWith("xlsx")) {
            return new XSSFWorkbook(fileInputStream);
        }
        return null;
    }


    public File getExcelFile() {
        return excelFile;
    }

    public void setExcelFile(File excelFile) {
        this.excelFile = excelFile;
    }

    public String getExcelFileFileName() {
        return excelFileFileName;
    }

    public void setExcelFileFileName(String excelFileFileName) {
        this.excelFileFileName = excelFileFileName;
    }

    public ExcelWorkSheet<Sku> getExcelWorkSheet() {
        return excelWorkSheet;
    }

    public void setExcelWorkSheet(ExcelWorkSheet<Sku> excelWorkSheet) {
        this.excelWorkSheet = excelWorkSheet;
    }
}
