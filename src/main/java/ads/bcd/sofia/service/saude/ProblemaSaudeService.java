package ads.bcd.sofia.service.saude;

import ads.bcd.sofia.model.saude.ProblemaSaude;
import ads.bcd.sofia.repository.saude.ProblemaSaudeRepository;
import ads.bcd.sofia.service.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class ProblemaSaudeService implements ServiceInterface<ProblemaSaude> {

    private ProblemaSaudeRepository repo;

    @Override
    public List<ProblemaSaude> findAll() {
        List<ProblemaSaude> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Optional<ProblemaSaude> findById(Integer id) {
        return repo.findById(id);
    }

    public List<String> getAllTiposProblema() {
        return StreamSupport.stream(repo.findAll().spliterator(), false).map(ProblemaSaude::getTipoProblema).distinct().toList();
    }

    public List<ProblemaSaude> getByTipoProblema(String tipoProblema) { return repo.findByTipoProblema(tipoProblema); }

}
