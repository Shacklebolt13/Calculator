package calculatorBase;

public abstract class Result<TypeOfResult> {

  private BaseResult<TypeOfResult>[] results;

  public BaseResult<TypeOfResult>[] getResults() {
    return results;
  }
}
