package ads.bcd.sofia.service.progressao.insignia;

import ads.bcd.sofia.model.progressao.insignia.DesafioInsignia;
import ads.bcd.sofia.repository.progressao.insignia.DesafioInsigniaRepository;
import ads.bcd.sofia.service.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class DesafioInsigniaService implements ServiceInterface<DesafioInsignia> {

    private DesafioInsigniaRepository repo;

    @Override
    public List<DesafioInsignia> findAll() {
        List<DesafioInsignia> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Optional<DesafioInsignia> findById(Integer id) {
        return repo.findById(id);
    }
}
