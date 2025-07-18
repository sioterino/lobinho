package ads.bcd.sofia.controller;

import ads.bcd.sofia.model.Jovem;
import ads.bcd.sofia.utils.Input;

import java.util.Scanner;

public class JovemController {

    private final Scanner scanner = new Scanner(System.in);
    private final Input i = new Input(scanner);

    public void create() {

        System.out.println("Cadastro de Novo Jovem\n");
        Jovem jovem = new Jovem();

        System.out.println("Nome: ");
        jovem.setNome(i.getString());

        System.out.println("Telefone: ");
        jovem.setTelefone(i.getString());

        System.out.println("Data de Nascimento: ");
//        jovem.setDataNascimento(i.getString());

        System.out.println("Email: ");
        jovem.setEmail(i.getString());

        System.out.println("Tipo Sanguíneo: ");
//        jovem.setTipoSanguineo(i.getString());

    }

    public void update() {}

    public void getByName() {}

    public void getById() {}

}
