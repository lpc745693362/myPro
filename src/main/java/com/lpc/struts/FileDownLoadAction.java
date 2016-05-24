package com.lpc.struts;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;


public class FileDownLoadAction extends ActionSupport {

    private Logger logger = Logger.getLogger(FileDownLoadAction.class);

    private String fileName;

    public InputStream getDownloadFile () throws Exception {
        this.fileName = "tang.jpg";
        String path = "D:\\lpc\\picture\\person\\";
        String realPath = path + fileName;
        logger.info("realPath is =============== " + realPath);
        File file = new File(realPath);
        InputStream inputStream = new FileInputStream(file);
        return inputStream;
    }

    public String execute() throws Exception {
        return SUCCESS;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
