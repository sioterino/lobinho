package ads.bcd.sofia.controller.progressao.especialidade;

import ads.bcd.sofia.model.progressao.especialidade.Especialidade;
import ads.bcd.sofia.service.progressao.especialidade.EspecialidadeService;
import ads.bcd.sofia.utils.Table;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class EspecialidadeController {

    private EspecialidadeService service;

    public void printAll() {
        List<Especialidade> especialidades = service.findAll();
        if (especialidades.isEmpty()) {
            System.out.println("Não há especialidades cadastradas.");
            return;
        }

        Table.TableBuilder table = Table.createTable();
        table.setTitle("ESPECIALIDADES");
        table.addColumn("ID", 5);
        table.addColumn("Nome", 20);
        table.addColumn("Área do Conhecimento", 20);

        for (Especialidade e : especialidades)
            table.addRow(String.valueOf(e.getIdEspecialidade()), e.getNome(), e.getAreaDeConhecimento().getNome());
        table.print();
    }


}
