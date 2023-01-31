package app.calculator.calculatorBase.controller;

import app.calculator.calculatorBase.models.ResultUnit;

public interface CalculatorBase<OutputType> {
  public ResultUnit<OutputType> getResult();
}
