package singleton.firstImplementation;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BreakUsingReflection {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        FirstImplementation f = FirstImplementation.getInstance();
        FirstImplementation instanceUsingReflection;
        Constructor c = FirstImplementation.class.getDeclaredConstructor();
        c.setAccessible(true);
        instanceUsingReflection = (FirstImplementation) c.newInstance();

        System.out.println(f.hashCode() + " - " + instanceUsingReflection.hashCode());
    }
}
