package utility;

import java.io.FileInputStream;

import java.io.FileNotFoundException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFCell;

import org.apache.poi.xssf.usermodel.XSSFRow;

import org.apache.poi.xssf.usermodel.XSSFSheet;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

    private static XSSFSheet ExcelWSheet;

    private static XSSFWorkbook ExcelWBook;

    private static XSSFCell Cell;

    private static XSSFRow Row;

    public static Object[][] getTableArray(String FilePath) throws Exception {

        Double[][] tabArray = null;

        try {

            FileInputStream ExcelFile = new FileInputStream(FilePath);

            // Access the required test data sheet

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheetAt(0);

            int startRow = 1;

            int startCol = 0;

            int ci,cj;

            int totalRows = ExcelWSheet.getLastRowNum();

            // you can write a function as well to get Column count

            int totalCols = 3;

            tabArray=new Double[totalRows][totalCols];

            ci=0;

            for (int i=startRow;i<=totalRows;i++, ci++) {

                cj=0;

                for (int j=startCol;j<=totalCols-1;j++, cj++){

                    tabArray[ci][cj]=getCellData(i,j);

                    System.out.println(tabArray[ci][cj]);

                }

            }

        }

        catch (FileNotFoundException e){

            System.out.println("Could not read the Excel sheet");

            e.printStackTrace();

        }

        catch (IOException n){

            System.out.println("Could not read the Excel sheet");

            n.printStackTrace();

        }

        return(tabArray);

    }

    public static Double getCellData(int RowNum, int ColNum) throws Exception {

            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

        {

            Double CellData = Cell.getNumericCellValue();

                return CellData;

            }


        }

    }
