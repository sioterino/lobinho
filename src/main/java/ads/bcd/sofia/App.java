package ads.bcd.sofia;


import ads.bcd.sofia.controller.atividade.AcampamentosController;
import ads.bcd.sofia.controller.atividade.NoiteAcampadaController;
import ads.bcd.sofia.controller.pessoa.JovemController;
import ads.bcd.sofia.controller.progressao.distintivo.DesafioDistintivoFeitoController;
import ads.bcd.sofia.controller.progressao.especialidade.DesafioEspecialidadeFeitoController;
import ads.bcd.sofia.controller.progressao.insignia.DesafioInsigniaFeitoController;
import ads.bcd.sofia.utils.Input;
import ads.bcd.sofia.utils.enums.Menus;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@AllArgsConstructor
public class App {

    private final Scanner scanner;
    private final Input input;

    private JovemController jovemController;
    private DesafioEspecialidadeFeitoController desafioEspecialidadeFeitoController;
    private DesafioInsigniaFeitoController desafioInsigniaFeitoController;
    private DesafioDistintivoFeitoController desafioDistintivoFeitoController;
    private NoiteAcampadaController acampadaController;

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
                case 0 -> safeExit();
                case 1 -> jovemController.create();
                case 2 -> jovemController.update();
                case 3 -> jovemController.printAll();
                case 4 -> desafioEspecialidadeFeitoController.create();
                case 5 -> desafioInsigniaFeitoController.create();
                case 6 -> desafioDistintivoFeitoController.create();
                case 7 -> {
                    acampadaController.printAll();
                    acampadaController.create();
                }
                case 8 -> logMenu();
            }
        }
    }

    public void logMenu() {
        while (true) {
            System.out.println(Menus.RELATORIOS);
            Integer page = input.getInteger(5);

            switch (page) {
                case 0 -> mainMenu();
                case 1 -> jovemController.printAll();
                case 2 -> System.out.println("Jovens com determinada ( Especialidade ).");
                case 3 -> System.out.println("( Especialidades e Insígnias ) de um Jovem.");
                case 4 -> System.out.println("( Requisitos de Especialidade ) cumpridos por um Jovem.");
                case 5 -> System.out.println("Jovens Aptos ao ( Cruzeiro do Sul ).");
            }
        }
    }

    private void safeExit() {
        scanner.close();
        System.out.println(Menus.BYE);
        System.exit(0);
    }

}
