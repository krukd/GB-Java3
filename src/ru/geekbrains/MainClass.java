package ru.geekbrains;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

    public static void main(String[] args) {
        //ArrayList rawList = new ArrayList(); пример использования листа в который можно положить
        //обьекты совршенно разных типов


        ArrayList<String> listStr = new ArrayList<>();
        listStr.add("Java");
        String value = getFirstElementFromList(listStr);
        System.out.println(getFirstElementFromList(listStr));

    }

    public static <T> T getFirstElementFromList(List<T> list) {//мы говорим что будем использовать
        // генерики в методе
        if (list == null || list.isEmpty()) {
            throw new RuntimeException("Error");
        }
        return list.get(0);
    }


    public static <T> T getLastElementFromList(List<T> list) {
        return list.get(list.size()-1);
    }

    private static void exampleBoxWithNumbers() {
        BoxWithNumbers<Number> boxN = new BoxWithNumbers<>(1, 2f, 3d);
        BoxWithNumbers<Integer> boxI = new BoxWithNumbers<>(1, 2, 3);

        ArrayList<Integer> arrI = new ArrayList<>();
        ArrayList<Number> arrN = new ArrayList<>();


        System.out.println(boxN.avg());
        System.out.println(boxI.avg());
        System.out.println(boxI.isSame(boxI));
    }

    private static void exampleBoxGeneric() {
        BoxGeneric<Integer> box1 = new BoxGeneric<>(10);
        BoxGeneric<Integer> box2 = new BoxGeneric<>(30);


        BoxGeneric<String> boxStr = new BoxGeneric<>("Java");


        System.out.println(box1.info());
        System.out.println(box2.info());
        System.out.println(boxStr.info());


        int sum = box1.getObj() + box2.getObj();
        System.out.println("sum = " + sum);
    }


    private static void exampleSimple() {
        Box box1 = new Box(10);
        Box box2 = new Box((30));

        box1.setObj("Java");

        System.out.println(box1.info());
        System.out.println(box2.info());
        if (box1.getObj() instanceof Integer && box2.getObj() instanceof Integer) {
            int sum = (Integer) box1.getObj() + (Integer) box2.getObj();
            System.out.println("sum = " + sum);
        } else {
            System.out.println("error");
        }

    }
}
