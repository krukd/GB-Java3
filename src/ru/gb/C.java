package ru.gb;

public class C implements Runnable{
    private final Tasks tasks;

    public C(Tasks c) {
        tasks = c;
    }

    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                while (!Thread.interrupted()) {
                    tasks.printingC();
                    System.out.println("C!");
                    tasks.waitForPrintingAB();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Done C");
    }
}
