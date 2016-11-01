//STEP 1. Import required packages
package genus;

import java.sql.Connection;
import java.sql.DriverManager;
import visao.TelaLogin;


public class Genus {
   // JDBC driver name and database URL
   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/genus?autoReconnect=true&useSSL=false";

   //  Database credentials
   static final String USER = "root";
   static final String PASS = "1234";
   
   public static void main(String[] args) {
       
       
       
       
       
       
    TelaLogin telaLogin = new TelaLogin();
    telaLogin.setVisible(true);
}//end main
}//end JDBCExample
