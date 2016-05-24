package com.lpc.http;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class HttpPost {

	private static String URL_PATH = "http://erp1.jd.net/newHrm/Verify.aspx?ReturnUrl=http%3A%2F%2Fauction.man.jd.net%2Flaw%2Flaw_listAuction.action";
	private static URL url;

	static {
		try {
			url = new URL(URL_PATH);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}

	public static String sendPostMessage(Map<String, String> params, String encode) {
		StringBuffer buffer = new StringBuffer();
		try {
			if (params != null && !params.isEmpty()) {
				for (Map.Entry<String, String> entry : params.entrySet()) {
					// ���ת�����
					buffer.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), encode)).append("&");
				}
				// ȥ�����һ��&
				buffer.deleteCharAt(buffer.length() - 1);
			}

			System.out.println("buffer is ============ " + buffer.toString());

			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			httpURLConnection.setConnectTimeout(3000);
			httpURLConnection.setRequestMethod("POST");
			// ��ʾ�ӷ�������ȡ����
			httpURLConnection.setDoInput(true);
			// ��ʾ�������д����
			httpURLConnection.setDoOutput(true);
			// ����ϴ���Ϣ���ֽڴ�С�Լ�����
			byte[] data = buffer.toString().getBytes();
			// ��ʾ���������������Ϊ�ı�����
			httpURLConnection.setRequestProperty("Content-type", "application/x-www-form-urlencoded");
			httpURLConnection.setRequestProperty("Content-Length", String.valueOf(data.length));

			// ��ȡ������������д����
			OutputStream outputStream = httpURLConnection.getOutputStream();
			outputStream.write(data, 0, data.length);
			outputStream.close();

			// ��ȡ��������Ӧ״̬��ͽ��
			int responseCode = httpURLConnection.getResponseCode();
			if (responseCode == 200) {
				return changeInputStream(httpURLConnection.getInputStream(), encode);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "";
	}

	/**
	 * ��һ��������ת����ָ��������ַ���
	 * 
	 * @param inputStream
	 * @param encode
	 * @return
	 */
	private static String changeInputStream(InputStream inputStream, String encode) {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] data = new byte[1024];
		int len = 0;
		String result = "";
		if (inputStream != null) {
			try {

				while ((len = inputStream.read(data)) != -1) {
					outputStream.write(data, 0, len);
				}
				result = new String(outputStream.toByteArray(), encode);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return result;
	}

	public static void main(String[] args) {

		Map<String, String> params = new HashMap<String, String>();
		params.put("username", "qxgf");
		params.put("password", "xinxibu456");

		String result = HttpPost.sendPostMessage(params, "utf-8");
		System.out.println("result is ============= " + result);

	}

}
