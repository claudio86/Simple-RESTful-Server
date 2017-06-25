package api;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class Connect {


    public String queryUser(String name ) throws Exception {

        Connection connection = getConnection();
        try {
            String query = "SELECT * FROM users WHERE `name` = '" + name + "'";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            Users usr = new Users();
            while (rs.next()) {
                usr.setUser((rs.getString("name") + rs.getInt("id")));
                return usr.getUser();
            }
        } finally {
            closeConnection(connection);
        }
        return null;
    }

    public List queryUsers() throws Exception {

        Connection connection = getConnection();
        try {
            String query = "SELECT * FROM users";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            List username = new ArrayList();
            Users usr = new Users();
            while (rs.next()) {
                usr.setUser((rs.getString("name") + rs.getInt("id")));
            }
            return usr.getUsers();
        } finally {
            closeConnection(connection);
        }
    }

    public void insertQuery( String query ){
        Connection connection = null;
        List<String> arr = new ArrayList<>();
        arr.add("item1");
        arr.add("item2");
        arr.add("item3");
        arr.add("item4");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String connectionString = "jdbc:mysql://localhost:3306/helper?user=root&password=";
            connection = DriverManager.getConnection(connectionString);
            PreparedStatement prepared = connection.prepareStatement( query );
            for (int n = 0 ; n < arr.size(); n++) {
                System.out.println(n);
            }
            prepared.setString(1, "ciccio3");
            prepared.setString(2, "63");
            prepared.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("eeerrore");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                // gestione errore in chiusura
            }
        }

    }

    private static Connection getConnection() throws Exception {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/helper?Unicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "");
        return connection;
    }

    private static void closeConnection(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }

}
