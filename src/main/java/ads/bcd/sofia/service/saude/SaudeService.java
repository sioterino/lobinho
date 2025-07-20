package ads.bcd.sofia.service.saude;

import ads.bcd.sofia.model.saude.Saude;
import ads.bcd.sofia.repository.saude.SaudeRepository;
import ads.bcd.sofia.service.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SaudeService implements ServiceInterface<Saude> {

    private SaudeRepository repo;

    @Override
    public List<Saude> findAll() {
        List<Saude> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Optional<Saude> findById(Integer id) {
        return repo.findById(id);
    }

    public void save(Saude entity) { repo.save(entity); }

    public List<Saude> getSaudeByIdJovem(Integer id) {
        return repo.getSaudeByJovem_idJovem(id);
    }
}
