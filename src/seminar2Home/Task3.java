package seminar2Home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
//        Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
public class Task3 {
    public static void main(String[] args) {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите НЕпустую строку: ");
        try {
            String res = read.readLine();
            if (res.equals("")) throw new RuntimeException("Введена пустая строка");
            System.out.printf("Вы ввели: " + res);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
