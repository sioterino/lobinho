package ads.bcd.sofia.service.progressao.distintivo;

import ads.bcd.sofia.model.progressao.distintivo.Distintivo;
import ads.bcd.sofia.repository.progressao.distintivo.DistintivoRepository;
import ads.bcd.sofia.service.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DistintivoService implements ServiceInterface<Distintivo> {

    private DistintivoRepository repo;

    @Override
    public List<Distintivo> findAll() {
        List<Distintivo> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Optional<Distintivo> findById(Integer id) {
        return repo.findById(id);
    }
}
