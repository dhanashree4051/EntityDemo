package gem.entitydemo.bootstrap;
import gem.entitydemo.model.Author;
import gem.entitydemo.model.Book;
import gem.entitydemo.model.Publisher;
import gem.entitydemo.repositories.AuthorRepository;
import gem.entitydemo.repositories.BookRepository;
import gem.entitydemo.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner
{
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository)
    {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception
    {
        System.out.println("Started in bootstrap");

        Publisher publisher = new Publisher();
        publisher.setPublisherName("Dhanu");
        publisher.setAddressLine("Near Hanuman Temple");
        publisher.setCity("Panvel");
        publisher.setState("Maharashtra");

        publisherRepository.save(publisher);

        System.out.println("Publisher count: " + publisherRepository.count());


        Author author = new Author("Dhanashree");
        Book book = new Book("Java");


        author.getBookSet().add(book);
        book.getAuthorSet().add(author);

        book.setPublisher(publisher);
        publisher.getBookSet().add(book);

        authorRepository.save(author);
        bookRepository.save(book);
        publisherRepository.save(publisher);



        Author author1 = new Author("Pramod");
        Book book1 = new Book("Android");

        author1.getBookSet().add(book1);
        book1.getAuthorSet().add(author1);

        book1.setPublisher(publisher);
        publisher.getBookSet().add(book1);

        authorRepository.save(author1);
        bookRepository.save(book1);
        publisherRepository.save(publisher);


        System.out.println("Number of books " + bookRepository.count());
        System.out.println("Publisher number of books " + publisher.getBookSet().size());



    }
}