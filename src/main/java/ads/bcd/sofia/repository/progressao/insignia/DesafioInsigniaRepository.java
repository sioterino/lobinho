package ads.bcd.sofia.repository.progressao.insignia;

import ads.bcd.sofia.model.progressao.insignia.DesafioInsignia;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "desafios-insignia", path = "desafios-insignia")
public interface DesafioInsigniaRepository extends PagingAndSortingRepository<DesafioInsignia, Integer>, CrudRepository<DesafioInsignia, Integer> {}
