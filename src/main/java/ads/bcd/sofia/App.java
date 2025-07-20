package ads.bcd.sofia;

import ads.bcd.sofia.controller.atividade.NoiteAcampadaController;
import ads.bcd.sofia.controller.pessoa.JovemController;
import ads.bcd.sofia.controller.progressao.distintivo.DesafioDistintivoFeitoController;
import ads.bcd.sofia.controller.progressao.especialidade.DesafioEspecialidadeFeitoController;
import ads.bcd.sofia.controller.progressao.insignia.DesafioInsigniaFeitoController;
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
            Integer page = input.getInteger(5);

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
            }
        }
    }

    private void safeExit() {
        scanner.close();
        System.out.println(Menus.BYE);
        System.exit(0);
    }

}
