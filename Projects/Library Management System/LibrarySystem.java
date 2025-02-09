import java.util.List;

public abstract class LibrarySystem implements ILibrary {
    protected List<Book> books;
    protected List<User> users;

    public abstract void addBook(Book book);
    public abstract void addUser(User user);

    public User findUser(String userID) throws UserNotFoundException {
        return users.stream().filter(user -> user.getUserID().equals(userID)).findFirst().orElseThrow(UserNotFoundException::new);
    }

    public Book findBook(String ISBN) throws BookNotFoundException {
        return books.stream().filter(book -> book.getISBN().equals(ISBN)).findFirst().orElseThrow(BookNotFoundException::new);
    }
}
