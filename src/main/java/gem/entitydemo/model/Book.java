package gem.entitydemo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Book
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookId;

    private String bookTitle;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany
    @JoinTable(name = "Author_Book" , joinColumns = @JoinColumn(name = "Book_Id") , inverseJoinColumns = @JoinColumn(name = "Author_Id"))
    private Set<Author> authorSet = new HashSet<>();

    public Book()
    {
    }

    public Book(String bookTitle)
    {
        this.bookTitle = bookTitle;

    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public Long getBookId() { return bookId; }

    public void setBookId(Long bookId) { this.bookId = bookId; }

    public String getBookTitle() { return bookTitle; }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public Set<Author> getAuthorSet() {
        return authorSet;
    }

    public void setAuthorSet(Set<Author> authorSet) {
        this.authorSet = authorSet;
    }


    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookTitle='" + bookTitle + '\'' +
                ", authorSet=" + authorSet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        return bookId != null ? bookId.equals(book.bookId) : book.bookId == null;
    }

    @Override
    public int hashCode() {
        return bookId != null ? bookId.hashCode() : 0;
    }

}
