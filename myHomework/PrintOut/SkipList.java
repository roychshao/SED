import java.util.*;

public class SkipList implements AbstractList {

  private List<SkipNode> nodeList;

  public SkipList() {
    nodeList = new ArrayList<>();
  }

  public String get(int i) {
    System.out.println("SkipList do not have method get");
    return null;
  }

  public void add(String value) {
    nodeList.add(new SkipNode(value));
  }

  public int size() {
    return nodeList.size();
  }

  public String getNode(int i) {
    System.out.println("SkipNode:" + nodeList.get(i).getValue());
    return nodeList.get(i).getValue();
  }

  public void traverse() {
    for (SkipNode s : nodeList) {
      System.out.println("SkipNode:" + s.getValue());
    }
  }
}
