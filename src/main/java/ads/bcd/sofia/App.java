package ads.bcd.sofia;


import ads.bcd.sofia.controller.pessoa.JovemController;
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
                case 4 -> System.out.println("Cadastrar Especialidade");
                case 5 -> System.out.println("Registrar Requisito Cumprido Especialidade");
                case 6 -> System.out.println("Cadastrar Insignia para Jovem");
                case 7 -> System.out.println("Cadastrar Distintivo para Jovem");
                case 8 -> System.out.println("Registrar Particiação em Acampamento");
                case 9 -> logMenu();
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
                case 2 -> System.out.println("Atualizar Jovem");
                case 3 -> System.out.println("Consultar Jovem");
                case 4 -> System.out.println("Cadastrar Especialidade");
                case 5 -> System.out.println("Registrar Requisito Cumprido Especialidade");
            }
        }
    }

    private void safeExit() {
        scanner.close();
        System.out.println(Menus.BYE);
        System.exit(0);
    }

}
