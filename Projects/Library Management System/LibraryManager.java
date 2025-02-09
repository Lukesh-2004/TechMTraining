import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

public class LibraryManager extends LibrarySystem {
    private static final Logger logger = Logger.getLogger(LibraryManager.class.getName());
    private final Lock lock = new ReentrantLock();

    public LibraryManager() {
        books = new ArrayList<>();
        users = new ArrayList<>();
    }

    @Override
    public void addBook(Book book) {
        books.add(book);
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void borrowBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException, MaxBooksAllowedException {
        lock.lock();
        try {
            User user = findUser(userID);
            if (user.getBorrowedBooks().size() >= 5) {
                throw new MaxBooksAllowedException("User has reached the maximum allowed borrowed books.");
            }
            Book book = findBook(ISBN);
            user.borrowBook(book);
            logger.info(user.getName() + " borrowed " + book.getTitle());
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void returnBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException {
        lock.lock();
        try {
            User user = findUser(userID);
            Book book = findBook(ISBN);
            user.returnBook(book);
            logger.info(user.getName() + " returned " + book.getTitle());
        } finally {
            lock.unlock();
        }
    }

    @Override
    public void reserveBook(String ISBN, String userID) throws BookNotFoundException, UserNotFoundException {
        lock.lock();
        try {
            Book book = findBook(ISBN);
            book.setReserved(true);
            logger.info("Book " + book.getTitle() + " reserved by user " + userID);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public Book searchBook(String title) {
        return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title)).findFirst().orElse(null);
    }
}
