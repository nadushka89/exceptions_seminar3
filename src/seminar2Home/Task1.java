package seminar2Home;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


//Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
// Ввод текста вместо числа не должно приводить к падению приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.
public class Task1 {
    public static void main(String[] args) {
        boolean working = true;
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        while (working){
            System.out.println("Введите дробное число: ");
            try{
                float number = Float.parseFloat(read.readLine());
                System.out.println(number);
                working=false;
            } catch (NumberFormatException | IOException e) {
                System.out.println("К сожалению, Вы ввели не число. ");
            }
        }
    }

}
