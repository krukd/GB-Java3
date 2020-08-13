package ru.geekbrains;
//пример использования интерфейсов с генериками
public class BoxComp implements Comparable<BoxComp> {

    int size;

    public BoxComp(int size) {
        this.size = size;
    }

    @Override
    public int compareTo(BoxComp o) {//метод основанный на генериках
        return this.size - o.size;
    }


   /* @Override
    public int compareTo(Object o) { метод без генериков
        if (!(o instanceof BoxComp)) {
            new RuntimeException("Incorrect type");
        }
        BoxComp another = (BoxComp)o;
        return this.size - another.size;
    }*/
}
