package ads.bcd.sofia.service.views;

import ads.bcd.sofia.model.pessoa.Jovem;
import ads.bcd.sofia.model.progressao.distintivo.Distintivo;
import ads.bcd.sofia.model.progressao.especialidade.Especialidade;
import ads.bcd.sofia.model.progressao.insignia.Insignia;
import ads.bcd.sofia.repository.progressao.distintivo.DesafioDistintivoFeitaRepository;
import ads.bcd.sofia.repository.progressao.especialidade.DesafioEspecialidadeFeitaRepository;
import ads.bcd.sofia.repository.progressao.insignia.DesafioInsigniaFeitaRepository;
import ads.bcd.sofia.repository.pessoa.JovemRepository;
import ads.bcd.sofia.views.AptidaoCruzeiro;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@AllArgsConstructor
public class AptidaoCruzeiroService {

    private JovemRepository jovemRepository;
    private DesafioDistintivoFeitaRepository distintivoRepository;
    private DesafioInsigniaFeitaRepository insigniaRepository;
    private DesafioEspecialidadeFeitaRepository especialidadeRepository;

    public AptidaoCruzeiro getProgresso(Integer idJovem) {
        Jovem jovem = jovemRepository.findById(idJovem).orElseThrow();

        List<Distintivo> distintivos = distintivoRepository.findByJovem_idJovem(idJovem)
                .stream().map(d -> d.getDesafioDistintivo().getDistintivo())
                .filter(Objects::nonNull) .toList();

        boolean possuiCruzeiroDoSul = distintivos.stream().anyMatch(d -> d.getNome().equalsIgnoreCase("cruzeiro do sul"));

        if (possuiCruzeiroDoSul) return new AptidaoCruzeiro(jovem, true, true);

        boolean possuiLoboCacador = distintivos.stream().anyMatch(d -> d.getNome().equalsIgnoreCase("lobo caçador"));

        List<Insignia> insignias = insigniaRepository.findByJovem_idJovem(idJovem)
                .stream() .map(d -> d.getDesafioInsignia().getInsignia())
                .filter(Objects::nonNull).distinct().toList();

        List<Especialidade> especialidades = especialidadeRepository.findByJovem_idJovem(idJovem)
                .stream().map(d -> d.getDesafioEspecialidade().getEspecialidade())
                .filter(Objects::nonNull).distinct().toList();

        boolean tem1Insignia = !insignias.isEmpty();
        boolean tem5Especialidades = especialidades.size() >= 5;

        int areasUnicas = (int) especialidades.stream().map(e -> e.getAreaDeConhecimento().getIdAreaConhecimento())
                    .filter(Objects::nonNull).distinct().count();

        boolean tem3Areas = areasUnicas >= 3;
        boolean prontoParaCruzeiro = possuiLoboCacador && tem1Insignia && tem5Especialidades && tem3Areas;

        return new AptidaoCruzeiro(jovem, false, prontoParaCruzeiro);
    }
}
