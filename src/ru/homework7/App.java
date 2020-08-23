package ru.homework7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;

import static java.util.Comparator.comparingInt;


public class App {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        start(Test1.class);
        System.out.println("\n");
        start(Test2.class);
        System.out.println("\n");
    }

    public static void start(Class c) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        Method[] methods = c.getDeclaredMethods();
        int bsCount = 0, asCount = 0;
        List<Method> tests = new ArrayList<>();

        for (Method o : methods) {
            String type = o.getDeclaredAnnotations()[0].annotationType().getSimpleName();
            if (type.equals("BeforeSuite")) {
                bsCount++;
                if (bsCount > 1) throw new RuntimeException("You can use only 1 before annotation.");
            } else if (type.equals("AfterSuite")) {
                asCount++;
                if (asCount > 1) throw new RuntimeException("You can use only 1 after annotation.");
            } else if (type.equals("Test")) {
                tests.add(o);
            }
        }


        tests.sort(comparingInt(new ToIntFunction<Method>() {
            @Override
            public int applyAsInt(Method o2) {
                return o2.getAnnotation(Test.class).priority();
            }
        }));

        for (Method o : methods) {
            String type = o.getDeclaredAnnotations()[0].annotationType().getSimpleName();
            if (type.equals("BeforeSuite")) {
                tests.add(0, o);
            }
            if (type.equals("AfterSuite")) {
                tests.add(o);
            }
        }

        for (Method i : tests) {
            try {
                System.out.print("(" + i.getDeclaredAnnotation(Test.class).priority() + ") ");
            } catch (NullPointerException e) {
            }
            i.invoke(c.newInstance(), null);
        }
    }
}
