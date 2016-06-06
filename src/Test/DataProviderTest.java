package Test;

import java.math.BigDecimal;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utility.ExcelUtils;
public class DataProviderTest {

    @DataProvider(name = "Adding")

    public static Object[][] credentials() throws Exception {

        Object[][] testObject = ExcelUtils.getTableArray("D:/Java/TestingCalculator/src/DataTest/DataAdding.xlsx");
        return testObject;
    }

    @DataProvider(name = "Subtraction")

    public static Object[][] dataSub() throws Exception {

        Object[][] testObject = ExcelUtils.getTableArray("D:/Java/TestingCalculator/src/DataTest/DataSub.xlsx");
        return testObject;
    }

    @DataProvider(name = "Multi")

    public static Object[][] dataMulti() throws Exception {

        Object[][] testObject = ExcelUtils.getTableArray("D:/Java/TestingCalculator/src/DataTest/DataMulti.xlsx");
        return testObject;
    }

    @DataProvider(name = "Division")

    public static Object[][] dataDiv() throws Exception {

        Object[][] testObject = ExcelUtils.getTableArray("D:/Java/TestingCalculator/src/DataTest/DataDiv.xlsx");
        return testObject;
    }

    @Test(dataProvider = "Adding")
    public void testAdding(double a, double b, double c) {

        double actualResult = a + b;
        double expectedResult = c;
        Assert.assertEquals(actualResult, expectedResult, "Addition method failed");
    }

    @Test(dataProvider = "Subtraction")
    public void testSubtraction(double a, double b, double c) {
        double actualResult = BigDecimal.valueOf(a).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue() - BigDecimal.valueOf(b).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue();
        double expectedResult = BigDecimal.valueOf(c).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue();
        Assert.assertEquals(actualResult, expectedResult, "Addition method failed");
    }

    @Test(dataProvider = "Multi")
    public void testMulti(double a, double b, double c) {
        double actualResult = BigDecimal.valueOf(a).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue() * BigDecimal.valueOf(b).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue();
        double expectedResult = BigDecimal.valueOf(c).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue();
        Assert.assertEquals(actualResult, expectedResult, "Addition method failed");
    }

    @Test(dataProvider = "Division")
    public void testDivision(double a, double b, double c) {
        if (b == 0){
            System.out.println("Division by zero!");
            return;
        }
        double actualResult = BigDecimal.valueOf(a).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue() / BigDecimal.valueOf(b).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue();
        double expectedResult = BigDecimal.valueOf(c).setScale(2,BigDecimal.ROUND_HALF_DOWN).doubleValue();
        Assert.assertEquals(actualResult, expectedResult, "Addition method failed");
    }
}