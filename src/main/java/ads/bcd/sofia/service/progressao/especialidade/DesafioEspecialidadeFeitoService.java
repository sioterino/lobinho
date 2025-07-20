package ads.bcd.sofia.service.progressao.especialidade;

import ads.bcd.sofia.model.progressao.especialidade.DesafioEspecialidadeFeita;
import ads.bcd.sofia.repository.progressao.especialidade.DesafioEspecialidadeFeitaRepository;
import ads.bcd.sofia.service.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DesafioEspecialidadeFeitoService implements ServiceInterface<DesafioEspecialidadeFeita> {

    private DesafioEspecialidadeFeitaRepository repo;

    @Override
    public List<DesafioEspecialidadeFeita> findAll() {
        List<DesafioEspecialidadeFeita> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Optional<DesafioEspecialidadeFeita> findById(Integer id) {
        return repo.findById(id);
    }

    public void save(DesafioEspecialidadeFeita entity) {
        repo.save(entity);
    }

}
