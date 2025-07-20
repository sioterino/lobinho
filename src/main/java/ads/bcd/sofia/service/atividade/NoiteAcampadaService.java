package ads.bcd.sofia.service.atividade;

import ads.bcd.sofia.model.atividade.NoiteAcampada;
import ads.bcd.sofia.repository.atividade.NoiteAcampadaRepository;
import ads.bcd.sofia.service.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoiteAcampadaService implements ServiceInterface<NoiteAcampada> {

    private NoiteAcampadaRepository repo;

    @Override
    public List<NoiteAcampada> findAll() {
        List<NoiteAcampada> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Optional<NoiteAcampada> findById(Integer id) {
        return repo.findById(id);
    }

    public void save (NoiteAcampada entity) { repo.save(entity); }
}
