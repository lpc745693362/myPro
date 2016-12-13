package com.lpc.export;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by liupengcheng1 on 2016/8/9.
 */
public class ExportTest {

    public static void main(String[] args) throws IOException {
        Document document = new Document();
        try {
            //中文字体
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Font font = new Font(bfChinese, 12, Font.NORMAL);
            //写入器
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\HelloWorld.pdf"));

            document.open();

            Paragraph pph1 = new Paragraph("因为我想活着，我不能掩藏我心中的本欲，正如我心中爱你美丽,又怎能嘴上装四大皆空。", font);
            pph1.setSpacingAfter(50);
            pph1.setSpacingBefore(50);
            pph1.setFont(font);
            document.add(pph1);

            //表格插入
            PdfPTable table = new PdfPTable(3);
            table.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cell = new PdfPCell(new Phrase("表头1", font));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell.setPhrase(new Phrase("表头2", font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("表头3", font));
            table.addCell(cell);

            PdfPCell cell1 = new PdfPCell(new Phrase("test1", font));
            table.addCell(cell1);

            cell1.setPhrase(new Phrase("test2", font));
            table.addCell(cell1);

            cell1.setPhrase(new Phrase("test3", font));
            table.addCell(cell1);

            table.addCell("2.1");
            table.addCell("2.2");
            table.addCell("2.3");
            document.add(table);

            document.close();
            writer.close();


            // 增加水印
            String FILE_DIR = "D:\\";
            PdfReader reader = new PdfReader(FILE_DIR + "HelloWorld.pdf"); // 原pdf
            PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(FILE_DIR + "NewHelloWorld.pdf")); // 增加水印后的pdf

            Image img = Image.getInstance("D:\\lpc\\logo.png");
            img.setAbsolutePosition(10, 10);
            PdfContentByte under = stamp.getUnderContent(1);
            under.addImage(img);

            //文字水印：liupengcheng
            PdfContentByte over = stamp.getOverContent(1);
            over.beginText();
            BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.WINANSI, BaseFont.EMBEDDED);
            over.setFontAndSize(bf, 18);
            over.setTextMatrix(30, 30);
            over.showTextAligned(Element.ALIGN_LEFT, "liupengcheng", 230, 430, 45);
            over.endText();

            stamp.close();
            reader.close();

            System.out.println("==========pdf exported success!==========");

        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

