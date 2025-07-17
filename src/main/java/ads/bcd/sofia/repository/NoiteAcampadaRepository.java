package ads.bcd.sofia.repository;

import ads.bcd.sofia.model.NoiteAcampada;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "noites-acampadas", path = "noites-acampadas")
public interface NoiteAcampadaRepository extends CrudRepository<NoiteAcampada, Integer> {}
