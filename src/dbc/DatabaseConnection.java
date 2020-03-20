package dbc;
import java.sql.Connection;
import java.sql.DriverManager;
public class DatabaseConnection {
    private static final String DBDRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static final String DBURL = "jdbc:sqlserver://localhost:1433;DatabaseName=DBInsurance" ;
    private static final String DBUSER = "sa" ;
    private static final String DBPASSWORD = "s123456" ;
    private Connection conn ;
    public DatabaseConnection() throws Exception {
        Class.forName(DBDRIVER) ;
        this.conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD) ;
    }
    public Connection getConnection(){
        return this.conn ;
    }
    public void close() throws Exception {
        if(this.conn != null){
            try{
                this.conn.close() ;
            }catch(Exception e){
                throw e ;
            }
        }
    }
}
