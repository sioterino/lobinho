package ads.bcd.sofia.repository.progressao.especialidade;

import ads.bcd.sofia.model.progressao.especialidade.DesafioEspecialidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "desafios-especialidade", path = "desafios-especialidade")
public interface DesafioEspecialidadeRepository extends PagingAndSortingRepository<DesafioEspecialidade, Integer>, CrudRepository<DesafioEspecialidade, Integer> {}
