package ads.bcd.sofia.repository.atividade;

import ads.bcd.sofia.model.atividade.NoiteAcampada;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "noites-acampadas", path = "noites-acampadas")
public interface NoiteAcampadaRepository extends PagingAndSortingRepository<NoiteAcampada, Integer>, CrudRepository<NoiteAcampada, Integer> {}
