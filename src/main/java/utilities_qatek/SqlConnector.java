package utilities_qatek;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class SqlConnector {
    private static final String User = ReadConfigFiles.getPropertyValues("DbUser");
    private static final String Password = ReadConfigFiles.getPropertyValues("DbPassword");
    private static final String Host = ReadConfigFiles.getPropertyValues("DbHost");
    private static final String Port = ReadConfigFiles.getPropertyValues("DbPort");
    private static final String DatabaseName = ReadConfigFiles.getPropertyValues("DbName");

    private static final Logger LOGGER = LogManager.getLogger(SqlConnector.class);
    //private static final String ConnectionUrl = "jdbc:postgresql://localhost:5432/mortgage_calculator";
    //private static final String ConnectionUrl = "jdbc:postgresql://" + Host + ":" + Port + "/" + DatabaseName;
    private static final String ConnectionUrl = String.format("jdbc:postgresql://%s:%s/%s", Host,Port,DatabaseName);

    /**
     *connect to the Postgres database
     * @return a connection object
     * @throws Exception if failed to connect to the database
     */
    private static Connection connect() throws Exception {
      LOGGER.debug(ConnectionUrl);
      Connection conn;
      try {
          conn = DriverManager.getConnection(ConnectionUrl, User, Password);
          if (conn !=null)
          {
              LOGGER.debug("Database connection is successful");
          }
      }
      catch (SQLException e)
      {
          throw new Exception("SQL connection exception is: " + e.getMessage());
      }
      return conn;
    }

    /**
     * Reading Data from the Database
     * @param SQL is used to send the SQL query
     * @return a ResultSet object
     * @throws Exception if failed to execute queries
     */
    public static ResultSet readData(String SQL) throws Exception {
        ResultSet rs;
        try
        {
           Connection conn = connect();
           Statement stmt = conn.createStatement();
           rs = stmt.executeQuery(SQL);
        }
        catch (SQLException e)
        {
            throw new Exception("SQL Result set Exception: " + e.getMessage());
        }
        return rs;
    }
}
