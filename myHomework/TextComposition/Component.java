public class Component {
  protected String componentID;
  protected int naturalSize;
  protected int shrinkability;
  protected int stretchability;
  protected String content;

  public String getComponentID() {
    return componentID;
  }

  public void setComponentID(String componentID) {
    this.componentID = componentID;
  }

  public int getNaturalSize() {
    return naturalSize;
  }

  public void setNaturalSize(int naturalSize) {
    if (naturalSize < shrinkability || naturalSize > stretchability) {
      System.out.printf("component %s failed to change size\n", this.componentID);
    } else {
      this.naturalSize = naturalSize;
      System.out.printf("component %s size changed size to %d\n", this.componentID, naturalSize);
    }
  }

  public int getShrinkability() {
    return shrinkability;
  }

  public void setShrinkability(int shrinkability) {
    this.shrinkability = shrinkability;
  }

  public int getStretchability() {
    return stretchability;
  }

  public void setStretchability(int stretchability) {
    this.stretchability = stretchability;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
