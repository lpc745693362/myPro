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
            //��������
            BaseFont bfChinese = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
            Font font = new Font(bfChinese, 12, Font.NORMAL);
            //д����
            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("D:\\HelloWorld.pdf"));

            document.open();

            Paragraph pph1 = new Paragraph("��Ϊ������ţ��Ҳ����ڲ������еı��������������а�������,����������װ�Ĵ�Կա�", font);
            pph1.setSpacingAfter(50);
            pph1.setSpacingBefore(50);
            pph1.setFont(font);
            document.add(pph1);

            //������
            PdfPTable table = new PdfPTable(3);
            table.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell cell = new PdfPCell(new Phrase("��ͷ1", font));
            cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);

            cell.setPhrase(new Phrase("��ͷ2", font));
            table.addCell(cell);

            cell.setPhrase(new Phrase("��ͷ3", font));
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


            // ����ˮӡ
            String FILE_DIR = "D:\\";
            PdfReader reader = new PdfReader(FILE_DIR + "HelloWorld.pdf"); // ԭpdf
            PdfStamper stamp = new PdfStamper(reader, new FileOutputStream(FILE_DIR + "NewHelloWorld.pdf")); // ����ˮӡ���pdf

            Image img = Image.getInstance("D:\\lpc\\logo.png");
            img.setAbsolutePosition(10, 10);
            PdfContentByte under = stamp.getUnderContent(1);
            under.addImage(img);

            //����ˮӡ��liupengcheng
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

