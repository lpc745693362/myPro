package com.lpc.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by liupengcheng on 2016/3/30.
 */
public class WriteFile {

	public void write(String str, File file) {
		try {
			FileWriter out = new FileWriter(file, true);
			out.write(str);
			out.write("\n");
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public File createFile(String fileName) {
		if (fileName.split("\\.").length > 1) {
			fileName = fileName.split("\\.")[fileName.split("\\.").length - 1];
		}
		File file = new File("D:/xml/" + fileName + ".xml");
		if (!file.getParentFile().exists()) {
			file.getParentFile().mkdir();
		}
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return file;
	}

}
