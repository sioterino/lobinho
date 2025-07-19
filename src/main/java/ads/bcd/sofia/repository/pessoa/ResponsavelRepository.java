package ads.bcd.sofia.repository.pessoa;

import ads.bcd.sofia.model.pessoa.Responsavel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "responsaveis", path = "responsaveis")
public interface ResponsavelRepository extends PagingAndSortingRepository<Responsavel, Integer>, CrudRepository<Responsavel, Integer> {}
