package app.calculator.calculatorBase;

import java.util.Scanner;
import java.util.logging.Logger;

public class InputManager {

  public static String take_input(Logger logger, String message) {
    System.out.println(message);
    Scanner scanner = new Scanner(System.in);
    String input = scanner.nextLine();
    // scanner.close();
    return input;
  }

  //loop until a valid input is given
  public static Number take_input_number(Logger logger, String message) {
    String inp = take_input(logger, message);
    Number input = null;
    try {
      input = Double.parseDouble(inp);
    } catch (NumberFormatException e) {
      System.err.println("Invalid input");
      input = take_input_number(logger, message);
    }
    return input;
  }
}
