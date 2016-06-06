package Test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import org.testng.annotations.DataProvider;

import utility.ExcelUtils;

public class DataProviderWithExcel {

    @DataProvider

    public Object[][] Authentication() throws Exception {

        Object[][] testObjArray = ExcelUtils.getTableArray("D://Java//TestingCalculator//src//testData//DataAdding.xlsx");

        return (testObjArray);

    }
}