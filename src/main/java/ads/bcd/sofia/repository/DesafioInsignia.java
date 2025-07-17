package ads.bcd.sofia.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "desafios-insignia", path = "desafios-insignia")
public interface DesafioInsignia extends CrudRepository<DesafioInsignia, Integer> {}
