package distanceCalculator.models;

import calculatorBase.InputManager;
import calculatorBase.models.Input;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

public class DistanceInput implements Input {

  private DistanceValue[] distances;

  public DistanceValue[] getDistances() {
    return distances;
  }

  static Logger logger = Logger.getLogger(DistanceInput.class.getName());

  @Override
  public void take_input() {
    int numberOfDistances = Integer.valueOf(
      InputManager.take_input(logger, "Enter the number of distances ")
    );
    ArrayList<DistanceValue> arr = new ArrayList<>();

    for (int i = 0; i < numberOfDistances; i++) {
      String inp = InputManager.take_input(
        logger,
        "enter distance as <distance> <km,m,cm,mm>"
      );
      String[] str = inp.split(" ");
      try {
        arr.add(
          new DistanceValue(
            (Number) Double.valueOf(str[0]),
            stringToUnit(str[1])
          )
        );
      } catch (IllegalArgumentException e) {
        System.err.println("Invalid unit");
        i--;
      }
    }
    this.distances = arr.toArray(new DistanceValue[arr.size()]);
  }

  public static DistanceUnit stringToUnit(String input)
    throws IllegalArgumentException {
    HashMap<DistanceUnit, String> allowed_values = new HashMap<DistanceUnit, String>();
    allowed_values.put(DistanceUnit.KILOMETRE, "km");
    allowed_values.put(DistanceUnit.METRE, "m");
    allowed_values.put(DistanceUnit.CENTIMETRE, "cm");
    allowed_values.put(DistanceUnit.MILLIMETRE, "mm");
    DistanceUnit unit = null;

    for (DistanceUnit key : allowed_values.keySet()) {
      if (input.equals(allowed_values.get(key))) {
        unit = key;
        break;
      }
    }

    if (unit == null) {
      throw new IllegalArgumentException("Invalid unit");
    }

    return unit;
  }
}
