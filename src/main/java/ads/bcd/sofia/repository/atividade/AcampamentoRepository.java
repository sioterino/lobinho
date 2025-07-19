package ads.bcd.sofia.repository.atividade;

import ads.bcd.sofia.model.atividade.Acampamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "acampamentos", path = "acampamentos")
public interface AcampamentoRepository extends PagingAndSortingRepository<Acampamento, Integer>, CrudRepository<Acampamento, Integer> {}
