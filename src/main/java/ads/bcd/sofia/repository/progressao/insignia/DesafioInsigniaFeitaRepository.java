package ads.bcd.sofia.repository.progressao.insignia;

import ads.bcd.sofia.model.progressao.insignia.DesafioInsigniaFeita;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "desafios-insignia-feita", path = "desafios-insignia-feita")
public interface DesafioInsigniaFeitaRepository extends PagingAndSortingRepository<DesafioInsigniaFeita, Integer>, CrudRepository<DesafioInsigniaFeita, Integer> {

    List<DesafioInsigniaFeita> findByJovem_idJovem(Integer idJovem);

}
