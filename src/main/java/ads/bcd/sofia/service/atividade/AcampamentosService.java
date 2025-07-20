package ads.bcd.sofia.service.atividade;

import ads.bcd.sofia.model.atividade.Acampamentos;
import ads.bcd.sofia.repository.atividade.AcampamentosRepository;
import ads.bcd.sofia.service.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AcampamentosService implements ServiceInterface<Acampamentos> {

    private AcampamentosRepository repo;

    @Override
    public List<Acampamentos> findAll() {
        List<Acampamentos> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Optional<Acampamentos> findById(Integer id) {
        return repo.findById(id);
    }
}
