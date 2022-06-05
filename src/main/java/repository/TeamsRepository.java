package repository;

import domain.Soccer;
import org.springframework.data.repository.CrudRepository;

public interface TeamsRepository extends CrudRepository<Soccer,Long> {
}
