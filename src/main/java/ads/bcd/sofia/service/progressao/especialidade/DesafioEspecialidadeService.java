package ads.bcd.sofia.service.progressao.especialidade;

import ads.bcd.sofia.model.progressao.especialidade.DesafioEspecialidade;
import ads.bcd.sofia.repository.progressao.especialidade.DesafioEspecialidadeRepository;
import ads.bcd.sofia.service.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DesafioEspecialidadeService implements ServiceInterface<DesafioEspecialidade> {

    private DesafioEspecialidadeRepository repo;

    @Override
    public List<DesafioEspecialidade> findAll() {
        List<DesafioEspecialidade> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Optional<DesafioEspecialidade> findById(Integer id) {
        return repo.findById(id);
    }



}
