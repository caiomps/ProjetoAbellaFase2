import java.time.LocalDateTime;

public class   Book {

    private String author;

    private String title;

    private LocalDateTime creationDate;

    private LocalDateTime yearOfRelease;

    public Book(String author, String title, LocalDateTime creationDatel, LocalDateTime yearOfRelease) {
        this.author = author;
        this.title = title;
        this.creationDate = creationDatel;
        this.yearOfRelease = yearOfRelease;
    }

    public Book() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDateTime getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(LocalDateTime yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    @Override
    public String toString() {
        return "Book{" +
                "author = '" + author + '\'' +
                ", title = '" + title + '\'' +
                ", creationDatel = " + creationDate +
                ", yearOfRelease = " + yearOfRelease +
                '}';
    }
}
