package calculatorBase.controller;

import calculatorBase.models.ResultUnit;

public interface CalculatorBase<OutputType> {
  public ResultUnit<OutputType> getResult();
}
