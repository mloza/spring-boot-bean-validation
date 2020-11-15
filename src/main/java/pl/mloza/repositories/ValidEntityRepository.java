package pl.mloza.repositories;

import org.springframework.data.repository.CrudRepository;
import pl.mloza.model.ValidEntity;

public interface ValidEntityRepository extends CrudRepository<ValidEntity, Long> { }
