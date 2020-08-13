package ru.geekbrains;

public class Box {
    Object obj;

    public Box(Object obj) {
        this.obj = obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Object getObj() {
        return obj;
    }

    public String info() {
        return "Box ( " + obj.getClass().getSimpleName() + " value = " + obj + ")";
    }
}
