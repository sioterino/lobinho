package ads.bcd.sofia.controller.pessoa;

import ads.bcd.sofia.model.pessoa.Responsavel;
import ads.bcd.sofia.model.pessoa.Vinculo;
import ads.bcd.sofia.service.pessoa.VinculoService;
import ads.bcd.sofia.utils.Input;
import ads.bcd.sofia.utils.Table;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
public class VinculoController {

    private final VinculoService service;
    private final Input input;

    public void printAll() {
        List<Vinculo> vinculos = service.findAll();
        printAll(vinculos);
    }

    public void printAll(List<Vinculo> vinculos) {
        if (vinculos.isEmpty()) {
            System.out.println("Nenhum vínculo encontrado.");
            return;
        }

        Table.TableBuilder table = Table.createTable();

        table.setTitle("VÍNCULOS");

        table.addColumn("ID", 5);
        table.addColumn("Jovem ID", 8);
        table.addColumn("Jovem Nome", 25);
        table.addColumn("Resp. ID", 8);
        table.addColumn("Resp. Nome", 25);

        for (Vinculo v : vinculos)
            table.addRow(
                    String.valueOf(v.getIdVinculo()),
                    String.valueOf(v.getJovem().getIdJovem()), v.getJovem().getNome(),
                    String.valueOf(v.getResponsavel().getIdResponsavel()), v.getResponsavel().getNome()
            );

        table.print();
    }

    public void save(Vinculo entidade) {
        service.save(entidade);
    }

    public Vinculo getVinculoByIdJovem(int id) {
        List<Vinculo> vinculos = service.getVinculoByIdJovem(id);
        printAll(vinculos);
        System.out.println("Selecione um vínculo para editar.");
        int idVinculo = input.getInteger(vinculos.getFirst().getIdVinculo(), vinculos.getLast().getIdVinculo());
        return getById(idVinculo);
    }

    public Vinculo getById(int id) {
        Optional<Vinculo> vinculo = service.findById(id);
        if (vinculo.isEmpty())
            throw new RuntimeException("<VinculoController> Não foi possível acessar Vinculo no id " + id);
        return vinculo.get();
    }

    public List<Responsavel> getResponsavelByIdJovem(int id) {
        return service.getResponsavelByIdJovem(id);
    }

    public String getResponsavelNameByIdJovem(int id) {
        List<Responsavel> responsaveis = getResponsavelByIdJovem(id);
        if (responsaveis.isEmpty()) return "";
        if (responsaveis.size() == 1) return responsaveis.getFirst().getNome();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < responsaveis.size(); i++) {
            sb.append(responsaveis.get(i).getNome());
            if (i < responsaveis.size() - 1) sb.append(", ");
        }
        return sb.toString();
    }

}