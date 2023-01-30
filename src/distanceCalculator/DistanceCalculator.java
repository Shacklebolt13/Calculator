package distanceCalculator;

import calculatorBase.BaseResult;
import calculatorBase.Calculable;

public class DistanceCalculator implements Calculable<DistanceValue> {

  CalculatorMode workingMode;
  DistanceInput inputs;
  DistanceUnit unit;

  DistanceCalculator(
    DistanceInput inputs,
    CalculatorMode mode,
    DistanceUnit unit
  ) {
    this.inputs = inputs;
    this.workingMode = mode;
    this.unit = unit;
  }

  @Override
  public BaseResult<DistanceValue> getResult() {
    DistanceValue result = null;
    Number res = 0;
    switch (this.workingMode) {
      case ADD:
        res = 0;
        for (DistanceValue value : this.inputs.getDistances()) {
          res =
            res.doubleValue() +
            value.convert(DistanceUnit.METRE).getDistance().doubleValue();
        }
        result = new DistanceValue(res, DistanceUnit.METRE);
        break;
      case CONVERT:
        result = this.inputs.getDistances()[0].convert(this.unit);
        break;
      case MULTIPLY:
        res = 1;
        for (DistanceValue value : this.inputs.getDistances()) {
          res =
            res.doubleValue() +
            value.convert(DistanceUnit.METRE).getDistance().doubleValue();
        }
        result = new DistanceValue(res, DistanceUnit.METRE);
        break;
      default:
        break;
    }
    return new BaseResult<DistanceValue>(result);
  }
}
