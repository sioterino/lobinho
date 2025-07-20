package ads.bcd.sofia.repository.saude;

import ads.bcd.sofia.model.saude.ProblemaSaude;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "problemas-saude", path = "problemas-saude")
public interface ProblemaSaudeRepository extends PagingAndSortingRepository<ProblemaSaude, Integer>, CrudRepository<ProblemaSaude, Integer> {

    List<ProblemaSaude> findByTipoProblema(String tipoProblema);

}
