package com.lpc.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class ReadFileByLine {

	public static void main(String[] args) throws Exception{
//		String fileName = "D:\\Work\\IntelliJ\\workspace\\pop-auction-center\\pop-auction-center-gateway\\src\\main\\java\\com\\jd\\pop\\auction\\center\\gateway\\read\\AuctionCustReadServiceImpl.java";
		String fileName = "D:\\Work\\IntelliJ\\workspace\\pop-auction-center\\pop-auction-center-gateway\\src\\main\\java\\com\\jd\\pop\\auction\\center\\gateway\\validator\\ClientSourceValidator.java";
		readByLine(fileName);
	}

	public static void readByLine(String fileName) throws Exception{
		File file = new File(fileName);
		InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "UTF-8");
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			String tempString = null;
			int line = 1;
			while ((tempString = reader.readLine()) != null) {
				System.out.println(tempString);
				line++;
			}
			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
