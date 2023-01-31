package app.calculator.distanceCalculator.connector;

import app.calculator.calculatorBase.InputManager;
import app.calculator.calculatorBase.models.ResultUnit;
import app.calculator.distanceCalculator.controller.DistanceCalculator;
import app.calculator.distanceCalculator.models.CalculatorMode;
import app.calculator.distanceCalculator.models.DistanceInput;
import app.calculator.distanceCalculator.models.DistanceUnit;
import app.calculator.distanceCalculator.models.DistanceValue;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main extends app.calculator.calculatorBase.connector.Main {

  static Logger logger = Logger.getLogger(Main.class.getName());

  @Override
  public HashMap<String, Method> getMethods()
    throws UnsupportedOperationException {
    HashMap<String, Method> methods = new HashMap<String, Method>();
    try {
      methods.put("Add", Main.class.getMethod("add"));
      methods.put("Multiply", Main.class.getMethod("multiply"));
      methods.put("Convert", Main.class.getMethod("convert"));
    } catch (NoSuchMethodException | SecurityException e) {
      e.printStackTrace();
      throw new UnsupportedOperationException();
    }
    return methods;
  }

  public static ResultUnit<DistanceValue> add() {
    return perform(CalculatorMode.ADD);
  }

  public static ResultUnit<DistanceValue> multiply() {
    return perform(CalculatorMode.MULTIPLY);
  }

  public static ResultUnit<DistanceValue> convert() {
    return perform(CalculatorMode.CONVERT);
  }

  private static ResultUnit<DistanceValue> perform(CalculatorMode mode) {
    logger.log(Level.FINE, "" + mode);
    DistanceInput input = new DistanceInput();
    input.take_input();
    DistanceUnit unit = getUnit();

    DistanceCalculator calculator = new DistanceCalculator(input, mode, unit);
    return calculator.getResult();
  }

  private static DistanceUnit getUnit() {
    DistanceUnit unit = null;
    while (unit == null) {
      String inp = InputManager.take_input(
        logger,
        "enter unit as <km,m,cm,mm>"
      );
      try {
        unit = DistanceInput.stringToUnit(inp);
      } catch (IllegalArgumentException e) {
        System.err.println("Invalid unit");
      }
    }
    return unit;
  }
}
