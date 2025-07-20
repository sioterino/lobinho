package ads.bcd.sofia.repository.saude;

import ads.bcd.sofia.model.saude.Saude;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "saudes", path = "saudes")
public interface SaudeRepository extends PagingAndSortingRepository<Saude, Integer>, CrudRepository<Saude, Integer> {

    List<Saude> getSaudeByJovem_idJovem(Integer idJovem);

}
