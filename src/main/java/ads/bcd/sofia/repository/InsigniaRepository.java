package ads.bcd.sofia.repository;

import ads.bcd.sofia.model.insignia.Insignia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "insignias", path = "insignias")
public interface InsigniaRepository extends PagingAndSortingRepository<Insignia, Integer>, CrudRepository<Insignia, Integer> {}
