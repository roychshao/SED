public class ChassisIterator implements AbstractIterator {

  private int index; // point to next
  private Chassis chassis;

  public ChassisIterator(Chassis chassis) {
    this.index = 0;
    this.chassis = chassis;
  }

  public Component next() {
    Component next = chassis.getComponents().get(index);
    index++;
    return next;
  }

  public boolean hasNext() {
    return index < chassis.getComponents().size();
  }
} 
