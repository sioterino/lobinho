package ads.bcd.sofia.repository.pessoa;

import ads.bcd.sofia.model.pessoa.Vinculo;
import ads.bcd.sofia.model.pessoa.Responsavel   ;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "vinculos", path = "vinculos")
public interface VinculoRepository extends PagingAndSortingRepository<Vinculo, Integer>, CrudRepository<Vinculo, Integer> {

    List<Vinculo> findByJovem_IdJovem(Integer idJovem);

}
