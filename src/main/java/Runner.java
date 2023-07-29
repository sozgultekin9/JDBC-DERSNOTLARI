import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Runner {

    public static void main(String[] args) throws SQLException {


        //JDBCUtils.connectToDatabase();
        //JDBCUtils.createStatement();
        JDBCUtils.execute("select * from companies");

        ResultSet resultSet = JDBCUtils.executeQuery("select * from companies");

        while (resultSet.next()){
            System.out.println(resultSet.getObject("company"));
        }

      List<Object>list = JDBCUtils.getColumnList("companies","company");
        System.out.println("list = " + list);

        JDBCUtils.closeConnection();





    }
}



