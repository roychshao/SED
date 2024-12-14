import java.util.*;

public abstract class User {
  protected String type;
  protected String name;

  public User(String type, String name) {
    this.type = type;
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<Book> getCheckedOutBooks() {
    return new ArrayList<>();
  }

  public void checkOutBook(Book book) {
  }

  public void returnBook(Book book) {
  }

  public Book getLastCheckedOut() {
    return new Book(-1, "null", "null");
  }

  public int getPredefinedNumber() {
    return 0;
  }
}
