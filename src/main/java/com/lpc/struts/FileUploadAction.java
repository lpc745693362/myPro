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
        // 上传文件目录
//        String uploadPath = ServletActionContext.getServletContext().getRealPath("/upload");
//        logger.info("uploadPath is ============== " + uploadPath);

        String uploadPath = "D:\\export\\lpc\\upload";

        // 基于file创建一个文件输入流
        InputStream is = new FileInputStream(file);
        //设置目标文件
        File toFile = new File(uploadPath, this.getFileFileName());
        // 创建一个输出流
        OutputStream os = new FileOutputStream(toFile);

        // 设置缓存
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
