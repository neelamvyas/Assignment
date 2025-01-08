package Assignment_3;

/*
 * Theory: Insert: Adding a new record to the database. Update: Modifying
 * existing records in the database. Select: Retrieving records from the
 * database. Delete: Removing records from the database.
 */
import java.sql.*;

public class JDBCCrudOperations {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb", "root", "password")) {

            // Insert
            PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO users (id, name) VALUES (?, ?)");
            insertStmt.setInt(1, 3);
            insertStmt.setString(2, "Charlie");
            insertStmt.executeUpdate();
            System.out.println("Record inserted!");

            // Update
            PreparedStatement updateStmt = conn.prepareStatement("UPDATE users SET name=? WHERE id=?");
            updateStmt.setString(1, "Charlotte");
            updateStmt.setInt(2, 3);
            updateStmt.executeUpdate();
            System.out.println("Record updated!");

            // Select
            Statement selectStmt = conn.createStatement();
            ResultSet rs = selectStmt.executeQuery("SELECT * FROM users");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
            }

            // Delete
            PreparedStatement deleteStmt = conn.prepareStatement("DELETE FROM users WHERE id=?");
            deleteStmt.setInt(1, 3);
            deleteStmt.executeUpdate();
            System.out.println("Record deleted!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
