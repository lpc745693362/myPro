package com.lpc.struts;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by liupengcheng1 on 2016/5/16.
 */
public class FileUploadAction extends ActionSupport{

    private Logger logger = Logger.getLogger(FileUploadAction.class);

    private File file;
    private String fileFileName;
    private String fileContentType;
    private String desc;


    public String execute() throws Exception{
        // �ϴ��ļ�Ŀ¼
//        String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");
//        logger.info("uploadPath is ============== " + uploadPath);

        String uploadPath = "D:\\export\\lpc\\upload";

        // ����file����һ���ļ�������
        InputStream is = new FileInputStream(file);
        //����Ŀ���ļ�
        File toFile = new File(uploadPath, this.getFileFileName());
        // ����һ�������
        OutputStream os = new FileOutputStream(toFile);

        // ���û���
        byte[] buffer = new byte[1024];
        int length = 0;
        while ((length = is.read(buffer)) > 0){
            os.write(buffer, 0, length);
        }

        is.close();
        os.close();

        return SUCCESS;
    }


    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
