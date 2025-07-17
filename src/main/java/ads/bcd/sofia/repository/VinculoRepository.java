package ads.bcd.sofia.repository;

import ads.bcd.sofia.model.Vinculo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "vinculos", path = "vinculos")
public interface VinculoRepository extends CrudRepository<Vinculo, Integer> {}
