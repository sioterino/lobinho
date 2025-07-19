package ads.bcd.sofia.service.pessoa;

import ads.bcd.sofia.model.pessoa.Responsavel;
import ads.bcd.sofia.model.pessoa.Vinculo;
import ads.bcd.sofia.repository.pessoa.VinculoRepository;
import ads.bcd.sofia.service.ServiceInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class VinculoService implements ServiceInterface<Vinculo> {

    private final VinculoRepository repo;

    @Override
    public List<Vinculo> findAll() {
        List<Vinculo> list = new ArrayList<>();
        repo.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Optional<Vinculo> findById(Integer id) {
        return repo.findById(id);
    }

    @Override
    public Vinculo save(Vinculo object) {
        return repo.save(object);
    }

    @Override
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return repo.existsById(id);
    }

    public List<Vinculo> getVinculoByIdJovem(int id) {
        return repo.findByJovem_IdJovem(id);
    }

    public List<Responsavel> getResponsavelByIdJovem(int id) {
        return repo.findByJovem_IdJovem(id).stream().map(Vinculo::getResponsavel).collect(Collectors.toList());
    }
}
