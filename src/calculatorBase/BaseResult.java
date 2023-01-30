package calculatorBase;

public class BaseResult<TypeOfResult> {

  private TypeOfResult result;

  public TypeOfResult getResult() {
    return result;
  }

  public BaseResult(TypeOfResult result) {
    this.result = result;
  }
}
