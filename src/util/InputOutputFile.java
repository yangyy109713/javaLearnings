package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class InputOutputFile implements Serializable {
	
	/**
	 * 用于序列化
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * 使用BufferedWriter和FileWriter将内容写入文件
	 */
	public void inputToFile(String filePath){
		File file = new File(filePath);
		FileWriter fw;
		BufferedWriter bw;
		try {
			fw = new FileWriter(file);
			bw = new BufferedWriter(fw);
			bw.write("按需要的格式写入内容");//具体可参考CookieTest.java中的实现
			bw.newLine();//写完一个换一行
			bw.flush();//存到文件中
			bw.close();
			fw.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 使用BufferedWriter和FileWriter将内容写入文件
	 */
	public void outputfromFile(String filePath){
		File file = new File(filePath);
		FileReader fr;
		BufferedReader br;
		try {
			fr = new FileReader(file);
			br = new BufferedReader(fr);
			String line;
			line = br.readLine();//按行读取，可以参照写入时的规则使用其他方法
			//....使用读取到的文件内容，具体可参考CookieTest.java中的实现
			br.close();
			fr.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
