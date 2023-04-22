package seminar1home;

//Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
//Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?

public class Task1 {
    public static void main(String[] args) {
        int [] arr = {1,5,6,8,9,10,50 };
        delNull(50,5);
        //delNull(50,0);
        valueByIndex (arr,3);
        //valueByIndex (arr,50);
        String[] array = {"первый элемент", "второй элемент", "третий элемент","4 элемент", null,"5 элемент"};
        exceptionStringArr(array);


    }
    //деление на ноль
    public static void delNull(double numFirst, double numSecond){
        if (numSecond==0) throw new ArithmeticException("На ноль делить нельзя.");
        double result = numFirst/numSecond;
        System.out.printf("Результат деления %.1f на %.1f равен %.1f. \n", numFirst,numSecond,result);
    }
    //нет элемента с индексом (выходит за рамки массива)
    public static void valueByIndex(int [] arr, int index){
        if (index>arr.length-1) throw new ArrayIndexOutOfBoundsException("Элемента с этим индексом не существует");
        System.out.printf("Элемент с индексом %d равен %d\n", index, arr [index]);
    }
    //исключение нулевого указателя в Java NullPointerException
    public static void exceptionStringArr(String [] array){
        for (String item: array){
            if (item==null) throw new NullPointerException("Элемент в массиве отсутствует");
            System.out.println(item);
        }

    }

}
