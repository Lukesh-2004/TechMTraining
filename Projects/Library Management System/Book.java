public class Book {
    private String title;
    private String author;
    private String ISBN;
    private boolean isReserved;

    public Book(String title, String author, String ISBN) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.isReserved = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void setReserved(boolean reserved) {
        isReserved = reserved;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + ''' +
                ", author='" + author + ''' +
                ", ISBN='" + ISBN + ''' +
                ", isReserved=" + isReserved +
                '}';
    }
}
