package distanceCalculator;

import calculatorBase.BaseResult;
import calculatorBase.InputManager;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.logging.Logger;

public class Main extends calculatorBase.Main {

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

  public static BaseResult<DistanceValue> add() {
    return perform(CalculatorMode.ADD);
  }

  public static BaseResult<DistanceValue> multiply() {
    return perform(CalculatorMode.MULTIPLY);
  }

  public static BaseResult<DistanceValue> convert() {
    return perform(CalculatorMode.CONVERT);
  }

  private static BaseResult<DistanceValue> perform(CalculatorMode mode) {
    logger.info("" + mode);
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
        logger.warning("Invalid unit");
      }
    }
    return unit;
  }
}
