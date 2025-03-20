package hw21;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> clazz = Class.forName("hw21.ArrayUtils");
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(MethodInfo.class)) {
                MethodInfo methodInfo = method.getAnnotation(MethodInfo.class);
                System.out.println("Method: " + methodInfo.name());
                System.out.println("Type: " + methodInfo.getType());
                System.out.println("Description: " + methodInfo.description());
            }
            if (method.isAnnotationPresent(Author.class)) {
                Author author = method.getAnnotation(Author.class);
                System.out.println("Author: " + author.author());
            }
            System.out.println();
        }
    }
}
