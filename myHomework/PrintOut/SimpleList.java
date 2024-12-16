public class SimpleList implements AbstractList {

  private StringArray strArray;
  public int length;

  public SimpleList() {
    strArray = new StringArray();
    length = 0;
  }

  public String get(int i) {
    return strArray.get(i);
  }

  public void add(String value) {
    strArray.add(value);
    length++;
  }

  public int size() {
    System.out.println("List do not have method size");
    return -1;
  }

  public String getNode(int i) {
    System.out.println("List do not have method getNode");
    return null;
  }

  public void traverse() {
    for (int i = 0; i < length; ++i) {
      System.out.println(strArray.get(i));
    }
  }
}
