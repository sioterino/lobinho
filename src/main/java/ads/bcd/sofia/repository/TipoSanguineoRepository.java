package ads.bcd.sofia.repository;

import ads.bcd.sofia.model.TipoSanguineo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tipos-s", path = "tipos-sanguineos")
public interface TipoSanguineoRepository extends CrudRepository<TipoSanguineo, Integer> {}
