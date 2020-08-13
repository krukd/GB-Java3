package ru.geekbrains;
//<T> говорит о том что класс является generic(обобщенным)
//BoxGeneric это обобщенный класс

//можно также сделать класс BoxGeneric<T, S> те коробка которая содержит не только числа но и строки
//BoxGeneric<T, S, A, и тд>
public class BoxGeneric<T> {
    T obj;
    //static T obj так нельзя с генериками, нельзя создавать обобщенные исключения,нельзя создавать
    // массивы но можно получать извне
    //S objs;
    //T type
    //K key
    //V value
    //E element
    //N number

    public BoxGeneric(T obj) {
        this.obj = obj;
    }

    public T getObj() {
        return obj;
    }

    public void setObj(T obj) {
        this.obj = obj;
    }

    public String info() {
        return "Box ( " + obj.getClass().getSimpleName() + " value = " + obj + ")";
    }
}
