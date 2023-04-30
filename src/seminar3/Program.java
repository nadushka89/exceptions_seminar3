package seminar3;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/*
Напишите приложение, которое будет запрашивать у пользователя следующие данные в
произвольном порядке, разделенные пробелом:
Фамилия Имя Отчество
дата рождения
номер телефона
пол
Форматы данных:
фамилия, имя, отчество - строки
дата_рождения - строка формата dd.mm.yyyy
номер_телефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым,
вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных,
чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры.
Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно
использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано,
пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в
одну строку должны записаться полученные данные, вида

<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано,
 пользователь должен увидеть стектрейс ошибки.
 */
public class Program {
    public static void main(String[] args) {
        try {
            userInput();
        } catch (WrongDataBaseException e) {
            System.out.println(e.getMessage());

        }

    }
    public static void userInput() throws WrongDataBaseException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Здравствуйте! Пожалуйста, введите следующие данные через пробел ");
        System.out.println("Фамилия Имя Отчество датарождения(формат dd.MM.yyyy) номертелефона(8**********) пол(f/m)");
        System.out.println("Ваши данные: ");
        String inputData = scanner.nextLine();
        DataBase dataBase;
        try{
            dataBase=InputParser.parse(inputData);
        }
        finally { scanner.close(); }
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(dataBase.getLastName() + ".txt",true))){
            writer.write(dataBase.toString());
            writer.newLine();
            writer.flush();
            System.out.println("Данные записаны в файл " + dataBase.getLastName() +".txt" );

        } catch (IOException e) {
            throw new WrongDataBaseException("Ошибка записи файла" + e.getMessage());
        }

    }

}
