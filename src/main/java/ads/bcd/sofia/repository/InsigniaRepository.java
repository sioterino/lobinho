package ads.bcd.sofia.repository;

import ads.bcd.sofia.model.Insignia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "insignias", path = "insignias")
public interface InsigniaRepository extends CrudRepository<Insignia, Integer> {}
