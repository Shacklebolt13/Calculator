package calculatorBase;

public abstract class Result<TypeOfResult> {

  private BaseResult<TypeOfResult>[] results;

  public BaseResult<TypeOfResult>[] getResults() {
    return results;
  }

  public void showResults() {
    for (BaseResult<TypeOfResult> result : results) {
      System.out.println(result);
    }
  }

  @Override
  public String toString() {
    String str = "";
    for (BaseResult<TypeOfResult> result : results) {
      str += result + " ";
    }
    return str;
  }
}
