package gem.entitydemo.repositories;

import gem.entitydemo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository <Book , Long>
{
}
