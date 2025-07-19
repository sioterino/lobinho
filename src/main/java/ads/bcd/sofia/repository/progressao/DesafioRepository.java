package ads.bcd.sofia.repository.progressao;

import ads.bcd.sofia.model.progressao.Desafio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "desafios", path = "desafios")
public interface DesafioRepository extends PagingAndSortingRepository<Desafio, Integer>, CrudRepository<Desafio, Integer> {}
