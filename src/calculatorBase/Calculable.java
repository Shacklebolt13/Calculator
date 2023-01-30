package calculatorBase;

public interface Calculable<OutputType> {
  public BaseResult<OutputType> getResult();
}
