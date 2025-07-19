package ads.bcd.sofia.service.pessoa;

import ads.bcd.sofia.model.pessoa.Jovem;
import ads.bcd.sofia.repository.pessoa.JovemRepository;
import ads.bcd.sofia.service.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JovemService implements ServiceInterface<Jovem> {

    private final JovemRepository repo;

    @Override
    public List<Jovem> findAll() {
        List<Jovem> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Optional<Jovem> findById(Integer id) {
        return repo.findById(id);
    }

    public Jovem save(Jovem object) {
        return repo.save(object);
    }

}
