public class BookNotFoundException extends Exception {
    public BookNotFoundException() {
        super("Book not found in the library.");
    }
}

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("User not found in the library.");
    }
}

public class MaxBooksAllowedException extends Exception {
    public MaxBooksAllowedException(String message) {
        super(message);
    }
}
