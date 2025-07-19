package ads.bcd.sofia.utils;

import java.util.List;
import java.util.ArrayList;

public class Table {

    public static class TableBuilder {
        private final List<String> headers;
        private final List<Integer> columnWidths;
        private final List<List<String>> rows;
        private String title;

        public TableBuilder() {
            this.headers = new ArrayList<>();
            this.columnWidths = new ArrayList<>();
            this.rows = new ArrayList<>();
        }

        public TableBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public TableBuilder addColumn(String header, int width) {
            headers.add(header);
            columnWidths.add(width);
            return this;
        }

        public TableBuilder addRow(String... values) {
            if (values.length != headers.size())
                throw new IllegalArgumentException("Row must have " + headers.size() + " columns");

            List<String> row = new ArrayList<>();
            for (int i = 0; i < values.length; i++) {
                String value = values[i];
                // trunca se for muito longo, padding se for muito curto
                if (value.length() > columnWidths.get(i))
                    value = value.substring(0, columnWidths.get(i) - 3) + "...";
                row.add(value);
            }
            rows.add(row);
            return this;
        }

        public void print() {
            if (headers.isEmpty()) {
                System.out.println("No columns defined");
                return;
            }

            if (rows.isEmpty()) {
                System.out.println("No data to display");
                return;
            }

            // calcula o width total da tabela > 3 para separadores, 4 para bordas
            int totalWidth = columnWidths.stream().mapToInt(Integer::intValue).sum() + (columnWidths.size() - 1) * 3 + 4;

            // caso a tabela tenha um título ela é printada
            if (title != null && !title.isEmpty()) {
                // borda de cima só com cantos
                printSimpleTopBorder();
                // título com o espaçamento ideal
                printTitle(totalWidth);
                // linha com intersecções inferiores
                printTitleToHeaderSeparator();
            } else printTopBorder();
            // se não, printa o topo da tabela sem título


            printRow(headers); // titulo das colunas
            printMiddleBorder(); // linhas de intersecção

            for (int i = 0; i < rows.size(); i++) {
                printRow(rows.get(i));
                if (i < rows.size() - 1)
                    printMiddleBorder(); // linhas de intersecção
                else printBottomBorder();
            }
        }

        private void printTopBorder() {
            System.out.print("┌");
            for (int i = 0; i < columnWidths.size(); i++) {
                System.out.print("─".repeat(columnWidths.get(i) + 2));
                if (i < columnWidths.size() - 1) System.out.print("┬");
            }
            System.out.println("┐");
        }

        private void printBottomBorder() {
            System.out.print("└");
            for (int i = 0; i < columnWidths.size(); i++) {
                System.out.print("─".repeat(columnWidths.get(i) + 2));
                if (i < columnWidths.size() - 1) System.out.print("┴");
            }
            System.out.println("┘");
        }

        private void printMiddleBorder() {
            System.out.print("├");
            for (int i = 0; i < columnWidths.size(); i++) {
                System.out.print("─".repeat(columnWidths.get(i) + 2));
                if (i < columnWidths.size() - 1) System.out.print("┼");
            }
            System.out.println("┤");
        }

        private void printTitle(int totalWidth) {
            String paddedTitle = " " + title + " ";
            int padding = totalWidth - paddedTitle.length() - 2;
            int leftPadding = padding / 2;
            int rightPadding = padding - leftPadding;
            System.out.printf("│%s%s%s│\n", " ".repeat(leftPadding), paddedTitle, " ".repeat(rightPadding));
        }

        private void printRow(List<String> data) {
            System.out.print("│");
            for (int i = 0; i < data.size(); i++) {
                System.out.printf(" %-" + columnWidths.get(i) + "s ", data.get(i));
                if (i < data.size() - 1) System.out.print("│");
            }
            System.out.println("│");
        }

        private void printSimpleTopBorder() {
            // calcula width total para fazer o topo da tabela 3 para separadores, 2 de padding
            int totalWidth = columnWidths.stream().mapToInt(Integer::intValue).sum() + (columnWidths.size() - 1) * 3 + 2;
            System.out.print("┌");
            System.out.print("─".repeat(totalWidth));
            System.out.println("┐");
        }

        private void printTitleToHeaderSeparator() {
            System.out.print("├");
            for (int i = 0; i < columnWidths.size(); i++) {
                System.out.print("─".repeat(columnWidths.get(i) + 2));
                if (i < columnWidths.size() - 1) System.out.print("┬");
            }
            System.out.println("┤");
        }
    }

    public static TableBuilder createTable() {
        return new TableBuilder();
    }

    // método de conveniencia para tabelas pequenas
    public static void printSimpleTable(String title, String[] headers, int[] columnWidths, List<String[]> data) {
        TableBuilder builder = createTable().setTitle(title);

        for (int i = 0; i < headers.length; i++) builder.addColumn(headers[i], columnWidths[i]);
        for (String[] row : data) builder.addRow(row);

        builder.print();
    }
}
