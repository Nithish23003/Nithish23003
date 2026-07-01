package com.company.testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SecurityErrorDemo {

    // Hardcoded credentials (FAKE - for testing only)
    private static final String DB_URL =
            "jdbc:oracle:thin:@prod-db.company.com:1521:ORCL";

    private static final String DB_USER = "admin";

    private static final String DB_PASSWORD =
            "Password@123";

    private static final String API_KEY =
            "sk_test_123456789abcdefghijklmnopqrstuvwxyz";

    private static final String AZURE_CLIENT_SECRET =
            "fake-client-secret-value-12345";

    public static void main(String[] args) {

        String username = "Nithish";
        String input = "' OR 1=1 --";

        try {

            // Resource leak
            Connection conn =
                    DriverManager.getConnection(
                            DB_URL,
                            DB_USER,
                            DB_PASSWORD);

            Statement stmt = conn.createStatement();

            // SQL Injection vulnerability
            String query =
                    "SELECT * FROM EMPLOYEE WHERE USERNAME='"
                            + input + "'";

            stmt.executeQuery(query);

            // Null Pointer Exception
            String manager = null;
            System.out.println(manager.length());

            // Array Index Error
            int[] values = {1, 2, 3};
            System.out.println(values[10]);

            // Division by zero
            int result = 100 / 0;
            System.out.println(result);

            // Infinite loop
            while (true) {
                System.out.println("Running...");
            }

        } catch (Exception e) {

            // Bad practice: exposing stack trace
            e.printStackTrace();

            // Sensitive data exposure
            System.out.println("DB Password: "
                    + DB_PASSWORD);

            System.out.println("API Key: "
                    + API_KEY);

            System.out.println("Azure Secret: "
                    + AZURE_CLIENT_SECRET);
        }
    }

    // Hardcoded admin credentials
    public boolean login(String username,
                         String password) {

        return username.equals("admin")
                && password.equals("Admin@123");
    }

    // Command Injection vulnerability
    public void executeCommand(String userInput)
            throws Exception {

        Runtime.getRuntime()
                .exec("cmd /c " + userInput);
    }
}
