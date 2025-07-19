package ads.bcd.sofia.service.saude;

import ads.bcd.sofia.model.saude.TipoSanguineo;
import ads.bcd.sofia.repository.saude.TipoSanguineoRepository;
import ads.bcd.sofia.service.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TipoSanguineoService implements ServiceInterface<TipoSanguineo> {

    private final TipoSanguineoRepository repo;

    @Override
    public List<TipoSanguineo> findAll() {
        List<TipoSanguineo> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Optional<TipoSanguineo> findById(Integer id) {
        return repo.findById(id);
    }

    public TipoSanguineo save(TipoSanguineo object) {
        return repo.save(object);
    }
}
