package main.java.com.java.code.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcutil {

    private static Connection connection = null;
    private static String url = "jdbc:mysql://localhost:3306/javaee?serverTimezone=UTC&useSSL=false";
    private static String username = "root";
    private static String password = "123456";

    /**
     * A private constructor to prevent being instantiated.
     */
    private jdbcutil() {
    }

    /**
     * create a JDBC connection depending on the properties file--"jdbc.properties".
     *
     * @return
     */
    public static Connection getConnection() {
        if (connection != null) return connection;

        String driver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.close();
            } catch (SQLException e1) {
                e.printStackTrace();
            }
        }

        return connection;
    }

    //测试JDBC连接是否成功
    public static void main(String[] args) {
        Connection connection = getConnection();
        if (connection != null)
            System.out.println("连接成功");
        else
            System.out.println("连接失败");
    }
}
