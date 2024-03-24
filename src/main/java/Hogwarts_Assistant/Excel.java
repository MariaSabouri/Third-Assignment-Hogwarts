import java.io.File;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
public class Excel {

    public static void WriteExcel(String Sheetname, int rnum, int cnum, String What) throws IOException {
        HSSFWorkbook workbook=new HSSFWorkbook();
        HSSFSheet sheet=workbook.createSheet(Sheetname);
        System.out.println(rnum);
        if (rnum==-1){
            rnum=sheet.getPhysicalNumberOfRows()+1;
        }
        sheet.createRow(rnum);
        sheet.getRow(rnum).createCell(cnum).setCellValue(What);

        File file=new File("C:\\Users\\Maria\\Desktop\\Third-Assignment-Hogwarts -4\\Excel" +
                "\\Account.xls");
        workbook.write(file);
        workbook.close();


    }
    public static void readExcel(String Sheetname,int rnum,int cnum) throws IOException {
        HSSFWorkbook workbook=new HSSFWorkbook();
        HSSFSheet sheet=workbook.getSheet(Sheetname);
        //todo

        File file=new File("C:\\Users\\Maria\\Desktop\\Third-Assignment-Hogwarts -4\\Excel" +
                "\\Account.xls");
        workbook.write(file);
        workbook.close();

    }
}
