package ads.bcd.sofia.repository.saude;

import ads.bcd.sofia.model.saude.TipoSanguineo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tipos-s", path = "tipos-sanguineos")
public interface TipoSanguineoRepository extends PagingAndSortingRepository<TipoSanguineo, Integer>, CrudRepository<TipoSanguineo, Integer> {}
