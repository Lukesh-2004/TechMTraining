import java.util.logging.Logger;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        LibraryManager library = new LibraryManager();

        // Initialize library with books and users
        library.addBook(new Book("Java Programming", "John Doe", "ISBN001"));
        library.addBook(new Book("Python Basics", "Jane Smith", "ISBN002"));
        library.addUser(new User("Alice", "U001"));
        library.addUser(new User("Bob", "U002"));

        // Demonstrate library operations
        try {
            library.borrowBook("ISBN001", "U001");
            library.borrowBook("ISBN002", "U002");
            library.returnBook("ISBN001", "U001");
            library.reserveBook("ISBN002", "U002");
        } catch (Exception e) {
            logger.warning(e.getMessage());
        }
    }
}
