package Assignment_3;

/*
 * Objective: To understand and implement JDBC functionality to call a stored
 * procedure with IN and OUT parameters using CallableStatement.
 * 
 * Theory Recap: CallableStatement:
 * 
 * Used to execute stored procedures in a database. Supports IN, OUT, and INOUT
 * parameters. Stored Procedure:
 * 
 * A precompiled SQL statement stored in the database that can perform specific
 * operations. Accepts input parameters, processes logic, and returns output
 * parameters. Step-by-Step Implementation: 1. Create a Stored Procedure in
 * MySQL The procedure accepts an employee ID (emp_id) as an IN parameter and
 * returns the employee's full name as an OUT parameter. sql Copy code DELIMITER
 * $$
 * 
 * CREATE PROCEDURE GetEmployeeDetails( IN emp_id INT, OUT emp_fullname
 * VARCHAR(100) ) BEGIN SELECT CONCAT(fname, ' ', lname) INTO emp_fullname FROM
 * employees WHERE id = emp_id; END $$
 * 
 * DELIMITER ;
 */
import java.sql.*;

public class CallableStatementLabExercise {
    public static void main(String[] args) {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "root";
        String password = "password";

        try {
            // Step 1: Establish connection to the database
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established successfully.");

            // Step 2: Prepare the CallableStatement
            CallableStatement cstmt = conn.prepareCall("{call GetEmployeeDetails(?, ?)}");

            // Step 3: Set IN parameter value
            int empId = 101; // Replace with the desired employee ID
            cstmt.setInt(1, empId);

            // Step 4: Register OUT parameter
            cstmt.registerOutParameter(2, Types.VARCHAR);

            // Step 5: Execute the stored procedure
            cstmt.execute();

            // Step 6: Retrieve the OUT parameter value
            String employeeFullName = cstmt.getString(2);

            // Step 7: Display the result
            if (employeeFullName != null) {
                System.out.println("Employee Full Name: " + employeeFullName);
            } else {
                System.out.println("No employee found with ID: " + empId);
            }

            // Step 8: Close the connection
            cstmt.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

