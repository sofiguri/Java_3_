import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("""
                    1. Вывести все таблицы из MySQL.
                    2. Создать таблицу в MySQL.
                    3. Ввести две строки с клавиатуры, результат сохранить в MySQL с последующим выводом в
                    консоль.
                    4. Подсчитать размер ранее введенных строк, результат сохранить в MySQL с последующим
                    выводом в консоль.
                    5. Объединить две строки в единое целое, результат сохранить в MySQL с последующим выводом
                    в консоль.
                    6. Сравнить две ранее введенные строки, результат сохранить в MySQL с последующим выводом
                    в консоль.
                    7. Сохранить все данные (вышеполученные результаты) из MySQL в Excel и вывести на экран 
                    0. Выход.""");

            String s = scanner.nextLine();
            choice = Integer.parseInt(s);
            handleUserChoice(choice, scanner, DBhandler.getTableName());
        } while (choice != 0);
    }

    private static void handleUserChoice (int choice, Scanner scanner, String tableName) {
        String a, b;
        switch (choice) {
            case 1:
                DBhandler.showAllTables();
                break;
            case 2:
                System.out.println("Введите название для создания таблицы:");
                DBhandler.setTableName(scanner.nextLine());
                DBhandler.createTable();
                break;
            case 3:
                StringOperations.inputStrings(scanner);
                break;
            case 4:
                StringOperations.StringSize();
                break;
            case 5:
                StringOperations.StringConcat();
                break;
            case 6:
                StringOperations.StringCompare();
                break;
            case 7:
                ExcelExporter exporter = new ExcelExporter();
                exporter.export();
            case 0:
                System.out.println("Выход из программы...");
                break;
            default:
                System.out.println("Неверный выбор. Попробуйте снова.");
        }
    }
}

