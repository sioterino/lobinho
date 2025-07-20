package ads.bcd.sofia.service.progressao.distintivo;

import ads.bcd.sofia.model.progressao.distintivo.DesafioDistintivo;
import ads.bcd.sofia.repository.progressao.distintivo.DesafioDistintivoRepository;
import ads.bcd.sofia.service.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DesafioDistintivoService implements ServiceInterface<DesafioDistintivo> {

    private DesafioDistintivoRepository repo;

    @Override
    public List<DesafioDistintivo> findAll() {
        List<DesafioDistintivo> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Optional<DesafioDistintivo> findById(Integer id) {
        return repo.findById(id);
    }
}
