package ads.bcd.sofia;

import ads.bcd.sofia.controller.atividade.AcampamentosController;
import ads.bcd.sofia.controller.atividade.NoiteAcampadaController;
import ads.bcd.sofia.controller.pessoa.JovemController;
import ads.bcd.sofia.controller.pessoa.ResponsavelController;
import ads.bcd.sofia.controller.pessoa.VinculoController;
import ads.bcd.sofia.controller.progressao.distintivo.DesafioDistintivoController;
import ads.bcd.sofia.controller.progressao.distintivo.DesafioDistintivoFeitoController;
import ads.bcd.sofia.controller.progressao.distintivo.DistintivoController;
import ads.bcd.sofia.controller.progressao.especialidade.DesafioEspecialidadeController;
import ads.bcd.sofia.controller.progressao.especialidade.DesafioEspecialidadeFeitoController;
import ads.bcd.sofia.controller.progressao.especialidade.EspecialidadeController;
import ads.bcd.sofia.controller.progressao.insignia.DesafioInsigniaController;
import ads.bcd.sofia.controller.progressao.insignia.DesafioInsigniaFeitoController;
import ads.bcd.sofia.controller.progressao.insignia.InsigniaController;
import ads.bcd.sofia.controller.saude.ProblemaSaudeController;
import ads.bcd.sofia.controller.saude.SaudeController;
import ads.bcd.sofia.controller.saude.TipoSanguineoController;
import ads.bcd.sofia.controller.views.AptidaoCruzeiroController;
import ads.bcd.sofia.controller.views.JovemProgressoController;
import ads.bcd.sofia.utils.Input;
import ads.bcd.sofia.utils.enums.Menus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
@AllArgsConstructor
public class App {

    private final Scanner scanner;
    private final Input input;
    private final AptidaoCruzeiroController aptidaoCruzeiroController;
    private final ResponsavelController responsavelController;
    private final VinculoController vinculoController;
    private final NoiteAcampadaController noiteAcampadaController;
    private final EspecialidadeController especialidadeController;
    private final DesafioEspecialidadeController desafioEspecialidadeController;
    private final InsigniaController insigniaController;
    private final DesafioInsigniaController desafioInsigniaController;
    private final DistintivoController distintivoController;
    private final DesafioDistintivoController desafioDistintivoController;
    private final TipoSanguineoController tipoSanguineoController;
    private final ProblemaSaudeController problemaSaudeController;
    private final SaudeController saudeController;
    private final AcampamentosController acampamentosController;

    private JovemController jovemController;
    private DesafioEspecialidadeFeitoController desafioEspecialidadeFeitoController;
    private DesafioInsigniaFeitoController desafioInsigniaFeitoController;
    private DesafioDistintivoFeitoController desafioDistintivoFeitoController;
    private NoiteAcampadaController acampadaController;
    private JovemProgressoController jovemProgressoController;

    public void landingPage() {
        System.out.println(Menus.HELLO);
        scanner.nextLine();
        mainMenu();
    }

    public void mainMenu() {
        while (true) {
            System.out.println(Menus.MENU);
            Integer page = input.getInteger(9);

            switch (page) {
                // termina a aplicação de forma segura
                case 0 -> safeExit();
                // cria um cadastro de jovem no banco de dados
                case 1 -> jovemController.create();
                // atualiza os dados cadastrais de um jovem no banco de dados
                case 2 -> jovemController.update();
                // lista todos os jovens e os seus dados cadastrais
                case 3 -> jovemController.print(List.of(jovemController.selectJovem()));
                // registra um requisito de especialidae cumprido para um jovem
                case 4 -> desafioEspecialidadeFeitoController.create();
                // registra um desafio de insignia cumprido para um jovem
                case 5 -> desafioInsigniaFeitoController.create();
                // registra um desafio de distintivo cumprido para um jovem
                case 6 -> desafioDistintivoFeitoController.create();
                // registra a participação de um jovem em um acampamento
                case 7 -> acampadaController.create();
                // carrega a página de relatórios e consultas
                case 8 -> logMenu();
            }
        }
    }

    public void logMenu() {
        while (true) {
            System.out.println(Menus.RELATORIOS);
            Integer page = input.getInteger(22);

            switch (page) {
                // volta ao menu principal
                case 0 -> mainMenu();
                // carrega as (especialidades) de um jovem
                case 1 -> desafioEspecialidadeFeitoController.getEspecialidadeByJovem();
                // carrega as (insígnias) de um jovem
                case 2 -> desafioInsigniaFeitoController.getInsigniaByJovem();
                // carrega os (distintivos) de um jovem
                case 3 -> desafioDistintivoFeitoController.getDistintivoByJovem();
                // carrega as especialidades e insígnias de um jovem
                case 4 -> jovemProgressoController.getJovemProgresso(jovemController.selectJovem().getIdJovem());
                // carrega os jovems aptos aos distintivo de (cruzeiro do sul)
                case 5 -> aptidaoCruzeiroController.printAll();

                case 6 -> jovemController.printAll();
                case 7 -> responsavelController.printAll();
                case 8 -> vinculoController.printAll();
                case 9 -> acampamentosController.printAll();
                case 10 -> noiteAcampadaController.printAll();

                case 11 -> especialidadeController.printAll();
                case 12 -> desafioEspecialidadeController.printAll();
                case 13 -> desafioEspecialidadeFeitoController.printAll();

                case 14 -> insigniaController.printAll();
                case 15 -> desafioInsigniaController.printAll();
                case 16 -> desafioInsigniaFeitoController.printAll();

                case 17 -> distintivoController.printAll();
                case 18 -> desafioDistintivoController.printAll();
                case 19 -> desafioDistintivoFeitoController.printAll();

                case 20 -> tipoSanguineoController.printAll();
                case 21 -> problemaSaudeController.printAll();
                case 22 -> saudeController.printAll();

            }
        }
    }

    private void safeExit() {
        scanner.close();
        System.out.println(Menus.BYE);
        System.exit(0);
    }

}
