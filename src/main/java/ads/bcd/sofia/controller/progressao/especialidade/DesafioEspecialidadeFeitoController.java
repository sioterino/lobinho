package ads.bcd.sofia.controller.progressao.especialidade;

import ads.bcd.sofia.controller.pessoa.JovemController;
import ads.bcd.sofia.model.pessoa.Jovem;
import ads.bcd.sofia.model.progressao.especialidade.DesafioEspecialidade;
import ads.bcd.sofia.model.progressao.especialidade.DesafioEspecialidadeFeita;
import ads.bcd.sofia.service.progressao.especialidade.DesafioEspecialidadeFeitoService;
import ads.bcd.sofia.utils.Input;
import ads.bcd.sofia.utils.Table;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

@Controller
@AllArgsConstructor
public class DesafioEspecialidadeFeitoController {

    private DesafioEspecialidadeFeitoService service;
    private Input input;
    private JovemController jovemController;
    private DesafioEspecialidadeController desafioEspecialidadeController;

    public void print(List<DesafioEspecialidadeFeita> feitos) {
        if (feitos.isEmpty()) {
            System.out.println("Não há requisitos de especialidade concluídos cadastrados.");
            return;
        }

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);

        Table.TableBuilder table = Table.createTable();
        table.setTitle("REQUISITOS DE ESPECIALIDADE CONCLUÍDOS");
        table.addColumn("ID", 5);
        table.addColumn("Jovem Nome", 20);
        table.addColumn("Especialidade", 20);
        table.addColumn("Conclusão", 15);

        for (DesafioEspecialidadeFeita def : feitos)
            table.addRow(String.valueOf(def.getId()), def.getJovem().getNome(),
                    def.getDesafioEspecialidade().getEspecialidade().getNome(), def.getData().format(formatter));
        table.print();
    }

    public void printAll() {
        List<DesafioEspecialidadeFeita> feitos = service.findAll();
        print(feitos);
    }

    public void create() {
        System.out.println("Registro de Jovem que Completou Requisito para Especialidade\n");

        DesafioEspecialidadeFeita def = new DesafioEspecialidadeFeita();

        jovemController.printAll();
        System.out.println("Selecione um Jovem.");
        int idJovem = input.getId(jovemController.size());
        Jovem jovem = jovemController.getById(idJovem);
        def.setJovem(jovem);
        System.out.println("Você selecionou: " + jovem.getNome() + ".");

        desafioEspecialidadeController.printAll();
        System.out.println("Selecione um Requisito de Especialidade.");
        int idRequisito = input.getId(desafioEspecialidadeController.size());
        DesafioEspecialidade desafio = desafioEspecialidadeController.getById(idRequisito);
        def.setDesafioEspecialidade(desafio);
        System.out.println("Você selecionou: " + desafio.getNome() + ".");

        System.out.print("Data de conslusão (yyyy-MM-dd)");
        def.setData(input.getDate());

        service.save(def);
        printAll();
    }

}
