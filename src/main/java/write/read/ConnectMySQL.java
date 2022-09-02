package write.read;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectMySQL {
    private static Connection conn = null;
    private static String JDBC_driver = "com.mysql.cj.jdbc.Driver";
    private static String JDBC_url = "jdbc:mysql://localhost:3306/simpledatabase";
    private static String JDBC_user = "root";
    private static String JDBC_password = "483672";

    public static Connection getConnect () {
        downloadDriver();
        entry();
        return conn;
    }
    private static void downloadDriver () {
        try { // подключаем драйвер СУБД
            Class.forName(JDBC_driver);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static void entry () {
        try {
            conn = DriverManager.getConnection(JDBC_url, JDBC_user, JDBC_password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
