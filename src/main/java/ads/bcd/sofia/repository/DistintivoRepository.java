package ads.bcd.sofia.repository;

import ads.bcd.sofia.model.Distintivo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "distintivos", path = "distintivos")
public interface DistintivoRepository extends CrudRepository<Distintivo, Integer> {}
