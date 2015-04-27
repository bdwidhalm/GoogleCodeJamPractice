import java.io.Console;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PasswordHashingDemo
{
  // map of User, Password Hashed
  Map<String, String> DB = new HashMap<String, String>();

  public static final String SALT = "my-salt-text";

  public static void main(String args[])
  {
    PasswordHashingDemo demo = new PasswordHashingDemo();

    // Scanner input = new Scanner(System.in);
    // String username = "";
    // String password = "";
    // username = input.nextLine();
    // password = input.nextLine();

    Console console = System.console();

    if (console == null)
    {
      System.out.println("Couldn't get Console instance");
      System.exit(0);
    }

    String username = console.readLine("Please create a username: ");
    String password1 = new String(console.readPassword("Please enter a password: "));
    String password2 = new String(console.readPassword("Please re-enter a password: "));

    if (!password1.equals(password2))
    {
      System.out.println("Passwords don't match, Setup Failed!");
    }
    else
    {
      System.out.println("Setup Success!");
      demo.signup(username, password1);

      console.flush();
      System.out.println("Test Logging in...");
      System.out.println();
      System.out.println();
      System.out.println();

      String usernameLogin = console.readLine("Please enter your username: ");
      String passwordLogin = new String(console.readPassword("Please enter your password: "));

      if (demo.login(usernameLogin, passwordLogin))
      {
        System.out.println("Login Successfull!");
      }
      else
      {
        System.out.println("Login Failed!");
      }

    }
  }

  public void signup(String username, String password)
  {
    String saltedPassword = SALT + password;
    String hashedPassword = generateHash(saltedPassword);
    DB.put(username, hashedPassword);
  }

  public Boolean login(String username, String password)
  {
    Boolean isAuthenticated = false;

    // remember to use the same SALT value use used while storing password
    // for the first time.
    String saltedPassword = SALT + password;
    String hashedPassword = generateHash(saltedPassword);

    String storedPasswordHash = DB.get(username);
    if (hashedPassword.equals(storedPasswordHash))
    {
      isAuthenticated = true;
    }
    else
    {
      isAuthenticated = false;
    }
    return isAuthenticated;
  }

  public static String generateHash(String input)
  {
    StringBuilder hash = new StringBuilder();

    try
    {
      MessageDigest sha = MessageDigest.getInstance("SHA-1");
      byte[] hashedBytes = sha.digest(input.getBytes());
      char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
          'a', 'b', 'c', 'd', 'e', 'f' };
      for (int idx = 0; idx < hashedBytes.length; ++idx)
      {
        byte b = hashedBytes[idx];
        hash.append(digits[(b & 0xf0) >> 4]);
        hash.append(digits[b & 0x0f]);
      }
    }
    catch (NoSuchAlgorithmException e)
    {
      // handle error here.
    }

    System.out.println("Hash: " + hash.toString());

    return hash.toString();
  }

}