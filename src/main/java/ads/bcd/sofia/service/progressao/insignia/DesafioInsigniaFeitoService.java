package ads.bcd.sofia.service.progressao.insignia;

import ads.bcd.sofia.model.progressao.insignia.DesafioInsigniaFeita;
import ads.bcd.sofia.repository.progressao.insignia.DesafioInsigniaFeitaRepository;
import ads.bcd.sofia.service.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DesafioInsigniaFeitoService implements ServiceInterface<DesafioInsigniaFeita> {

    private DesafioInsigniaFeitaRepository repo;

    @Override
    public List<DesafioInsigniaFeita> findAll() {
        List<DesafioInsigniaFeita> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Optional<DesafioInsigniaFeita> findById(Integer id) {
        return repo.findById(id);
    }

    public void save(DesafioInsigniaFeita entity) { repo.save(entity); }
}
