package ads.bcd.sofia.repository;

import ads.bcd.sofia.model.Responsavel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "responsaveis", path = "responsaveis")
public interface ResponsavelRepository extends CrudRepository<Responsavel, Integer> {}
