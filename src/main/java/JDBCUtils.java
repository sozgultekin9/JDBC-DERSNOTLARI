import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCUtils {

    private static Connection connection;//Connection variable'ın başka methodlarda da kullanılabilmesi için 'class level'da belirtiliyor.
    private static Statement statement;


    //Bu method database'e bağlanıp bir Connection data return edecek
    public static Connection connectToDatabase() {

        try {
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }

    //Bu method connectToDatabase() methodu çağırarak statement dönüyor
    public static Statement createStatement() {

        try {
            statement = connectToDatabase().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return statement;

    }

    //Bu method String bir SQL query'yi createStatement() methodu çağırarak çalıştırıp boolean dönüyor
    public static boolean execute(String sql) {

        try {
            return createStatement().execute(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    //Bu method String bir SQL query'yi createStatement() methodu çağırarak çalıştırıp ResultSet dönüyor
    public static ResultSet executeQuery(String sql) {

        try {
            return createStatement().executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //Bu method paramterede belirtilen table ve column ismine göre bir query çalıştırıp ilgili sütun objelerini bir list olarak dönüyor
    public static List<Object> getColumnList(String table, String column) throws SQLException {

        List<Object> list = new ArrayList<>();
        String query = "select " + column + " from " + table;

        ResultSet resultSet = executeQuery(query);
        while (resultSet.next()) {
            list.add(resultSet.getObject(column));
        }

        return list;
    }

    public static void closeConnection() {
    }
}


