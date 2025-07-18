package ads.bcd.sofia.repository;

import ads.bcd.sofia.model.insignia.DesafioInsigniaFeita;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "desafios-insignia-feita", path = "desafios-insignia-feita")
public interface DesafioInsigniaFeitaRepository extends PagingAndSortingRepository<DesafioInsigniaFeita, Integer>, CrudRepository<DesafioInsigniaFeita, Integer> {}
