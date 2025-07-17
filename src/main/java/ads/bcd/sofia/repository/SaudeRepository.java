package ads.bcd.sofia.repository;

import ads.bcd.sofia.model.Saude;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "saudes", path = "saudes")
public interface SaudeRepository extends CrudRepository<Saude, Integer> {}
