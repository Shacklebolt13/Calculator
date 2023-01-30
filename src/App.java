import calculatorBase.InputManager;
import calculatorBase.Main;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Logger;

public class App {

  static Logger logger = Logger.getLogger(App.class.getName());

  // array of classes that extend Main
  private static HashMap<String, Class<? extends Main>> moduleMap = new HashMap<>();
  private static HashMap<String, Method> methodMap = new HashMap<>();
  private static ArrayList<String> methodNames = new ArrayList<>();

  static {
    moduleMap.put("Distance Calculator", distanceCalculator.Main.class);
    //add more modules here
  }

  public static void main(String[] args) throws Exception {
    App app = new App();
    app.parseAllModules();
    app.loop();
    System.out.println(
      "Welcome to Calculator: Select from the following modes"
    );
  }

  private void parseAllModules()
    throws InstantiationException, IllegalAccessException {
    HashMap<String, Method> methods = new HashMap<>();
    for (String key : moduleMap.keySet()) {
      Class<? extends Main> module = moduleMap.get(key);
      Main instance = module.newInstance();
      HashMap<String, Method> moduleMethodsMap = instance.getMethods();
      for (String methodKey : moduleMethodsMap.keySet()) {
        String name = key.trim() + " : " + methodKey.trim();
        methods.put(name, moduleMethodsMap.get(methodKey));
        methodNames.add(name);
      }
    }
    methodMap = methods;
  }

  private void printAllModules() {
    int i = 1;
    for (String key : methodNames) {
      System.out.println(i + ". " + key);
      i++;
    }
  }

  private void loop() {
    while (true) {
      // print all the modules
      this.printAllModules();
      // get input
      Number choice;

      choice = InputManager.take_input_number(logger, "Enter your choice");

      if (choice.intValue() > methodNames.size() || choice.intValue() < 1) {
        System.out.println("Invalid choice");
        break;
      }
      // call the method
      String methodName = methodNames.get(choice.intValue() - 1);
      Method method = methodMap.get(methodName);
      try {
        System.out.println(method.invoke(null));
      } catch (Exception e) {
        e.printStackTrace();
        break;
      }
    }
  }
}
