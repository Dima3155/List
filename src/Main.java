import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<String> operation = Arrays.asList("Добавить", "Показать", "Удалить", "Найти");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Список операций:");
        printList(operation);
        while (true) {
            System.out.println("Введите операцию:");
            String input = scanner.nextLine();
            if ("end".equals(input)) {
                break;
            }
            if (isDigit(input)) {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1:
                        System.out.println("Какую покупку хотите добавить?");
                        String purchase = scanner.nextLine();
                        list.add(purchase);
                        System.out.println("Итого в списке покупок: " + list.size());
                        break;
                    case 2:
                        System.out.println("Список покупок:");
                        printList(list);
                        break;
                    case 3:
                        System.out.println("Список покупок:");
                        printList(list);
                        System.out.println("Какую хотите удалить? Выберите номер или название");
                        String case3 = scanner.nextLine();
                        boolean removed;
                        if (isDigit(case3)) {
                            removed = removeByIndex(list, case3);
                        } else {
                            removed = removeByValue(list, case3);
                        }
                        printResult(case3, removed);
                        printList(list);
                        break;
                    case 4:
                        System.out.println("Введите текст для поиска:");
                        case3 = scanner.nextLine();
                        if (isDigit(case3)) {
                            System.out.println("Вы ввели некорректное значение");
                        } else {
                            searchMatch(list, case3);
                        }
                        break;
                    default:
                        System.out.println("Данной операции не существует");
                }
            } else {
                System.out.println("Вы ввели некорректное значение");
            }

        }
    }

    private static void searchMatch(List<String> list, String case3) {
        String queryLower = case3.toLowerCase();
        for (int i = 0; i < list.size(); i++) {
            String itemLower = list.get(i).toLowerCase();
            if (itemLower.contains(queryLower)) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }

    private static void printResult(String case3, boolean removed) {
        if (removed) {
            System.out.println("Покупка \"" + case3 + "\" удалена. Список покупок:");
        } else {
            System.out.println("Товара нет в вашем списке");
        }
    }

    private static boolean removeByIndex(List<String> list, String case3) {
        int index = Integer.parseInt(case3);
        if (index > list.size()) {
            return false;
        }
        list.remove(index - 1);
        return true;
    }

    private static void printList(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }

    private static boolean removeByValue(List<String> list, String case3) {
        boolean removed = false;
        for (int i = 0; i < list.size(); i++) {
            if (case3.equals(list.get(i))) {
                list.remove(list.get(i));
                removed = true;
            }
        }
        return removed;
    }

    private static boolean isDigit(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}