package ads.bcd.sofia.controller.pessoa;

import ads.bcd.sofia.controller.saude.TipoSanguineoController;
import ads.bcd.sofia.model.pessoa.Jovem;
import ads.bcd.sofia.model.pessoa.Responsavel;
import ads.bcd.sofia.model.pessoa.Vinculo;
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

@Controller
@AllArgsConstructor
public class JovemController {

    private final Input input;
    private final JovemService service;
    private final ResponsavelController responsavelController;
    private final TipoSanguineoController tipoSanguineoController;
    private final VinculoController vinculoController;

    public void printAll() {
        List<Jovem> jovens = service.findAll();
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
        table.addColumn("Email", 29);
        table.addColumn("Telefone", 15);
        table.addColumn("Sangue", 6);
        table.addColumn("Responsável", 20);

        for (Jovem j : jovens)
            table.addRow(
                    String.valueOf(j.getIdJovem()), j.getNome(), j.getDataNascimento().format(formatter),
                    j.getEmail(), j.getTelefone(), j.getTipoSanguineo().getTipo(), vinculoController.getResponsavelNameByIdJovem(j.getIdJovem())
            );

        table.print();
    }


    public void create() {
        System.out.println("Cadastro de Novo Jovem\n");
        Jovem jovem = new Jovem();
        Vinculo vinculo = new Vinculo();

        setName(jovem);
        setDataNascimento(jovem);
        setEmail(jovem);
        setTelefone(jovem);
        setTipoSanguineo(jovem);
        setVinculo(jovem, vinculo);

        service.save(jovem);
        vinculoController.save(vinculo);
        printAll();
    }

    public void update() {
        printAll();
        System.out.println("\nSelecione um jovem para atulizar.");
        int idJovem = input.getId(size());
        Jovem jovem = getById(idJovem);

        System.out.println(Menus.JOVEM_UPDATE);

        int option = input.getInteger(6);

        switch (option) {
            case 0 -> { return; }
            case 1 -> setName(jovem);
            case 2 -> setDataNascimento(jovem);
            case 3 -> setEmail(jovem);
            case 4 -> setTelefone(jovem);
            case 5 -> setTipoSanguineo(jovem);
            case 6 -> updateVinculo(jovem);
        }

        service.save(jovem);
        printAll();
    }

    public Jovem getById(int id) {
        Optional<Jovem> jovem = service.findById(id);
        if (jovem.isEmpty()) throw new RuntimeException("<JovemController> Não foi possível acessar Jovem no id " + id);
        return jovem.get();
    }

    public int size() {
        return service.findAll().size();
    }

    private void setName(Jovem jovem) {
        System.out.print("Nome: ");
        jovem.setNome(input.getString());
    }

    private void setTelefone(Jovem jovem) {
        System.out.print("Telefone (xx) xxxxx-xxxx: ");
        jovem.setTelefone(input.getString());
    }

    private void setDataNascimento(Jovem jovem) {
        System.out.print("Data de Nascimento (yyyy-MM-dd): ");
        jovem.setDataNascimento(input.getDate());
    }

    private void setEmail(Jovem jovem) {
        System.out.print("Email: ");
        jovem.setEmail(input.getString());
    }

    private void setTipoSanguineo(Jovem jovem) {
        tipoSanguineoController.printAll();
        System.out.println("\nEscolha um tipo sanguíneo.");
        int idTipo = input.getId(tipoSanguineoController.size());
        TipoSanguineo tipo = tipoSanguineoController.getById(idTipo);
        jovem.setTipoSanguineo(tipo);
    }

    private void updateVinculo(Jovem jovem) {
        Vinculo vinculo = vinculoController.getVinculoByIdJovem(jovem.getIdJovem());
        setVinculo(jovem, vinculo);
        vinculoController.save(vinculo);
    }

    private void setVinculo(Jovem jovem, Vinculo vinculo) {
        responsavelController.printAll();
        System.out.println("\nEscolha um responsável.");
        int idResponsavel = input.getId(responsavelController.size());
        Responsavel responsavel = responsavelController.getById(idResponsavel);

        vinculo.setJovem(jovem);
        vinculo.setResponsavel(responsavel);
    }

}
