package ads.bcd.sofia.repository;

import ads.bcd.sofia.model.AreaConhecimento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "areas-conhecimento", path = "areas-conhecimento")
public interface AreaConhecimentoRepository extends PagingAndSortingRepository<AreaConhecimento, Integer>, CrudRepository<AreaConhecimento, Integer> {}
