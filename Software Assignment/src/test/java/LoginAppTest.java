import org.example.LoginApp;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginAppTest {

    private static LoginApp loginApp;

    @BeforeAll
    static void setup() {
        // Initialize the LoginApp class before running tests
        loginApp = new LoginApp();
    }

    @AfterAll
    static void teardown() {
        // Perform cleanup if necessary
        loginApp = null;
    }

    @Test
    void testValidUserLogin() {
        // Test Case 1: Valid user with correct email and password
        String email = "johndoe@example.com";
        String password = "password123";
        String result = loginApp.authenticateUser(email, password);
        assertEquals("John Doe", result, "Valid credentials should return the correct user name.");
    }

    @Test
    void testInvalidPassword() {
        // Test Case 2: Valid email but incorrect password
        String email = "johndoe@example.com";
        String password = "wrongpassword";
        String result = loginApp.authenticateUser(email, password);
        assertEquals("John Doe", result, "Invalid Password");
    }

    @Test
    void testInvalidEmail() {
        // Test Case 3: Invalid email with any password
        String email = "invalid@example.com";
        String password = "password123";
        String result = loginApp.authenticateUser(email, password);
        assertEquals("John Doe", result, "Email is Invalid.");
    }

    @Test
    void testEmptyEmailAndPassword() {
        // Test Case 4: Empty email and password fields
        String email = "";
        String password = "";
        String result = loginApp.authenticateUser(email, password);
        assertEquals("John Doe", result, "Email and password are Empty.");
    }

    @Test
    void testNullEmailAndPassword() {
        // Test Case 5: Null email and password
        String email = null;
        String password = null;
        String result = loginApp.authenticateUser(email, password);
        assertEquals("John Doe", result, "Email and password are Null.");
    }
}
