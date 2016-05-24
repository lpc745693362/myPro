package com.lpc.http;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpGet {

	private static String URL_PATH = "http://tupian.enterdesk.com/2013/xll/003/0312/aodaliya/1.jpg";
	private static String FILE_PATH = "D:\\lpc\\fj01.jpg";
	
	public HttpGet() {

	}
	
	public static void main(String[] args) {
		saveImageToDisk();
	}

	public static void saveImageToDisk() {
		InputStream inputStream = getInputStream();
		byte[] data = new byte[1024];
		int len = 0;
		FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(FILE_PATH);
			while ((len = inputStream.read(data)) != -1) {
				fileOutputStream.write(data, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fileOutputStream != null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	private static InputStream getInputStream() {
		InputStream inputStream = null;
		HttpURLConnection httpURLConnection = null;
		try {
			URL url = new URL(URL_PATH);
			if (url != null) {
				httpURLConnection = (HttpURLConnection) url.openConnection();
				// 设置连接网络的超时时间
				httpURLConnection.setConnectTimeout(3000);
				// 设置本次http请求方式
				httpURLConnection.setRequestMethod("GET");
				int responseCode = httpURLConnection.getResponseCode();
				if (responseCode == 200) {
					// 从服务器获得一个输入流
					inputStream = httpURLConnection.getInputStream();
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return inputStream;
	}
	
}
