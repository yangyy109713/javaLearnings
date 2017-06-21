package test;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.CreationHelper;

import java.util.Calendar;
import java.util.Date;
import java.io.File;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;

public class WorkbookTest {
	/**
	 * create a new Excel file with a sheet
	 * output 2 rows and 6 columns
	 * @param args
	 * @author yuanyuanyang1 2017-06-21
	 */
	public static void main(String[] args){
		HSSFWorkbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("new sheet");
		Row row;
		Cell cell;
		row = sheet.createRow(0);
		row.createCell(0).setCellValue("序号");
		row.createCell(1).setCellValue("Date");
		row.createCell(2).setCellValue("Calender");
		row.createCell(3).setCellValue("字符串");
		row.createCell(4).setCellValue("True/False");
		row.createCell(5).setCellValue("Error");
		
		row = sheet.createRow((short)1);
		row.createCell(0).setCellValue(1);
		CellStyle cellStyle = wb.createCellStyle();
		
		CreationHelper ch = wb.getCreationHelper();
		cellStyle.setDataFormat(ch.createDataFormat().getFormat("m/d/yy h:mm"));//date format
		
		cell = row.createCell(1);
		cell.setCellValue(new Date());
		cell.setCellStyle(cellStyle);//set the cell data format
		
		cell = row.createCell(2);
		cell.setCellValue(Calendar.getInstance());
		cell.setCellStyle(cellStyle);
		
		row.createCell(3).setCellValue("a string");
		row.createCell(4).setCellValue(true);
		row.createCell(5).setCellType(CellType.ERROR);
		
		//write the output to a file
		try {
			File file = new File("workbook.xls");
			if(file.exists()){
				file.delete();
				file.createNewFile();
			}
			BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
			wb.write(bos);
			bos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
