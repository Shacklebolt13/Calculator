package app.calculator.distanceCalculator.controller;

import app.calculator.calculatorBase.controller.CalculatorBase;
import app.calculator.calculatorBase.models.ResultUnit;
import app.calculator.distanceCalculator.models.CalculatorMode;
import app.calculator.distanceCalculator.models.DistanceInput;
import app.calculator.distanceCalculator.models.DistanceUnit;
import app.calculator.distanceCalculator.models.DistanceValue;

public class DistanceCalculator implements CalculatorBase<DistanceValue> {

  CalculatorMode workingMode;
  DistanceInput inputs;
  DistanceUnit unit;

  public DistanceCalculator(
    DistanceInput inputs,
    CalculatorMode mode,
    DistanceUnit unit
  ) {
    this.inputs = inputs;
    this.workingMode = mode;
    this.unit = unit;
  }

  @Override
  public ResultUnit<DistanceValue> getResult() {
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
        result = this.inputs.getDistances()[0];
        break;
      case MULTIPLY:
        res = 1;
        for (DistanceValue value : this.inputs.getDistances()) {
          res =
            res.doubleValue() *
            value.convert(DistanceUnit.METRE).getDistance().doubleValue();
        }
        result = new DistanceValue(res, DistanceUnit.METRE);
        break;
      default:
        break;
    }
    return new ResultUnit<DistanceValue>(result.convert(this.unit));
  }
}
