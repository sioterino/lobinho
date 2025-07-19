package ads.bcd.sofia.utils;

import ads.bcd.sofia.utils.enums.Menus;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

@Component
@Data
public class Input {
    
    private final Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public Integer getId(int max) {
        return getInteger(1, max);
    }

    public Integer getInteger(int max) {
        return getInteger(0, max);
    }
    
    public Integer getInteger(int min, int max) {
        while (true) {
            String input = this.get();
            if(input.isBlank()) continue;

            try {
                int num = Integer.parseInt(input);
                if (num >= min && num <= max) {
                    return num;
                } else {
                    System.out.printf("Insira um valor entre %d e %d.\n\n", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.println("Insira um valor numérico.\n");
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

    public LocalDateTime getDate() {
        while(true) {
            String input = scanner.nextLine().trim();
            if (input.isBlank()) continue;
            DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

            try {
                return LocalDateTime.parse(input + " 00:00", f);
            } catch (Exception e) {
                System.out.println("Formato incorreto.\n");
            }
        }
    }

    private String get() {
        System.out.print(Menus.INPUT);
        return scanner.nextLine().trim();
    }
}
