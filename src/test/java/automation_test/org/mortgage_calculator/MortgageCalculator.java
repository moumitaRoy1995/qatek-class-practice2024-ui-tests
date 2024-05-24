package automation_test.org.mortgage_calculator;

import automation_test.BaseClass;
import org.testng.annotations.Test;
import page_objects.Home;
import utilities_qatek.DateUtils;

public class MortgageCalculator extends BaseClass {
    @Test
    public void calculateMonthlyPayment()
    {
        String[] date = DateUtils.returnNextMonth();
        //String month = date[0];
        //String year = date[1];
        new Home(driver)
                .typeHomePrice("300000")
                .clickDownPaymentInDollar()
                .typeDownPayment("60000")
                .typeLoanAmount("240000")
                .typeInterestRate("3")
                .typeLoanTermYears("30")
                .selectStartMonth(date[0])
                .typeYear(date[1])
                .typePropertyTax("5000")
                .typePmi("0.5")
                .typeHomeOwnerInsurance("1000")
                .typeMonthlyHOA("100")
                .selectLoanType("FHA")
                .selectBuyOrRefinance("Buy")
                .clickOnCalculateButton()
                .validateTotalMonthlyPayment("$1,611.85");
    }
}
