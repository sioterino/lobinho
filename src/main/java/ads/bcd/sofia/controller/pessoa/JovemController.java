package ads.bcd.sofia.controller.pessoa;

import ads.bcd.sofia.controller.saude.ProblemaSaudeController;
import ads.bcd.sofia.controller.saude.SaudeController;
import ads.bcd.sofia.controller.saude.TipoSanguineoController;
import ads.bcd.sofia.model.pessoa.Jovem;
import ads.bcd.sofia.model.pessoa.Vinculo;
import ads.bcd.sofia.model.saude.Saude;
import ads.bcd.sofia.model.saude.TipoSanguineo;
import ads.bcd.sofia.service.pessoa.JovemService;
import ads.bcd.sofia.utils.Input;
import ads.bcd.sofia.utils.Table;
import ads.bcd.sofia.utils.enums.Menus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class JovemController {

    private final Input input;
    private final JovemService service;
    private final ResponsavelController responsavelController;
    private final TipoSanguineoController tipoSanguineoController;
    private final VinculoController vinculoController;
    private final SaudeController saudeController;
    private final ProblemaSaudeController problemaSaudeController;

    public void print(List<Jovem> jovens) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy", Locale.ENGLISH);

        if (jovens.isEmpty()) {
            System.out.println("Não há jovens cadastrados ainda.\n");
            return;
        }

        Table.TableBuilder table = Table.createTable();

        table.setTitle("JOVENS");
        table.addColumn("ID", 5);
        table.addColumn("Nome", 20);
        table.addColumn("Nascimento", 12);
        table.addColumn("Sangue", 6);
        table.addColumn("Responsável", 20);
        table.addColumn("Problema Saúde", 15);
        table.addColumn("Descrição", 30);
        table.addColumn("Observações", 30);

        for (Jovem j : jovens) {
            List<Saude> saudes = saudeController.getSaudesByJovemId(j.getIdJovem());
            String problema = saudeController.joinTipos(saudes);
            String descricao = saudeController.joinDescricoes(saudes);
            String observacao = saudeController.joinObservacoes(saudes);

            table.addRow(
                    String.valueOf(j.getIdJovem()), j.getNome(), j.getDataNascimento().format(formatter),
                    j.getTipoSanguineo().getTipo(), vinculoController.getResponsavelNameByIdJovem(j.getIdJovem()),
                    problema, descricao, observacao
            );
        }

        table.print();
    }

    public void printAll() { print(service.findAll()); }

    public void simplePrint(List<Jovem> jovens) {
        if (jovens.isEmpty()) {
            System.out.println("Não há jovens cadastrados ainda.\n");
            return;
        }

        Table.TableBuilder table = Table.createTable();
        table.setTitle("JOVENS");
        table.addColumn("ID", 5);
        table.addColumn("Nome", 20);
        for (Jovem j : jovens)
            table.addRow(String.valueOf(j.getIdJovem()), j.getNome());
        table.print();
    }

    public void simplePrintAll() { simplePrint(service.findAll()); }

    public void create() {
        System.out.println("Cadastro de Novo Jovem\n");
        Jovem jovem = new Jovem();
        Vinculo vinculo = new Vinculo();

        setName(jovem);
        setDataNascimento(jovem);
        setTipoSanguineo(jovem);
        setVinculo(jovem, vinculo);
        saudeController.create(jovem);

        service.save(jovem);
        vinculoController.save(vinculo);
        print(List.of(jovem));
    }

    public void update() {
        System.out.println("Atualização de Dados Cadastrais de um Jovem\n");

        Jovem jovem = selectJovem();
        while (true) {

            System.out.println(Menus.JOVEM_UPDATE);
            int option = input.getInteger(7);

            switch (option) {
                case 0 -> { return; }
                case 1 -> setName(jovem);
                case 2 -> setDataNascimento(jovem);
                case 3 -> setTipoSanguineo(jovem);
                case 4 -> updateVinculo(jovem);
                case 5 -> {
                    Vinculo vinculo = new Vinculo();
                    setVinculo(jovem, vinculo);
                    vinculoController.save(vinculo);
                }
                case 6 -> saudeController.update(jovem);
                case 7 -> saudeController.create(jovem);
                case 8 -> jovem = selectJovem();
            }

            service.save(jovem);
            print(List.of(jovem));
        }
    }

    public Jovem selectJovem() {
        simplePrintAll();
        System.out.println("Selecione um Jovem.");
        int idJovem = input.getId(getAllIds());
        Jovem jovem = getById(idJovem);
        System.out.println("Você selecionou: " + jovem.getNome() + ".");
        return jovem;
    }

    public Jovem getById(int id) {
        Optional<Jovem> jovem = service.findById(id);
        if (jovem.isEmpty()) throw new RuntimeException("<JovemController> Não foi possível acessar Jovem no id " + id);
        return jovem.get();
    }

    public List<Integer> getAllIds() {
        return service.findAll().stream().map(Jovem::getIdJovem).collect(Collectors.toList());
    }

    private void setName(Jovem jovem) {
        System.out.print("Nome: ");
        jovem.setNome(input.getString());
    }

    private void setDataNascimento(Jovem jovem) {
        System.out.print("Data de Nascimento (yyyy-MM-dd): ");
        jovem.setDataNascimento(input.getDate());
    }

    private void setTipoSanguineo(Jovem jovem) {
        TipoSanguineo tipo = tipoSanguineoController.selectTipoSanguineo();
        jovem.setTipoSanguineo(tipo);
    }

    private void updateVinculo(Jovem jovem) {
        Vinculo vinculo = vinculoController.selectVinculoByIdJovem(jovem.getIdJovem());
        setVinculo(jovem, vinculo);
        vinculoController.save(vinculo);
    }

    private void setVinculo(Jovem jovem, Vinculo vinculo) {
        vinculo.setJovem(jovem);
        vinculo.setResponsavel(responsavelController.selectResponsavel());
    }

}
