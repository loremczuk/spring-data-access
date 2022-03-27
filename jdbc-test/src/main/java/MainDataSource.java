import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainDataSource {

    public static final String DATABASE_NAME = "classicmodels";
    public static final String SERVER_NAME = "localhost";
    public static final String USER = "root";
    public static final String PASSWORD = "lubieplacki";

    public static void main(String[] args) {

        MysqlDataSource dataSource = new MysqlDataSource();

        dataSource.setDatabaseName(DATABASE_NAME);
        dataSource.setServerName(SERVER_NAME);
        dataSource.setUser(USER);
        dataSource.setPassword(PASSWORD);

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");

            while (resultSet.next()) {
                String productName = resultSet.getString("productName");
                double buyPrice = resultSet.getDouble("buyPrice");

                System.out.println(productName + ": " + buyPrice);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
