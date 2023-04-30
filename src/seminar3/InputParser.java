package seminar3;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class InputParser {
    public static DataBase parse(String input) throws WrongDataBaseException{
        String[] data = input.split(" ");
        if (data.length !=6) throw new WrongDataBaseException("Введено больше данных,чем требется");
        String lastName = validName(data[0], "фамилии");
        String firstName = validName(data[1], "имени");
        String patronymicName = validName(data[2], "отчества");
        String birthDate = validBirthDate(data[3]);
        String phone = validPhone(data[4]);
        String gender = validGender(data[5]);
        return new DataBase(lastName,firstName,patronymicName,birthDate,phone,gender );

    }

    private static String validName(String name, String type) throws WrongDataBaseException {
        if(!name.matches("^[a-zA-Zа-яА-Я-]+$")){
            throw new WrongDataBaseException("Неверный формат данных" + type);
        }
        return name;
    }
    private static String validBirthDate (String birthDate) throws WrongDataBaseException {
        try {
            DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate date = LocalDate.parse(birthDate, inputFormatter);
            DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            return date.format(outputFormatter);
        } catch (DateTimeParseException e) {
            throw new WrongDataBaseException("Неверный формат данных даты рождения");
        }
    }

    private static String validPhone(String phone)throws WrongDataBaseException {
        if (!phone.matches("^\\d{1,11}$")){
            throw new WrongDataBaseException("Неверный формат телефонного номера");

        }
        return phone;
    }
    private static String validGender(String gender)throws WrongDataBaseException{
        if (!gender.matches("[fm]")){
            throw new WrongDataBaseException("Неверный формат пола");
        }
        return gender;
    }
}
