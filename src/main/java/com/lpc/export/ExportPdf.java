package com.lpc.export;


import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfGState;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.opensymphony.xwork2.ActionSupport;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExportPdf extends ActionSupport {

    private InputStream inputStream;
    private String fileName;

    public String export() {
        try {

            fileName = "HelloWorld.pdf";

            Map<String, Object> headMap = new LinkedHashMap<String, Object>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            headMap.put("�������", "��������");
            headMap.put("��Ʒ���", 1201102540);
            headMap.put("����ʱ��", sdf.format(new Date()) + " - " + sdf.format(new Date()));
            headMap.put("ί�з�Ժ", "����ϵ�ռ���Ժ");
            headMap.put("���Ļ���", "����������");

            List<String> personal = new ArrayList<String>();
            personal.add("���������,�����û���,����,���֤��,�ֻ�����");
            personal.add("1,sop01,����01,341621199110071111,13240813911");
            personal.add("2,sop02,����02,341621199110072222,13240813922");
            personal.add("3,sop01,����03,341621199110073333,13240813933");

            List<String> company = new ArrayList<String>();
            company.add("�����û���,ί�д���������,ί�д��������֤��,��˾����,����,֤����������,֤������");
            company.add("sop01,����,341621198910051111,��ҵ�۹�,������,���֤,341621198910050011");
            company.add("sop02,����,341621198910052222,��ҵ�۹�,Ҧ����,���֤,341621198910050022");
            company.add("sop03,���,341621198910053333,��ҵ�۹�,�ẕ̇�,���֤,341621198910050033");

            Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
            map.put("�����û�", personal);
            map.put("��ҵ�û�", company);

            inputStream = PDFExport(map, headMap);

        } catch (Exception e) {
            System.out.println("e is ================ " + e);
        }

        return "exportpdf";
    }

    /**
     * ����pdf���÷���
     *
     * @param map
     * @return
     * @throws Exception
     */
    private InputStream PDFExport(Map<String, List<String>> map, Map<String, Object> headMap) throws Exception {

        Document document = new Document(PageSize.A4);
        //��������
        BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        Font font = new Font(bfChinese, 12, Font.NORMAL);
        //д����
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, baos);

        document.open();

        if (headMap != null) {
            Paragraph paragraph = new Paragraph();
            paragraph.add(new Chunk(new LineSeparator()));
            document.add(paragraph);
            for (String key : headMap.keySet()) {
                Paragraph pph = new Paragraph(key + "��" + headMap.get(key), font);
                document.add(pph);
            }
            document.add(new Phrase("\n"));
        }

        for (String key : map.keySet()) {

            Paragraph pph = new Paragraph(key + "��", font);
            pph.setLeading(12f);
            document.add(pph);

            pph = new Paragraph(" ", font);
            pph.setLeading(12f);
            document.add(pph);

            List<String> list = map.get(key);
            for (int j = 0; j < list.size(); j++) {
                String rowStrs = list.get(j);
                String strs[] = rowStrs.split(",");

                PdfPTable table = new PdfPTable(strs.length);
                table.setHorizontalAlignment(Element.ALIGN_LEFT);
                table.setWidthPercentage(100);
                PdfPCell cell;

                for (String str : strs) {
                    cell = new PdfPCell(new Phrase(str, font));
                    if (j == 0) {
                        cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    }
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                }
                document.add(table);
            }
            pph = new Paragraph(" ", font);
            pph.setLeading(25f);
            document.add(pph);
        }

        document.close();
        writer.close();

        inputStream = new ByteArrayInputStream(baos.toByteArray());

        return inputStream;
    }


    public String exportSY() {
        File file = null;
        try {

            fileName = "testSY.pdf";

            Map<String, Object> headMap = new LinkedHashMap<String, Object>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            headMap.put("�������", "��������");
            headMap.put("��Ʒ���", 1201102540);
            headMap.put("����ʱ��", sdf.format(new Date()) + " - " + sdf.format(new Date()));
            headMap.put("ί�з�Ժ", "����ϵ�ռ���Ժ");
            headMap.put("���Ļ���", "����������");

            List<String> personal = new ArrayList<String>();
            personal.add("���������,�����û���,����,���֤��,�ֻ�����");
            personal.add("1,sop01,����01,341621199110071111,13240813911");
            personal.add("2,sop02,����02,341621199110072222,13240813922");
            personal.add("3,sop01,����03,341621199110073333,13240813933");

            List<String> company = new ArrayList<String>();
            company.add("�����û���,ί�д���������,ί�д��������֤��,��˾����,����,֤����������,֤������");
            company.add("sop01,����,341621198910051111,��ҵ�۹�,������,���֤,341621198910050011");
            company.add("sop02,����,341621198910052222,��ҵ�۹�,Ҧ����,���֤,341621198910050022");
            company.add("sop03,���,341621198910053333,��ҵ�۹�,�ẕ̇�,���֤,341621198910050033");

            Map<String, List<String>> map = new LinkedHashMap<String, List<String>>();
            map.put("�����û�", personal);
            map.put("��ҵ�û�", company);

            // ������ʱ�ļ�
            file = File.createTempFile("tempFile", ".pdf");
            System.out.println("file path is ============= " + file.getPath());

            // ����PDF
            if (createPDF(file, map, headMap)) {
                inputStream = waterMark(file);
            }

            file.delete();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "exportpdf";
    }

    /**
     * ��������pdf�ļ����ˮӡ
     * @param file
     * @return
     * @throws Exception
     */
    private InputStream waterMark(File file) throws Exception{
        ByteArrayOutputStream baos = null;
        try{
            PdfReader reader = new PdfReader(file.getPath());
            baos = new ByteArrayOutputStream();
            PdfStamper stamper = new PdfStamper(reader, baos);

            Image image = Image.getInstance("D:\\lpc\\jd\\big_logo.png");
            image.setAbsolutePosition(150, 700);
            image.scalePercent(10);
            PdfContentByte under = stamper.getUnderContent(1);
            under.addImage(image);

            PdfGState gs = new PdfGState();
            gs.setFillOpacity(0.2f);
            under.setGState(gs);

            stamper.close();
            reader.close();

            inputStream = new ByteArrayInputStream(baos.toByteArray());

        } catch (Exception e) {
            throw e;
        } finally {
            try {
                baos.close();
            } catch (IOException e) {
                throw e;
            }
        }

        return inputStream;
    }

    private boolean createPDF(File file, Map<String, List<String>> map, Map<String, Object> headMap) {
        try {
            Document document = new Document(PageSize.A4);
            //��������
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Font font = new Font(bfChinese, 12, Font.NORMAL);
            //д����
            PdfWriter.getInstance(document, new FileOutputStream(file));

            document.open();

            if (headMap != null) {
                Paragraph paragraph = new Paragraph();
                paragraph.add(new Chunk(new LineSeparator()));
                document.add(paragraph);
                for (String key : headMap.keySet()) {
                    Paragraph pph = new Paragraph(key + "��" + headMap.get(key), font);
                    document.add(pph);
                }
                document.add(new Phrase("\n"));
            }

            for (String key : map.keySet()) {

                Paragraph pph = new Paragraph(key + "��", font);
                pph.setLeading(12f);
                document.add(pph);

                pph = new Paragraph(" ", font);
                pph.setLeading(12f);
                document.add(pph);

                List<String> list = map.get(key);
                for (int j = 0; j < list.size(); j++) {
                    String rowStrs = list.get(j);
                    String strs[] = rowStrs.split(",");

                    PdfPTable table = new PdfPTable(strs.length);
                    table.setHorizontalAlignment(Element.ALIGN_LEFT);
                    table.setWidthPercentage(100);
                    PdfPCell cell;

                    for (String str : strs) {
                        cell = new PdfPCell(new Phrase(str, font));
                        if (j == 0) {
                            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                        }
                        cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                        table.addCell(cell);
                    }
                    document.add(table);
                }
                pph = new Paragraph(" ", font);
                pph.setLeading(25f);
                document.add(pph);
            }

            document.close();

        } catch (Exception e) {
            System.out.println("Exception is ============ " + e);
            return false;
        }

        return true;
    }


    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
