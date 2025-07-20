package ads.bcd.sofia.service.views;

import ads.bcd.sofia.model.pessoa.Jovem;
import ads.bcd.sofia.model.progressao.distintivo.Distintivo;
import ads.bcd.sofia.model.progressao.especialidade.Especialidade;
import ads.bcd.sofia.model.progressao.insignia.Insignia;
import ads.bcd.sofia.repository.pessoa.JovemRepository;
import ads.bcd.sofia.repository.progressao.distintivo.DesafioDistintivoFeitaRepository;
import ads.bcd.sofia.repository.progressao.especialidade.DesafioEspecialidadeFeitaRepository;
import ads.bcd.sofia.repository.progressao.insignia.DesafioInsigniaFeitaRepository;
import ads.bcd.sofia.views.JovemProgresso;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class JovemProgressoService {

    private JovemRepository jovemRepository;
    private DesafioDistintivoFeitaRepository desafioDistintivoFeitoRepository;
    private DesafioInsigniaFeitaRepository desafioInsigniaFeitaRepository;
    private DesafioEspecialidadeFeitaRepository desafioEspecialidadeFeitaRepository;


    public JovemProgresso getJovemProgresso(Integer idJovem) {
        Jovem jovem = jovemRepository.findById(idJovem).orElseThrow();

        List<Especialidade> especialidades = desafioEspecialidadeFeitaRepository .findByJovem_idJovem(idJovem)
                .stream().map(def -> def.getDesafioEspecialidade().getEspecialidade())
                .filter(Objects::nonNull).distinct().toList();

        List<Distintivo> distintivos = desafioDistintivoFeitoRepository.findByJovem_idJovem(idJovem)
                .stream().map(d -> d.getDesafioDistintivo().getDistintivo())
                .filter(Objects::nonNull).distinct().toList();

        List<Insignia> insignias = desafioInsigniaFeitaRepository.findByJovem_idJovem(idJovem)
                .stream().map(di -> di.getDesafioInsignia().getInsignia())
                .filter(Objects::nonNull).distinct().toList();

        return new JovemProgresso(jovem, especialidades, distintivos, insignias);
    }

}
