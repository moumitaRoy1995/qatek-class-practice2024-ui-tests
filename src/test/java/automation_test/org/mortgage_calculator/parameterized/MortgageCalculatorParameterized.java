package automation_test.org.mortgage_calculator.parameterized;

import automation_test.BaseClass;
import org.testng.annotations.Test;
import page_objects.Home;
import utilities_qatek.DateUtils;
import utilities_qatek.SqlConnector;

import java.sql.ResultSet;

public class MortgageCalculatorParameterized extends BaseClass {
    @Test
    public void calculateMonthlyPayment() throws Exception {
        String[] date = DateUtils.returnNextMonth();
        //String month = date[0];
        //String year = date[1];
        ResultSet rs = SqlConnector.readData("select * from monthly_mortgage");
        while (rs.next()) {
            new Home(driver)
                    .typeHomePrice(rs.getString("homevalue"))
                    .clickDownPaymentInDollar()
                    .typeDownPayment(rs.getString("downpayment"))
                    .typeLoanAmount(rs.getString("loanamount"))
                    .typeInterestRate(rs.getString("interestrate"))
                    .typeLoanTermYears(rs.getString("loanterm"))
                    .selectStartMonth(date[0])
                    .typeYear(date[1])
                    .typePropertyTax(rs.getString("propertytax"))
                    .typePmi(rs.getString("pmi"))
                    .typeHomeOwnerInsurance(rs.getString("homeownerinsurance"))
                    .typeMonthlyHOA(rs.getString("monthlyhoa"))
                    .selectLoanType(rs.getString("loantype"))
                    .selectBuyOrRefinance(rs.getString("buyorrefi"))
                    .clickOnCalculateButton()
                    .validateTotalMonthlyPayment(rs.getString("totalmonthlypayment"));
        }
    }
}

