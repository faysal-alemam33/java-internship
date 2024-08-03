// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class Task_1 {
//	public static final String url = "jdbc:mysql://127.0.0.1:3306/jdbc-task-db-07";
//    public static final String username = "root";
//    public static final String password = "admin";
//	
	
    public static void main(String[] args) {
    	String url = "jdbc:mysql://127.0.0.1:3306/jdbc-task-db-07";
         String username = "root";
        String password = "admin";
    	
    	try (Connection conn = DriverManager.getConnection(url, username, password)){
    		Statement statement = conn.createStatement();

            String query = "SELECT Id, F_Name, L_Name, Sex, Age, Address, Phone_Number, Vacation_Balance FROM employee"; 
            ResultSet resultSet = statement.executeQuery(query);
            
            
            while (resultSet.next()) {
                String field1 = resultSet.getString("Id");
                String field2 = resultSet.getString("F_Name");
                String field3 = resultSet.getString("L_Name");

            }
            
            resultSet.close();
            statement.close();
            conn.close();
            
    		
    	}catch (Exception e) {
    		e.printStackTrace();

		}
    	
    }
}