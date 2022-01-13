
package gem.entitydemo.repositories;

import gem.entitydemo.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author , Long>
{
}
