import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DBUtil
{
   // private static final String oraUser = "hr";
   // private static final String myOraPwd ="test123";
  
  public static Connection getConenction(DBType dbtype) 
{
        Conenction con = new Connection();
        switch(DBType)
        {
            case oradb:
                //Code here
            case MySQLDB:
                Properties props = new Properties();

                String fileName = "src/main/resources/db.properties";

                try (FileInputStream fis = new FileInputStream(fileName)) {
                    props.load(fis);
                } catch (IOException ex) {
                   Logger lgr = Logger.getLogger(ComLineDSEx.class.getName());
                   lgr.log(Level.SEVERE, ex.getMessage(), ex);
        

                con.setURL(props.getProperty("mysql.url"));
                con.setUser(props.getProperty("mysql.username"));
                con.setPassword(props.getProperty("mysql.password"));
        }

        return con;
  }
