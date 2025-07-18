package ads.bcd.sofia;

import ads.bcd.sofia.utils.Input;
import ads.bcd.sofia.utils.Menus;

import java.util.Scanner;

public class App {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Input i = new Input(scanner);

    public static void main(String[] args) {
        try {
            mainMenu();
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void mainMenu() {
        System.out.println(Menus.MENU);
        Integer page = i.getMenuInput(9);

        switch (page) {
            case 0 -> safeExit();
            case 1 -> System.out.println("Cadastrar novo Jovem");
            case 2 -> System.out.println("Atualizar Jovem");
            case 3 -> System.out.println("Consultar Jovem");
            case 4 -> System.out.println("Cadastrar Especialidade");
            case 5 -> System.out.println("Registrar Requisito Cumprido Especialidade");
            case 6 -> System.out.println("Cadastrar Insignia para Jovem");
            case 7 -> System.out.println("Cadastrar Distintivo para Jovem");
            case 8 -> System.out.println("Registrar Particiação em Acampamento");
            case 9 -> logMenu();
        }
    }

    private static void logMenu() {
        System.out.println(Menus.RELATORIOS);
        Integer page = i.getMenuInput(5);

        switch (page) {
            case 0 -> mainMenu();
            case 1 -> System.out.println("Cadastrar novo Jovem");
            case 2 -> System.out.println("Atualizar Jovem");
            case 3 -> System.out.println("Consultar Jovem");
            case 4 -> System.out.println("Cadastrar Especialidade");
            case 5 -> System.out.println("Registrar Requisito Cumprido Especialidade");
        }
    }

    private static void safeExit() {
        scanner.close();
        System.exit(0);
    }

}
