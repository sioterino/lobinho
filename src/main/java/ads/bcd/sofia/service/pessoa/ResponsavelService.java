package ads.bcd.sofia.service.pessoa;

import ads.bcd.sofia.model.pessoa.Responsavel;
import ads.bcd.sofia.repository.pessoa.ResponsavelRepository;
import ads.bcd.sofia.service.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ResponsavelService implements ServiceInterface<Responsavel> {

    private final ResponsavelRepository repo;

    @Override
    public List<Responsavel> findAll() {
        List<Responsavel> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Optional<Responsavel> findById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Responsavel save(Responsavel responsavel) {
        return repo.save(responsavel);
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return repo.existsById(id);
    }
}
