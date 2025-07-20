package ads.bcd.sofia.service.progressao.especialidade;

import ads.bcd.sofia.model.progressao.especialidade.Especialidade;
import ads.bcd.sofia.repository.progressao.especialidade.EspecialidadeRepository;
import ads.bcd.sofia.service.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EspecialidadeService implements ServiceInterface<Especialidade> {

    private EspecialidadeRepository repo;

    @Override
    public List<Especialidade> findAll() {
        List<Especialidade> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Optional<Especialidade> findById(Integer id) {
        return repo.findById(id);
    }



}
