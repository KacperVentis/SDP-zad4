import java.sql.*;

public class Main {

    static final String url = "jdbc:postgresql://localhost/myDb";
    static final String user = "postgres";
    static final String password = "123";

    public static void main(String[] args) {
        try(Connection connect = DriverManager.getConnection(url,user,password)) {
            Statement statement = connect.createStatement();
            //SELECT
            ResultSet result = statement.executeQuery("SELECT * FROM weather");
            while(result.next()) {
                System.out.println("city: "+result.getString("city"));
                System.out.println("tempp_lo: "+result.getInt("temp_lo"));
                System.out.println("temp_hi: "+result.getInt("temp_hi"));
                System.out.println("prcp: "+result.getDouble("prcp"));
                System.out.println("date:"+result.getString("date"));

            }
            result.close();

            //INSERT
            statement.executeUpdate("INSERT INTO  weather VALUES ('Koszalin', 1, 20, 1.3, 2021-12-01)");

            //DELETE
            statement.executeUpdate("DELETE FROM weather WHERE city='Koszalin'");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } ;
    }
}
