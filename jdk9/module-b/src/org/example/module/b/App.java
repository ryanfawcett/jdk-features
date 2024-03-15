package org.example.module.b;

import org.example.module.a.Animal;
// import org.example.module.person.Person;

@SuppressWarnings("all")
public class App {
    public static void main(String[] args) throws Exception {
        Animal animal = new Animal();
        animal.eat();

        // Person person = new Person();

        // 该类并没有被导出 不能使用反射的方式进行实例化
        // 如果在module-info.java文件中使用
        // opens org.example.module.person 那么该类可以通过反射的方式进行实力化

        Class<?> clazz = Class.forName("org.example.module.person.Person");
        Object obj = clazz.newInstance();
        System.out.println(obj.hashCode());
    }
}
