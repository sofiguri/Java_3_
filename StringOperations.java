import java.util.Scanner;

public class StringOperations {
    public static void inputStrings(Scanner scanner) {
        System.out.println("Введите первую строку: ");
        // scanner.next();
        String str1 = scanner.nextLine();
        System.out.println("Введите вторую строку: ");
        String str2 = scanner.nextLine();

        // Вывод строк в терминал
        System.out.println("Введены строки:\n(1) " + str1 + "\n(2) " + str2);
        // Сохранение в бд
        DBhandler.saveString(str1, str2);

    }

    public static void StringSize() {

        String str1 = DBhandler.getStrFromDB(1);
        String str2 = DBhandler.getStrFromDB( 2);
        int len1 = str1.length();
        int len2 = str2.length();
        System.out.println("[" + str1 + "]" + " Длинна = " + len1);
        System.out.println("[" + str2 + "]" + " Длинна = " + len2);
        DBhandler.insertStrSize(len1, len2);
    }

    public static void StringConcat(){
        String str1 = DBhandler.getStrFromDB(1);
        String str2 = DBhandler.getStrFromDB(2);
        String str3 = str1.concat(str2);
        DBhandler.insertStrConcat(str3);
    }
    public static void StringCompare(){
        String str1 = DBhandler.getStrFromDB(1);
        String str2 = DBhandler.getStrFromDB(2);
        int compare = str1.compareTo(str2);
        DBhandler.insertComparison(compare);
    }
}
