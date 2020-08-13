package ru.gb;


public class Main {

    public static void main(String[] args) throws Exception {

        Tasks tasks = new Tasks();

        Print print = new Print();
        new Thread(print::printingA).start();
        new Thread(print::printingB).start();
        new Thread(print::printingC).start();
    }
}
