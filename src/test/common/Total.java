package test.common;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Total {

    // 利用dataprovider关键字驱动参数化

    public static String LoginData(int a,int b,String path) throws IOException {
        String[][] data = GetData(path);
        return data[a][b];
    }
    public static int RowData_length(String path) throws IOException{
        String[][] data2 = GetData(path);
        int D_length=data2.length;
        return D_length;
    }
    public static int CellData_length(String path) throws IOException{
        String[][] data2 = GetData(path);
        int D_length=data2[0].length;
        return D_length;
    }
//    @Test
//    public void f(int username, int passwd) {
//      String[][] data= new LoginData();
////在输入框中输出信息
//       System.out.println(data[username][passwd]);
//    }

    // 从Excel中获取数据
    @SuppressWarnings("deprecation")
    public static String[][] GetData(String path) throws IOException {
        int i;
        int j;
// 定义行
        int rownum;


// 定义要读取的文件
        FileInputStream readFile = new FileInputStream(path);
// 先创建一个空的workBook,从指定文件中读取
        @SuppressWarnings("resource")
        XSSFWorkbook wb = new XSSFWorkbook(readFile);
// 再选择读取的Sheet
        XSSFSheet st = wb.getSheet("Sheet1");
        rownum = st.getLastRowNum();
        String[][] data = new String[rownum + 1][st.getRow(0).getLastCellNum()];

        for (i = 0; i < rownum + 1; i++) {
            XSSFRow row = st.getRow(i);

            for (j = 0; j < st.getRow(i).getLastCellNum(); j++) {
                XSSFCell cell = row.getCell(j);
                if (cell.getCellTypeEnum() != CellType.STRING && HSSFDateUtil.isCellDateFormatted(cell))
                {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                    Date date = HSSFDateUtil.getJavaDate(cell.getNumericCellValue());
                    String value = sdf.format(date);
                    data[i][j] = value;
                    System.out.println(value);
                }else{
                	cell.setCellType(Cell.CELL_TYPE_STRING);
                    data[i][j] = cell.getStringCellValue();
                }
   
                
            }
        }
        return data;
    }

    public static void main(String[] args) throws Exception {
        String path="D://workspace3//Test//src//test//resources//data//login.xlsx";
        //String path="src//test//resources//data//AddBatch.xlsx";
        for(int i=1;i<RowData_length(path);i++){
            for (int j=0;j<CellData_length(path);j++){
                System.out.print(LoginData(i,j,path)+" ");
            }
            System.out.println("");
        }
    }
}