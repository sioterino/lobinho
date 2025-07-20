package ads.bcd.sofia.controller.saude;

import ads.bcd.sofia.controller.pessoa.ResponsavelController;
import ads.bcd.sofia.model.pessoa.Jovem;
import ads.bcd.sofia.model.saude.ProblemaSaude;
import ads.bcd.sofia.model.saude.Saude;
import ads.bcd.sofia.service.saude.SaudeService;
import ads.bcd.sofia.utils.Input;
import ads.bcd.sofia.utils.Table;
import ads.bcd.sofia.utils.enums.Menus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class SaudeController {

    private final SaudeService saudeService;
    private final ResponsavelController responsavelController;
    private SaudeService service;
    private Input input;
    private ProblemaSaudeController problemaSaudeController;

    public void print(List<Saude> saudes) {
        if (saudes.isEmpty()) {
            System.out.println("Não há nenhum jovem com problemas de saúde cadastrado no sistema.");
            return;
        }

        Table.TableBuilder table = Table.createTable();
        table.setTitle("PROBLEMAS DE SAÚDE DE JOVENS")
                .addColumn("ID", 5)
                .addColumn("Jovem Nome", 20)
                .addColumn("Tipo", 15)
                .addColumn("Descrição", 60)
                .addColumn("Observações", 30);
        saudes.forEach((s) -> table.addRow(String.valueOf(s.getId()), s.getJovem().getNome(),
            s.getProblemaSaude().getTipoProblema(), s.getProblemaSaude().getDescricao(), safeObservacoes(s)));
        table.print();
    }

    public void printAll() { print(service.findAll()); }

    public void printSaudeJovem(List<Saude> saudes) {
        if (saudes.isEmpty()) {
            System.out.println("Não há nenhum jovem com problemas de saúde cadastrado no sistema.");
            return;
        }

        Table.TableBuilder table = Table.createTable();
        table.setTitle("PROBLEMAS DE SAÚDE DE " + saudes.getFirst().getJovem().getNome().toUpperCase())
                .addColumn("ID", 5)
                .addColumn("Tipo", 15)
                .addColumn("Descrição", 60)
                .addColumn("Observações", 30);
        saudes.forEach((s) -> table.addRow(String.valueOf(s.getId()), s.getProblemaSaude().getTipoProblema(),
                    s.getProblemaSaude().getDescricao(), safeObservacoes(s)));
        table.print();
    }

    public void create(Jovem jovem) {
        Saude saude = new Saude();
        saude.setJovem(jovem);

        setProblemaSaude(saude);
        setObservacoes(saude);

        service.save(saude);
    }

    public void update(Jovem jovem) {
        Saude saude = selectSaude(jovem);
        while (true) {
            System.out.println(Menus.SAUDE_UPDATE);
            int option = input.getInteger(7);

            switch (option) {
                case 0 -> { return; }
                case 1 -> {
                    setProblemaSaude(saude);
                    service.save(saude);
                }
                case 2 -> {
                    setObservacoes(saude);
                    service.save(saude);
                }
                case 3 -> saude = selectSaude(jovem);
            }
        }
    }

    public Saude selectSaude(Jovem jovem) {
        List<Saude> saudes = service.getSaudeByIdJovem(jovem.getIdJovem());
        printSaudeJovem(saudes);
        System.out.println("Selecione um Problema de Saúde para editar.");
        int idSaude = input.getId(getAllIds(saudes));
        Saude saude = getById(idSaude);
        System.out.println("Você selecionou: " + saude.getId() + ".");
        return saude;
    }

    public List<Integer> getAllIds(List<Saude> saudes) {
        return saudes.stream().map(Saude::getId).toList();
    }

    public Saude getById(Integer id) {
        return service.findById(id).orElseThrow(() -> new RuntimeException("Não foi possível acessar Saúde no id " + id));
    }

    public void setProblemaSaude(Saude saude) {
        String tipoProblema = problemaSaudeController.selectTipoProblema();
        ProblemaSaude problema = problemaSaudeController.selectProblemaSaude(tipoProblema);
        saude.setProblemaSaude(problema);
    }

    public void setObservacoes(Saude saude) {
        System.out.print("Observações: ");
        String descricao = input.getEmptyString();
        if (!descricao.isBlank()) saude.setObservacoes(descricao);
        else saude.setObservacoes(null);
    }

    public List<Saude> getSaudesByJovemId(int id) {
        return service.getSaudeByIdJovem(id);
    }

    public String joinTipos(List<Saude> saudes) {
        if (saudes.isEmpty()) return "";
        if (saudes.size() == 1) return saudes.getFirst().getProblemaSaude().getTipoProblema();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < saudes.size(); i++) {
            sb.append(saudes.get(i).getProblemaSaude().getTipoProblema());
            if (i < saudes.size() - 1) sb.append(", ");
        }
        return sb.toString();
    }

    public String joinDescricoes(List<Saude> saudes) {
        if (saudes.isEmpty()) return "";
        if (saudes.size() == 1) return saudes.getFirst().getProblemaSaude().getDescricao();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < saudes.size(); i++) {
            sb.append(saudes.get(i).getProblemaSaude().getDescricao());
            if (i < saudes.size() - 1) sb.append(", ");
        }
        return sb.toString();
    }

    public String joinObservacoes(List<Saude> saudes) {
        if (saudes.isEmpty()) return "";
        if (saudes.size() == 1) {
            String obs = saudes.getFirst().getObservacoes();
            return obs != null ? obs : "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < saudes.size(); i++) {
            String obs = saudes.get(i).getObservacoes();
            if (obs != null && !obs.isBlank()) sb.append(obs);
            boolean hasNextNonNull = i < saudes.size() - 1 && saudes.get(i + 1).getObservacoes() != null;
            if (hasNextNonNull && obs != null) sb.append(", ");
        }

        return sb.toString();
    }


    public String safeObservacoes(Saude saude) {
        return saude.getObservacoes() != null ? saude.getObservacoes() : "";
    }

}
