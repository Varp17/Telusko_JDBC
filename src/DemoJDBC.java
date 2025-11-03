import org.postgresql.Driver;

import java.sql.*;


public class DemoJDBC {
    public static void main(String[] args) throws Exception {

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:postgresql://localhost:5433/demo";
        String uname = "postgres";
        String pass = "123456";
        String query = "select sname from student WHERE sid=1";
        Connection con = DriverManager.getConnection(url,uname,pass);
        System.out.println("COnnection Establshid");
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        System.out.println(rs.next());

        String name = rs.getString("sname");
        System.out.println(name);

        con.close();
        System.out.println("Connection Closed");
    }
}
