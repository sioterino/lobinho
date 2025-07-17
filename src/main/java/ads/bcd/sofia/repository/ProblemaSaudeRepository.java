package ads.bcd.sofia.repository;

import ads.bcd.sofia.model.ProblemaSaude;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "problemas-saude", path = "problemas-saude")
public interface ProblemaSaudeRepository extends PagingAndSortingRepository<ProblemaSaude, Integer>, CrudRepository<ProblemaSaude, Integer> {}
