package ads.bcd.sofia.repository.pessoa;

import ads.bcd.sofia.model.pessoa.Jovem;
import ads.bcd.sofia.model.saude.TipoSanguineo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "jovens", path = "jovens")
public interface JovemRepository extends PagingAndSortingRepository<Jovem, Integer>, CrudRepository<Jovem, Integer> {
    List<Jovem> findByTipoSanguineo(TipoSanguineo tipo);




}
