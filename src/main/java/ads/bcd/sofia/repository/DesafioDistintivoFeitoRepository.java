package ads.bcd.sofia.repository;

import ads.bcd.sofia.model.DesafioDistintivo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "desafios-distintivo-feito", path = "desafios-distintivo-feito")
public interface DesafioDistintivoFeitoRepository extends CrudRepository<DesafioDistintivo, Integer> {}
