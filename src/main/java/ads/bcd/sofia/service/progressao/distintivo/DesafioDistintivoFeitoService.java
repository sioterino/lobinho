package ads.bcd.sofia.service.progressao.distintivo;

import ads.bcd.sofia.model.progressao.distintivo.DesafioDistintivoFeita;
import ads.bcd.sofia.repository.progressao.distintivo.DesafioDistintivoFeitaRepository;
import ads.bcd.sofia.service.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DesafioDistintivoFeitoService implements ServiceInterface<DesafioDistintivoFeita> {

    private DesafioDistintivoFeitaRepository repo;

    @Override
    public List<DesafioDistintivoFeita> findAll() {
        List<DesafioDistintivoFeita> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Optional<DesafioDistintivoFeita> findById(Integer id) {
        return repo.findById(id);
    }

    public void save(DesafioDistintivoFeita entity) { repo.save(entity); }

    public List<DesafioDistintivoFeita> getDesafioInsigniaByJovemId(Integer id) {
        return repo.findByJovem_idJovem(id);
    }
}
