package calculatorBase.models;

public class ResultUnit<TypeOfResult> {

  private TypeOfResult result;

  public TypeOfResult getResult() {
    return result;
  }

  public ResultUnit(TypeOfResult result) {
    this.result = result;
  }

  @Override
  public String toString() {
    return result.toString();
  }
}
