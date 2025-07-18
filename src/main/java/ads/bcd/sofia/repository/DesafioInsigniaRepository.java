package ads.bcd.sofia.repository;

import ads.bcd.sofia.model.DesafioInsignia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "desafios-insignia", path = "desafios-insignia")
public interface DesafioInsigniaRepository extends PagingAndSortingRepository<DesafioInsignia, Integer>, CrudRepository<DesafioInsignia, Integer> {}
