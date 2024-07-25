import java.lang.module.Configuration;
import java.sql.*;
import java.util.Stack;

public class Task_2 {
	
//  lib  : DB    dbhost:   :dbport/dbname
	public static final String url = "jdbc:mysql://127.0.0.1:3306/jdbc-task-db-07";
    public static final String username = "root";
    public static final String password = "admin";
	
	
    
	public static void main(String[] args) {
        String sqlQuery = "select F_Name from employee where id=2";
        try (Connection conc = DriverManager.getConnection(url, username, password)){

//            createEmployeeTable(conc);
            insertEmployees(conc);
            batchUpdateEmployees(conc);

			
		} catch (Exception e) {
            e.printStackTrace();			
		}
    }

  
    public static void createEmployeeTable(Connection conn) throws SQLException{
    	String sql = "CREATE TABLE Employee (" +
                "Id INT PRIMARY KEY AUTO_INCREMENT," +
                "F_Name VARCHAR(50)," +
                "L_Name VARCHAR(50)," +
                "Sex CHAR(1)," +
                "Age INT," +
                "Address VARCHAR(255)," +
                "Phone_Number VARCHAR(20)," +
                "Vacation_Balance INT" +
                ")";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(sql);
    }
    
    
    private static void insertEmployees(Connection conn) throws SQLException {
        String sql = "INSERT INTO Employee (F_Name, L_Name, Sex, Age, Address, Phone_Number, Vacation_Balance) VALUES (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        // Insert 5 rows of sample data
        pstmt.setString(1, "John");
        pstmt.setString(2, "Doe");
        pstmt.setString(3, "M");
        pstmt.setInt(4, 30);
        pstmt.setString(5, "123 Main St");
        pstmt.setString(6, "1234567890");
        pstmt.setInt(7, 30);
        pstmt.addBatch();
        pstmt.executeBatch();
    }
    
    private static void batchUpdateEmployees(Connection conn) throws SQLException {
    String updateSQL = "UPDATE Employee SET Vacation_Balance = 45 WHERE Age > 45";
    String selectSQL = "SELECT Id, F_Name, Sex FROM Employee WHERE Age > 45";
    String updateNameSQL = "UPDATE Employee SET F_Name = ? WHERE Id = ?";

    try (Statement stmt = conn.createStatement();
         PreparedStatement pstmt = conn.prepareStatement(updateNameSQL)) {
        conn.setAutoCommit(false);
        stmt.execute(updateSQL);

        ResultSet rs = stmt.executeQuery(selectSQL);
        while (rs.next()) {
            int id = rs.getInt("Id");
            String fName = rs.getString("F_Name");
            String sex = rs.getString("Sex");

            String title = sex.equals("M") ? "Mr. " : "Mrs. ";
            pstmt.setString(1, title + fName);
            pstmt.setInt(2, id);
            pstmt.addBatch();
        }

        pstmt.executeBatch();
        conn.commit();
    }
}



}
