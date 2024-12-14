import java.util.ArrayList;
import java.util.List;

public class Borrower extends User {
  public int predefinedNumber;
  public List<Book> checkedOutBooks;

  public Borrower(String type, String name, int predefinedNumber) {
    super(type, name);
    this.predefinedNumber = predefinedNumber;
    this.checkedOutBooks = new ArrayList<>();
  }

  public List<Book> getCheckedOutBooks() {
    return checkedOutBooks;
  }

  public void checkOutBook(Book book) {
    checkedOutBooks.add(book);
    book.setBorrowedBy(this);
  }

  public void returnBook(Book book) {
    checkedOutBooks.remove(book);
    book.setBorrowedBy(null);
  }

  public Book getLastCheckedOut() {
    return checkedOutBooks.getLast();
  }

  public int getPredefinedNumber() {
    return predefinedNumber;
  }
}
