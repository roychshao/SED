import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LibrarySystem {

  public static List<Book> books;
  public static List<Book> checkedOutBooks;
  public static List<User> users;

  public static void main(String[] args) {
    try {
      File fakeDataFile = new File(args[0]);
      BufferedReader reader = new BufferedReader(new FileReader(fakeDataFile));

      books = new ArrayList<>();
      checkedOutBooks = new ArrayList<>();
      users = new ArrayList<>();

      String line;

      // enter books
      // System.out.println("Enter books");
      int sequentialNumber = 0;
      line = reader.readLine();
      String[] arrOfStr;
      int numberOfBook = Integer.parseInt(line);
      for (int i = 0; i < numberOfBook; ++i) {
        line = reader.readLine();
        arrOfStr = line.split(" ");
        String author = arrOfStr[0];
        String subject = arrOfStr[1];
        books.add(new Book(sequentialNumber, author, subject));
        sequentialNumber++;
      }

      // enter users
      // System.out.println("Enter users");
      line = reader.readLine();
      int numberOfUser = Integer.parseInt(line);
      for (int i = 0; i < numberOfUser; ++i) {
        line = reader.readLine();
        arrOfStr = line.split(" ");
        String type = arrOfStr[0];
        String name = arrOfStr[1];
        if (type.equals("Borrower")) {
          int predefinedNumber = Integer.parseInt(arrOfStr[2]);
          users.add(new Borrower(type, name, predefinedNumber));
        } else if (type.equals("Staff")) {
          users.add(new Staff(type, name));
        } else {
          throw new Exception();
        }
      }

      // commands loop
      // System.out.println("command loop");
      while ((line = reader.readLine()) != null) {
        arrOfStr = line.split(" ");
        if (arrOfStr.length < 2) {
          System.out.println("Error");
          continue;
        }
        String userName1 = arrOfStr[0];
        String command = arrOfStr[1];
        // add book
        if (command.equals("addBook")) {
          // System.out.println("addBook");
          line = reader.readLine();
          arrOfStr = line.split(" ");
          if (arrOfStr.length != 2) {
            System.out.println("Error");
            continue;
          }
          if (isStaff(userName1) != 1) {
            System.out.println("Borrower can not add book");
            continue;
          }
          String author = arrOfStr[0];
          String subject = arrOfStr[1];
          books.add(new Book(sequentialNumber, author, subject));
        }
        // remove book
        else if (command.equals("removeBook")) {
          // System.out.println("removeBook");
          if (arrOfStr.length != 3) {
            System.out.println("Error");
            continue;
          }
          if (isStaff(userName1) != 1) {
            System.out.println("Borrower can not remove book");
            continue;
          }
          int bookId = Integer.parseInt(arrOfStr[2]);
          Book book = findBookById(bookId);
          if (book == null) {
            System.out.println("Error");
            continue;
          }
          books.remove(book);
        }
        // checkout
        else if (command.equals("checkout")) {
          // System.out.println("checkout");
          if (arrOfStr.length != 3) {
            System.out.println("Error");
            continue;
          }
          if (isStaff(userName1) != 1) {
            System.out.println("Borrower can not check out the books");
            continue;
          }
          String userName2 = arrOfStr[2];
          line = reader.readLine();
          arrOfStr = line.split(" ");
          List<Integer> bookIds = new ArrayList<>();
          for (int i = 0; i < arrOfStr.length; ++i) {
            int bookId = Integer.parseInt(arrOfStr[i]);
            Book book = findBookById(bookId);
            if (book == null) {
              // System.out.println("book is null");  
              System.out.println("Error");
              continue;
            }
            // check if the book is checked out
            if (book.getBorrorwedBy() != null) {
              System.out.println("Can not check out since the book is checked out");
              continue;
            }
            bookIds.add(Integer.parseInt(arrOfStr[i]));
          }
          User borrower = findUserByName(userName2);
          if (borrower == null) {
            // System.out.println("borrower is null");
            System.out.println("Error");
            continue;
          }
          // check if under limitation
          if (bookIds.size() > borrower.getPredefinedNumber()) {
            System.out.println("Can not check out since the number of books exceed the limitation of user can check-out");
            continue;
          }
          for (Integer bookId : bookIds) {
            Book book = findBookById(bookId);
            if (book == null) {
              // System.out.println("findBookById is null");
              System.out.println("Error");
              continue;
            }
            book.setBorrowedBy(borrower); 
            borrower.checkOutBook(book);
            checkedOutBooks.add(book);
          }
        }
        // return
        else if (command.equals("return")) {
          // System.out.println("return");
          if (arrOfStr.length != 3) {
            System.out.println("Error");
            continue;
          }
          if (isStaff(userName1) != 1) {
            System.out.println("Borrower can not return book");
            continue;
          }
          int bookId = Integer.parseInt(arrOfStr[2]);
          Book book = findBookById(bookId);
          if (book.getBorrorwedBy() == null) {
            System.out.println("Can not return since the book isn't checked out");
            continue;
          } else {
            User borrower = book.getBorrorwedBy();
            book.setBorrowedBy(null);
            borrower.returnBook(book);
          }
        }
        // listAuthor
        else if (command.equals("listAuthor")) {
          // System.out.println("listAuthor");
          if (arrOfStr.length != 3) {
            System.out.println("Error");
            continue;
          }
          String author = arrOfStr[2];
          for (Book b : books) {
            if (b.getAuthor().equals(author)) {
              System.out.printf("ID: %d Author: %s Subject: %s\n", b.getId(), b.getAuthor(), b.getSubject());
            }
          }
        }
        // listSubject
        else if (command.equals("listSubject")) {
          // System.out.println("listSubject");
          if (arrOfStr.length != 3) {
            System.out.println("Error");
            continue;
          }
          String subject = arrOfStr[2];
          for (Book b : books) {
            if (b.getSubject().equals(subject)) {
              System.out.printf("ID: %d Author: %s Subject: %s\n", b.getId(), b.getAuthor(), b.getSubject());
            }
          }
        }
        // findChecked
        else if (command.equals("findChecked")) {
          // System.out.println("findChecked");
          if (arrOfStr.length != 3) {
            System.out.println("Error");
            continue;
          }
          String userName2 = arrOfStr[2];
          if (isStaff(userName1) == 2 && !userName1.equals(userName2)) {
            System.out.println("Borrower can not find books checked out by other users");
            continue;
          } else if (isStaff(userName1) == -1) {
            System.out.println("Error");
            continue;
          }
          else {
            User user = findUserByName(userName2);
            List<Book> books = user.getCheckedOutBooks();
            for (Book b : books) {
              System.out.printf("ID: %d Author: %s Subject: %s\n", b.getId(), b.getAuthor(), b.getSubject());
            }
          }
        }
        // Borrower
        else if (command.equals("Borrower")) {
          // System.out.println("Borrower");
          if (arrOfStr.length != 3) {
            System.out.println("Error");
            continue;
          }
          if (isStaff(userName1) != 1) {
            System.out.println("Borrower can not find borrower");
            continue;
          } else {
            int bookId = Integer.parseInt(arrOfStr[2]);
            Book book = findBookById(bookId);
            User user = book.getBorrorwedBy();
            System.out.println("User: " + user.getName());
          }
        } else {
          System.out.println("Error");
          continue;
        }
      }
      reader.close();
    } catch (Exception e) {
      System.out.println("Error");
      // e.printStackTrace();
    }
  }

  public static Book findBookById(int bookId) {
    for (Book b : books) {
      if (b.getId() == bookId) {
        return b;
      }
    }
    return null;
  }

  public static User findUserByName(String userName) {
    for (User u : users) {
      if (u.getName().equals(userName)) {
        return u;
      }
    }
    return null;
  }

  public static int isStaff(String userName) {
    for (User u : users) {
      if (u.getName().equals(userName)) {
        if (u.getType().equals("Staff")) {
          return 1;
        } else if (u.getType().equals("Borrower")) {
          return 2;
        } else {
          return -1;
        }
      }
    }
    return -1;
  }

  public static void checkoutCopy(String userName, Book book) {};

  public static void returnCopy(String userName, Book book) {};

  public static void addCopy(String userName, Book book) {};

  public static void removeCopy(String userName, Book book) {};

  public static List<Book> getBooksByAuthor(String author) {
    return new ArrayList<>();
  };

  public static List<Book> getBooksBySubject(String subject) {
    return new ArrayList<>();
  };

  public static List<Book> findCheckedOut(String staffName, String borrowerName) {
    return new ArrayList<>();
  };

  public static Book findLastCheckedOut(String staffName, String borrowerName) {
    return new Book(0, "", "");
  };
}
