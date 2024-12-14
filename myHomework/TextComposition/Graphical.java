public class Graphical extends Component {
  public Graphical(
      String componentID, int naturalSize, int shrinkability, int stretchability, String content) {
    this.componentID = componentID;
    this.naturalSize = naturalSize;
    this.shrinkability = shrinkability;
    this.stretchability = stretchability;
    this.content = content;
  }
}
