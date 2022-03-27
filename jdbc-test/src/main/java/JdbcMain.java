import java.sql.*;

public class JdbcMain {

    public static final String URL = "jdbc:mysql://localhost:3306/classicmodels";
    public static final String USER = "root";
    public static final String PASSWORD = "lubieplacki";

    public static void main(String[] args) {

        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM products");

            while (resultSet.next()) {

                String productName = resultSet.getString("productName");
                String buyPrice = resultSet.getString("buyPrice");
                String productLine = resultSet.getString(3);
                System.out.println(productLine + ": " + productName + ": " + buyPrice);
            }



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
