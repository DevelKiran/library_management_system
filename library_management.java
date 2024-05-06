import java.util.*;

class Book {
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

class User {
    private String name;
    private int id;

    public User(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

}

class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        books = new ArrayList<>();
        users = new ArrayList<>();

    }

    public void addBook(String title, String author) {
        Book book = new Book(title, author);
        books.add(book);
    }

    public void addUser(String name, int id) {
        User user = new User(name, id);
        users.add(user);

        System.out.println("User added successfully");
    }

    public void displayBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }

    public void borrowBook(String title, int userId) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println("Book '" + title + "' borrowed successfully by user with ID " + userId);
                return;
            }
        }
        System.out.println("Book '" + title + "' not available for borrowing.");
    }

    public void returnBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isAvailable()) {
                book.setAvailable(true);
                System.out.println("Book '" + title + "' returned successfully.");
                return;
            }
        }
        System.out.println("Book '" + title + "' is not borrowed or does not exist.");
    }
}

public class library_management {
    public static void main(String[] args) {

        Library library = new Library();

        Scanner scanner = new Scanner(System.in);

        // Random random = new Random();

        // generate a random integer from 0 to 899, then add 100
        // int x = random.nextInt(900) + 100;

        System.out.println("Wel come Library Management System : ");
        boolean flag = true;
        do {

            System.out.println("1 . Add Book");
            System.out.println("2 . Add User");
            System.out.println("3 . Display availble books");
            System.out.println("4 . Borrow Book");
            System.out.println("5 . Return Book");
            System.out.println("0 . Exit");
            System.out.println("Enter your choice...");
            int choice = scanner.nextInt();
            int id = 100;
            switch (choice) {
                case 1:
                    System.out.println("Enter Book Name:");
                    String bname = scanner.next();
                    System.out.println("Enter Author Name:");
                    String aname = scanner.next();
                    library.addBook(bname, aname);
                    break;

                case 2:
                    System.out.println("Enter User Name");
                    String name = scanner.next();

                    library.addUser(name, id);
                    System.out.println("your id " + id);
                    id++;
                    break;

                case 3:
                    System.out.println("All Books:");
                    library.displayBooks();
                    break;
                case 4:
                    library.displayBooks();
                    System.out.println("Enter Book Name:");
                    String bname2 = scanner.next();
                    System.out.println("Enter User name");
                    String uname = scanner.next();
                    System.out.println("Enter ID");
                    int uId = scanner.nextInt();
                    library.borrowBook(bname2, uId);
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Enter book name for Return book");
                    String bname3 = scanner.next();
                    library.returnBook(bname3);
                    break;

                case 0:
                    flag = false;
                    break;
                default:
                    break;
            }
        } while (flag);

    }
}
