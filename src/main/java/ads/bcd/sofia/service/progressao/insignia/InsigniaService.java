package ads.bcd.sofia.service.progressao.insignia;

import ads.bcd.sofia.model.progressao.insignia.Insignia;
import ads.bcd.sofia.repository.progressao.insignia.InsigniaRepository;
import ads.bcd.sofia.service.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class InsigniaService implements ServiceInterface<Insignia> {

    private InsigniaRepository repo;

    @Override
    public List<Insignia> findAll() {
        List<Insignia> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Optional<Insignia> findById(Integer id) {
        return repo.findById(id);
    }
}
