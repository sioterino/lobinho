package ads.bcd.sofia.controller.views;

import ads.bcd.sofia.controller.pessoa.JovemController;
import ads.bcd.sofia.model.pessoa.Jovem;
import ads.bcd.sofia.model.progressao.distintivo.Distintivo;
import ads.bcd.sofia.model.progressao.especialidade.Especialidade;
import ads.bcd.sofia.model.progressao.insignia.Insignia;
import ads.bcd.sofia.service.views.JovemProgressoService;
import ads.bcd.sofia.utils.Input;
import ads.bcd.sofia.utils.Table;
import ads.bcd.sofia.views.JovemProgresso;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class JovemProgressoController {

    private JovemProgressoService service;

    public void getJovemProgresso(Integer id) {

        JovemProgresso progresso = service.getJovemProgresso(id);
        Jovem jovem = progresso.getJovem();
        List<Especialidade> especialidades = progresso.getEspecialidades();
        List<Insignia> insignias = progresso.getInsignias();
        List<Distintivo> distintivos = progresso.getDistintivos();

        int length = Math.max(Math.max(especialidades.size(), insignias.size()), distintivos.size());

        Table.TableBuilder table = Table.createTable();
        table.setTitle("PROGRESSO JOVEM " + jovem.getNome().toUpperCase());
        table.addColumn("Especialidades", 20);
        table.addColumn("Insígnias", 10);
        table.addColumn("Distintivos", 15);

        for (int i = 0; i < length; i++) {
            String esp = i < especialidades.size() ? especialidades.get(i).getNome() : "";
            String ins = i < insignias.size() ? insignias.get(i).getNome() : "";
            String dis = i < distintivos.size() ? distintivos.get(i).getNome() : "";

            table.addRow(esp, ins, dis);
        }
        table.print();
    }

}
