package ads.bcd.sofia.repository;

import ads.bcd.sofia.model.distintivo.DesafioDistintivoFeita;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "desafios-distintivo-feito", path = "desafios-distintivo-feito")
public interface DesafioDistintivoFeitaRepository extends PagingAndSortingRepository<DesafioDistintivoFeita, Integer>, CrudRepository<DesafioDistintivoFeita, Integer> {}
