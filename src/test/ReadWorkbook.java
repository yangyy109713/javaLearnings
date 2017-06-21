package test;

import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.CellReference;

import java.io.File;
import java.io.IOException;

public class ReadWorkbook {
	
	@SuppressWarnings({ "deprecation", "resource" })
	public static void main(String[] args){
		try {
			//for .xls file
			NPOIFSFileSystem fs = new NPOIFSFileSystem(new File("workbook.xls"));
			HSSFWorkbook wb = new HSSFWorkbook(fs.getRoot() , true);
			
			/* for .xlsx file
			OPCPackage opk = new OPCPackage(new File("workbook.xlsx"));
			XSSFWorkbook wb = new XSSFWorkbook(opk);
			 */
			DataFormatter df = new DataFormatter();
			for(Sheet sheet : wb){
				for(Row row : sheet){
					for(Cell cell : row){
						CellReference cf = new CellReference(row.getRowNum() , cell.getColumnIndex());
						System.out.print(cf.formatAsString() + " - ");
						
						//get the text that appears in the cell by getting the cell value and applying any data formats(Date, 0.00, 1.23e9, $1.23, etc) 
						String text = df.formatCellValue(cell);
						//System.out.println(text);
						
						//Alternatively, get the value and format it yourself
						switch(cell.getCellType()){
							case Cell.CELL_TYPE_STRING : 
								System.out.println(cell.getRichStringCellValue().getString());
								break;
							case Cell.CELL_TYPE_NUMERIC : 
								 if (DateUtil.isCellDateFormatted(cell)) {
				                        System.out.println(cell.getDateCellValue());
				                    } else {
				                        System.out.println(cell.getNumericCellValue());
				                    }
								break;
							case Cell.CELL_TYPE_BOOLEAN : 
								System.out.println(cell.getBooleanCellValue());
								break;
							case Cell.CELL_TYPE_ERROR : 
								System.out.println(cell.getErrorCellValue());
								break;
							case Cell.CELL_TYPE_FORMULA : 
								System.out.println();
								break;
							case Cell.CELL_TYPE_BLANK : 
								System.out.println();
								break;
						}
					}
				}
			}
			fs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
