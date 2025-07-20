package ads.bcd.sofia.service.progressao.especialidade;

import ads.bcd.sofia.model.progressao.especialidade.AreaConhecimento;
import ads.bcd.sofia.repository.progressao.especialidade.AreaConhecimentoRepository;
import ads.bcd.sofia.service.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AreaConhecimentoService implements ServiceInterface<AreaConhecimento> {

    private AreaConhecimentoRepository repo;

    @Override
    public List<AreaConhecimento> findAll() {
        List<AreaConhecimento> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Optional<AreaConhecimento> findById(Integer id) {
        return repo.findById(id);
    }

}
