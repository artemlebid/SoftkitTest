import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Random list with a strings
        List<String> strings = List.of(
                "dddddaaaaadda", "dddada", "ccaacacaaa", "aacc",
                "cacaccffffffaa", "ffffafafff", "fffaq", "qqqaaaaa",
                "d", "cssss", "cqwww", "d", "aaa", "bbb", "ccc", "d"
        );


        //Calling the function
        System.out.println("--------FOUR COLUMNS--------");
        createTable(strings, 4);

        System.out.println("\n--------THREE COLUMNS--------");
        createTable(strings, 3);

        System.out.println("\n--------TWO COLUMNS--------");
        createTable(strings, 2);
    }

    //Function that print a table
    public static void createTable(List<String> lines, int columnCount){
        // Check if list is not empty
        if (lines.isEmpty()){
            System.out.println("Table can't created! You don't provide any strings\n");
            return;
        }

        // Check positive column count
        if(columnCount <= 0){
            System.out.println("Table can't created! You can't have less than 1 column\n");
            return;
        }

        // Check items length and column length
        if(columnCount > lines.size()){
            System.out.printf("Warning! Here can't be %d columns because you have only %d items in list\n\n", columnCount, lines.size());
        }

        // Find a size of length
        int lineWidth = lines.stream().mapToInt(String::length).max().orElse(0) + 5;

        // Loop that print a table
        for (int i = 0; i < lines.size(); i++) {

            // Print line (by word in each column)
            System.out.printf("%-" + lineWidth + "s", lines.get(i));

            // If max columns, move into new line
            if ((i + 1) % columnCount == 0 || i == lines.size() - 1) {
                System.out.println();
            }
        }
    }
}