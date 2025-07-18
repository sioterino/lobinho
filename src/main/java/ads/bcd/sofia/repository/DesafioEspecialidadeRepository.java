package ads.bcd.sofia.repository;

import ads.bcd.sofia.model.especialidade.DesafioEspecialidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "desafios-especialidade", path = "desafios-especialidade")
public interface DesafioEspecialidadeRepository extends PagingAndSortingRepository<DesafioEspecialidade, Integer>, CrudRepository<DesafioEspecialidade, Integer> {}
