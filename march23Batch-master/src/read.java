import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;

public class read {

	public static void main(String[] args) throws IOException {
FileInputStream f=new FileInputStream("C:\\Users\\Qedge\\Documents\\Book.xlsx");
XSSFWorkbook wb=new XSSFWorkbook(f);
XSSFSheet ws=wb.getSheet("sheet1");
Iterator<Row> row=ws.iterator();
while(row.hasNext())
{
	Row r=row.next();
	Iterator<org.apache.poi.ss.usermodel.Cell> cell=r.iterator();
	while(cell.hasNext())
	{
		org.apache.poi.ss.usermodel.Cell c=cell.next();
		if(c.getCellType()==c.CELL_TYPE_STRING)
		{
			System.out.println(c.getStringCellValue()+"...");
		}
		else if(c.getCellType()==c.CELL_TYPE_NUMERIC)
		{
			System.out.println(c.getNumericCellValue()+"....");
		}
	}
}
	}

}
