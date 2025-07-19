package ads.bcd.sofia.repository.progressao.distintivo;

import ads.bcd.sofia.model.progressao.distintivo.DesafioDistintivo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "desafios-distintivo", path = "desafios-distintivo")
public interface DesafioDistintivoRepository extends PagingAndSortingRepository<DesafioDistintivo, Integer>, CrudRepository<DesafioDistintivo, Integer> {}
