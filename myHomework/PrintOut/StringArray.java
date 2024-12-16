import java.util.*;

public class StringArray {

  private List<StringObject> array;

  public StringArray() {
    array = new ArrayList<>();
  }

  public String get(int i) {
    return array.get(i).getValue();
  }

  public void add(String value) {
    array.add(new StringObject(value));
  }
}
