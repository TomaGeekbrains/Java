import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PhoneBook {

    public static void main(String[] args) {
        HashMap<String, String> phoneBook = new HashMap<>();
        
        // Добавляем записи в телефонную книгу
        phoneBook.put("Шишкин", "111-1111");
        phoneBook.put("Колосов", "222-2222");
        phoneBook.put("Сидоров", "333-3333");
        phoneBook.put("Шишкин", "444-4444");
        phoneBook.put("Колосов", "555-5555");

        // Создаем новую структуру для хранения уникальных записей
        Map<String, Integer> uniqueContacts = new HashMap<>();
        
        // Обрабатываем входную телефонную книгу
        for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
            String name = entry.getKey();
            String phone = entry.getValue();
            
            // Проверяем, есть ли уже такой контакт в списке уникальных записей
            if (uniqueContacts.containsKey(name)) {
                // Если есть, то увеличиваем счетчик количества телефонов у этого контакта
                int count = uniqueContacts.get(name);
                uniqueContacts.put(name, count + 1);
            } else {
                // Иначе добавляем новую запись с 1 телефоном
                uniqueContacts.put(name, 1);
            }
        }
        
        // Создаем TreeMap для сортировки по убыванию количества телефонов
        TreeMap<Integer, String> sortedContacts = new TreeMap<>((o1, o2) -> Integer.compare(o2, o1));
        
        // Заполняем отсортированный TreeMap уникальными записями
        for (Map.Entry<String, Integer> entry : uniqueContacts.entrySet()) {
            sortedContacts.put(entry.getValue(), entry.getKey());
        }
        
        // Выводим результат
        System.out.println("Телефонная книга:");
        for (Map.Entry<Integer, String> entry : sortedContacts.entrySet()) {
            System.out.println(entry.getValue() + " - " + entry.getKey() + " телефон(ов)");
        }
    }
}