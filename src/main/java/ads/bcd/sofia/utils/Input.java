package ads.bcd.sofia.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.awt.*;
import java.sql.SQLOutput;
import java.util.Scanner;

@Data
@AllArgsConstructor
public class Input {
    
    private Scanner scanner;
    
    public Integer getMenuInput(int max) {

        while (true) {
            String input = this.get();
            if(input.isBlank()) continue;

            if (input.replaceAll("-", "").length() > 1) {
                System.out.println("Insira apenas um valor.\n");
                continue;
            }

            int num = -1;

            try {
                num = Integer.parseInt(String.valueOf(input));
            } catch (NumberFormatException e) {
                System.out.println("Insira um valor numérico.\n");
                continue;
            }

            if (num >= 0 && num <= max) {
                return num;
            } else {
                System.out.println("Insira um valor entre 0 e " + max +".\n");
            }
        }
    }

    public String getString() {

        while(true) {
            String input = scanner.nextLine().trim();
            if (input.isBlank()) continue;

            return input;
        }

    }

    private String get() {
        System.out.print(Menus.INPUT);
        return scanner.nextLine().trim();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Input inp = new Input(sc);

        System.out.println(Menus.MENU);
        Integer input = inp.getMenuInput(9);

        System.out.println("you pressed: " + input);

    }
    
}
