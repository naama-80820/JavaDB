import java.sql.*;

public class SqlQuery {
    public int runCreateQuery(String sql)
    {
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","123456");
            System.out.println("runInsert: " + sql);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData  rsmd = rs.getMetaData();
            statement.close();
            connection.close();
            return Integer.parseInt(rsmd.getColumnName(0));
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public ResultSet runReadQuery(String sql)
    {
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","123456");
            System.out.println("runGetQuery: " + sql);
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            ResultSetMetaData  rsmd = rs.getMetaData();
            statement.close();
            connection.close();
            return rs;
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void runUpdateQuery(String sql)
    {
        try
        {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","123456");
            Statement statement = connection.createStatement();
            System.out.println("runUpdateQuery: " + sql);
            statement.executeQuery(sql);
            statement.close();
            connection.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void runDeleteQuery(String sql)
    {
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/customer","root","123456");
            Statement statement = connection.createStatement();)
        {

            System.out.println("runDeleteQuery: " + sql);
            statement.executeQuery(sql);
            statement.close();
            connection.close();
        }
        catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
