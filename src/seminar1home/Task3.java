package seminar1home;

import java.util.Arrays;
import java.util.Random;

//Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
//каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
//Если длины массивов не равны, необходимо как-то оповестить пользователя.
//Важно: При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.
public class Task3 {
    public static void main(String[] args) {
        int[] firstArray = getArr(5);
        int[] secondArray = getArr(5);
        int[] divisionArray = divisionArr(null,secondArray);
        System.out.printf("Деление первого " + Arrays.toString(firstArray) + " на второй массив "+
                Arrays.toString(secondArray)+ " равен " +Arrays.toString(divisionArray) );

    }
    public static int[] getArr(int lenght){
        int [] arr= new int[lenght];
        Random rnd = new Random();
        for (int i = 0; i < lenght; i++) {
            arr[i] = rnd.nextInt(25);
        }
        return arr;
    }
    public static int[] divisionArr(int[] firstArr, int[] secondArr ){
        if (firstArr==null || secondArr==null) throw new RuntimeException("К сожалению массив(ы) пуст(ы)");
        if (firstArr.length != secondArr.length) throw new RuntimeException("Длины массивов не равны");
        int [] resultArr = new int[firstArr.length];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i]=firstArr[i]/secondArr[i];
        }
        return resultArr;
    }
}
