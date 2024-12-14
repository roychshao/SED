public class Book {
  private int id;
  private String author;
  private String subject;
  private User borrowedBy;

  public Book(int id, String author, String subject) {
    this.id = id;
    this.author = author;
    this.subject = subject;
    this.borrowedBy = null;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public User getBorrorwedBy() {
    return borrowedBy;
  }

  public void setBorrowedBy(User user) {
    this.borrowedBy = user;
  }
}
