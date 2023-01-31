package calculatorBase.models;

public abstract class Result<TypeOfResult> {

  private ResultUnit<TypeOfResult>[] results;

  public ResultUnit<TypeOfResult>[] getResults() {
    return results;
  }

  public void showResults() {
    for (ResultUnit<TypeOfResult> result : results) {
      System.out.println(result);
    }
  }

  @Override
  public String toString() {
    String str = "";
    for (ResultUnit<TypeOfResult> result : results) {
      str += result.toString() + " ";
    }
    return str;
  }
}
