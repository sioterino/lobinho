package ads.bcd.sofia.repository.atividade;

import ads.bcd.sofia.model.atividade.Acampamentos;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "acampamentos", path = "acampamentos")
public interface AcampamentosRepository extends PagingAndSortingRepository<Acampamentos, Integer>, CrudRepository<Acampamentos, Integer> {}
