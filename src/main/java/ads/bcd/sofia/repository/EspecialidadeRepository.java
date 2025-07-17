package ads.bcd.sofia.repository;

import ads.bcd.sofia.model.Especialidade;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "especialidades", path = "especialidades")
public interface EspecialidadeRepository extends CrudRepository<Especialidade, Integer> {}
