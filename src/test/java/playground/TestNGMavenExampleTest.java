package playground;

import data.DataStore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities_qatek.CsvConnector;
import utilities_qatek.DateUtils;
import utilities_qatek.ReadConfigFiles;
import utilities_qatek.SqlConnector;

import java.sql.ResultSet;
import java.util.Arrays;

public class TestNGMavenExampleTest {
  /*  private static final Logger LOGGER = LogManager.getLogger(TestNGMavenExampleTest.class);

    @Test(dataProvider = "MultipleColumnValues", dataProviderClass = DataStore.class)

    public void run(String name, String state, int zipCode)
    {
        System.out.println("Name is: " + name);
        System.out.println("State is: " + state);
        System.out.println("Zip Code is: " + zipCode);
    }
        /*try {
            String value = ReadConfigFiles.getPropertyValues("DbUser");
            String value1 = ReadConfigFiles.getPropertyValues("DbPassword");
            String value2 = ReadConfigFiles.getPropertyValues("DbName");
            LOGGER.info("This is info message " + value);
            LOGGER.info("This is info message " + value1);
            LOGGER.info("This is info message " + value2);
        }
        catch (Exception e)
        {
         LOGGER.error(e.getMessage());
        }*/


        //not throws exception

        //logger
        /*LOGGER.debug("This is a debug message");
        LOGGER.info("This is info message");
        LOGGER.warn("This is the warn message");
        LOGGER.error("This is an error");
        LOGGER.fatal("This is dangerous");*/
        /*String[] date = DateUtils.returnNextMonth();
        String month = date[0];
        String year = date[1];
        LOGGER.info("Next Month: " + month);
        LOGGER.info("Next Month: " + year);*/

        /*ResultSet resultSet = SqlConnector.readData("select * from monthly_mortgage");
        while(resultSet.next())
        {
            String homeValue = resultSet.getString("homevalue");
            LOGGER.info("The home price " + homeValue);
        }*/

    //CSV connector



    //This is github practice
    @Test
    public void run() throws Exception {
        String[] lines;
        lines = CsvConnector.readCsvData("src/test/resources/test_data.csv");
        System.out.println(Arrays.toString(lines));
        for(String line: lines)
        {
            System.out.println("Each line: " + line);
            String[] dataArr = line.split(",");
            System.out.println("First Name: " + dataArr[0]);
            System.out.println("Last Name: " + dataArr[1]);
            System.out.println("Designation Name: " + dataArr[2]);
            System.out.println("Phone Number: " + dataArr[3]);
            System.out.println("Zip Code: " + dataArr[4]);
            System.out.println("State Name: " + dataArr[5]);
        }
    }

}
