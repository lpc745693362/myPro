package com.lpc.export;

import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileOutputStream;

/**
 * Created by liupengcheng1 on 2016/8/11.
 */
public class PDFBuild {

    public static void buidPDF(String pdfFile, String imageFile, String waterMarkName, int permission) {
        try {
            File file = File.createTempFile("tempFile", ".pdf"); // ������ʱ�ļ�

            // ����PDF
            if (createPDFFile(file)) {
                waterMark(file.getPath(), imageFile, pdfFile, waterMarkName, permission); // ���ˮӡ
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ����PDF�ļ�
     *
     * @param file ��ʱ�ļ�
     * @return �ɹ�/ʧ��
     */
    public static boolean createPDFFile(File file) {
        Rectangle rect = new Rectangle(PageSize.A4);
        Document doc = new Document(rect, 50.0F, 50.0F, 50.0F, 50.0F);
        try {
            PdfWriter.getInstance(doc, new FileOutputStream(file));
            doc.open();

            BaseFont bf = BaseFont.createFont("C:/WINDOWS/Fonts/SIMSUN.TTC,1", "Identity-H", true);// ʹ��ϵͳ����

            Font font = new Font(bf, 14.0F, 0);
            font.setStyle(37); // ������ʽ
            font.setFamily("����"); // ��������

            Paragraph p = new Paragraph("�� �� ͨ ֪ ��\r\n", font);
            p.setAlignment(1);
            doc.add(p);
            doc.close();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void waterMark(String inputFile, String imageFile, String outputFile, String waterMarkName, int permission) {
        try {
            PdfReader reader = new PdfReader(inputFile);
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(outputFile));

            BaseFont base = BaseFont.createFont("C:/WINDOWS/Fonts/SIMSUN.TTC,1", "Identity-H", true);// ʹ��ϵͳ����

            int total = reader.getNumberOfPages() + 1;
            Image image = Image.getInstance(imageFile);

            // ͼƬλ��
            image.setAbsolutePosition(100, 500);
            image.scalePercent(10);
            PdfContentByte under;
            int j = waterMarkName.length();
            char c = 0;
            int rise = 0;
            for (int i = 1; i < total; i++) {
                rise = 400;
                under = stamper.getUnderContent(i);
                under.beginText();
                under.setFontAndSize(base, 30);

                if (j >= 15) {
                    under.setTextMatrix(200, 120);
                    for (int k = 0; k < j; k++) {
                        under.setTextRise(rise);
                        c = waterMarkName.charAt(k);
                        under.showText(c + "");
                    }
                } else {
                    under.setTextMatrix(240, 100);
                    for (int k = 0; k < j; k++) {
                        under.setTextRise(rise);
                        c = waterMarkName.charAt(k);
                        under.showText(c + "");
                        rise -= 18;

                    }
                }

                // ���ˮӡ����
                under.endText();

                // ���ˮӡͼƬ
                under.addImage(image);

                // ����Ȧ
                under.ellipse(250, 450, 350, 550);
                under.setLineWidth(1f);
                under.stroke();
            }
            stamper.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String imageFilePath = "D:/big_logo.png"; // ˮӡͼƬ·��
        String pdfFilePath = "D:/itext.pdf"; // �ļ�����·��
        buidPDF(pdfFilePath, imageFilePath, "������Ȩ", 16);
    }

}
