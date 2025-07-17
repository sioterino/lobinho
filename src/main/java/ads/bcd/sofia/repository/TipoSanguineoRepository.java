package ads.bcd.sofia.repository;

import ads.bcd.sofia.model.TipoSanguineo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "tipos-s", path = "tipos-sanguineos")
public interface TipoSanguineoRepository extends PagingAndSortingRepository<TipoSanguineo, Integer>, CrudRepository<TipoSanguineo, Integer> {
    Optional<TipoSanguineo> findByTipo(String tipo);

}
