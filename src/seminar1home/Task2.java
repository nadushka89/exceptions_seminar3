package seminar1home;

//Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
//и возвращающий новый массив, каждый элемент которого равен разности
//элементов двух входящих массивов в той же ячейке. Если длины массивов не равны,
//необходимо как-то оповестить пользователя.

import java.util.Arrays;
import java.util.Random;

public class Task2 {
    public static void main(String[] args) {
        int[] firstArray = getArr(5);
        int[] secondArray = getArr(20);
        int[] difArray = differenceArr(firstArray,secondArray);
        System.out.printf("Разность первого " + Arrays.toString(firstArray) + " и второго массива "+
                Arrays.toString(secondArray)+ " равна " +Arrays.toString(difArray) );
    }
    public static int[] getArr(int lenght){
        int [] arr= new int[lenght];
        Random rnd = new Random();
        for (int i = 0; i < lenght; i++) {
            arr[i] = rnd.nextInt(50);
        }
        return arr;
    }
    public static int[] differenceArr(int[] firstArr,int[] secondArr ){
        if (firstArr.length != secondArr.length) throw new RuntimeException("Длины массивов не равны");
        int [] resultArr = new int[firstArr.length];
        for (int i = 0; i < resultArr.length; i++) {
            resultArr[i]=firstArr[i]-secondArr[i];
        }
        return resultArr;
    }

}
