package utilities;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class File_Converter {
	
	  private static String outFn;
	    private static String inpFn;

	    public static void xlsx2xls(String inputFileName, String outputFileName) throws InvalidFormatException,IOException {
	    	//outFn = "C:\\Users\\Jeff15\\Downloads\\" + outputFileName;
	        //inpFn = "C:\\Users\\Jeff15\\Downloads\\" + inputFileName;
	    	outFn = System.getProperty("user.dir") + "\\src\\test\\resources\\" + outputFileName;
	        inpFn = System.getProperty("user.dir") + "\\src\\test\\resources\\" + inputFileName;
	    	
	        InputStream in = new FileInputStream(inpFn);
	        try {
	            XSSFWorkbook wbIn = new XSSFWorkbook(in);
	            File outF = new File(outFn);
	            if (outF.exists()) {
	                outF.delete();
	            }

	            Workbook wbOut = new HSSFWorkbook();
	            int sheetCnt = wbIn.getNumberOfSheets();
	            for (int i = 0; i < sheetCnt; i++) {
	                Sheet sIn = wbIn.getSheetAt(0);
	                Sheet sOut = wbOut.createSheet(sIn.getSheetName());
	                Iterator<Row> rowIt = sIn.rowIterator();
	                while (rowIt.hasNext()) {
	                    Row rowIn = rowIt.next();
	                    Row rowOut = sOut.createRow(rowIn.getRowNum());

	                    Iterator<Cell> cellIt = rowIn.cellIterator();
	                    while (cellIt.hasNext()) {
	                        Cell cellIn = cellIt.next();
	                        Cell cellOut = rowOut.createCell(cellIn.getColumnIndex(), cellIn.getCellType());

	                        switch (cellIn.getCellType()) {
	                        case Cell.CELL_TYPE_BLANK: break;

	                        case Cell.CELL_TYPE_BOOLEAN:
	                            cellOut.setCellValue(cellIn.getBooleanCellValue());
	                            break;

	                        case Cell.CELL_TYPE_ERROR:
	                            cellOut.setCellValue(cellIn.getErrorCellValue());
	                            break;

	                        case Cell.CELL_TYPE_FORMULA:
	                            cellOut.setCellFormula(cellIn.getCellFormula());
	                            break;

	                        case Cell.CELL_TYPE_NUMERIC:
	                            cellOut.setCellValue(cellIn.getNumericCellValue());
	                            break;

	                        case Cell.CELL_TYPE_STRING:
	                            cellOut.setCellValue(cellIn.getStringCellValue());
	                            break;
	                        }

	                        {
	                            CellStyle styleIn = cellIn.getCellStyle();
	                            CellStyle styleOut = cellOut.getCellStyle();
	                            styleOut.setDataFormat(styleIn.getDataFormat());
	                        }cellOut.setCellComment(cellIn.getCellComment());

	                        }
	                }
	            }
	            OutputStream out = new BufferedOutputStream(new FileOutputStream(outF));
	            try {
	                wbOut.write(out);
	            } finally {
	                out.close();
	            }
	        } finally {
	            in.close();
	        }
	    }
	    
	    
	    
	    
	    public static void csvToXLSX(String csvFileName, String xlsxFileName) {
		    try {
		        //String csvFileAddress = "C:\\Users\\Jeff15\\Downloads\\" + csvFileName; //csv file address
		       //String xlsxFileAddress = "C:\\Users\\Jeff15\\Downloads\\" + xlsxFileName; //xlsx file address
		    	String csvFileAddress = System.getProperty("user.dir") + "\\src\\test\\resources\\" + csvFileName; //csv file address
		        String xlsxFileAddress = System.getProperty("user.dir") + "\\src\\test\\resources\\" + xlsxFileName; //xlsx file address
		        
		        XSSFWorkbook workBook = new XSSFWorkbook();
		        XSSFSheet sheet = workBook.createSheet("sheet1");
		        String currentLine=null;
		        int RowNum=0;
		        BufferedReader br = new BufferedReader(new FileReader(csvFileAddress));
		        while ((currentLine = br.readLine()) != null) {
		            String str[] = currentLine.split(",");
		            RowNum++;
		            XSSFRow currentRow=sheet.createRow(RowNum);
		            for(int i=0;i<str.length;i++){
		                currentRow.createCell(i).setCellValue(str[i]);
		            }
		        }

		        FileOutputStream fileOutputStream =  new FileOutputStream(xlsxFileAddress);
		        workBook.write(fileOutputStream);
		        fileOutputStream.close();
		        br.close();   //newly added
		    } catch (Exception ex) {
		        System.out.println(ex.getMessage()+"Exception in try");
		    }
		}
	    
	    
	    
	

}
