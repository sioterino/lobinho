package ads.bcd.sofia.repository;

import ads.bcd.sofia.model.DesafioEspecialidadeFeita;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "desafios-especialidade-feito", path = "desafios-especialidade-feito")
public interface DesafioEspecialidadeFeitaRepository extends PagingAndSortingRepository<DesafioEspecialidadeFeita, Integer>, CrudRepository<DesafioEspecialidadeFeita, Integer> {}
