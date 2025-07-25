package ads.bcd.sofia.repository.progressao.distintivo;

import ads.bcd.sofia.model.progressao.distintivo.Distintivo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "distintivos", path = "distintivos")
public interface DistintivoRepository extends PagingAndSortingRepository<Distintivo, Integer>, CrudRepository<Distintivo, Integer> {}
