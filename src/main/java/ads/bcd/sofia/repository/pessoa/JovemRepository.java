package ads.bcd.sofia.repository.pessoa;

import ads.bcd.sofia.model.pessoa.Jovem;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "jovens", path = "jovens")
public interface JovemRepository extends PagingAndSortingRepository<Jovem, Integer>, CrudRepository<Jovem, Integer> {}
