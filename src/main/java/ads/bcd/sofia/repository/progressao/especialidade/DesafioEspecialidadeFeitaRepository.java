package ads.bcd.sofia.repository.progressao.especialidade;

import ads.bcd.sofia.model.progressao.especialidade.DesafioEspecialidadeFeita;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "desafios-especialidade-feito", path = "desafios-especialidade-feito")
public interface DesafioEspecialidadeFeitaRepository extends PagingAndSortingRepository<DesafioEspecialidadeFeita, Integer>, CrudRepository<DesafioEspecialidadeFeita, Integer> {

    List<DesafioEspecialidadeFeita> findByJovem_idJovem(Integer idJovem);

}
