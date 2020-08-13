package ru.gb;

public class A implements Runnable{
    private final Tasks tasks;

    public A(Tasks t) {
        tasks = t;
    }

    public void run() {
        for (int i = 0; i < 5; i++){
            try {
                while (!Thread.interrupted()) {
                    tasks.printingA();
                    System.out.println("A!");
                    tasks.waitForPrintingBC();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done A");
    }
}
