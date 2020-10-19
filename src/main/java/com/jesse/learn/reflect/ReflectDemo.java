package com.jesse.learn.reflect;


import java.lang.reflect.*;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * 反射知识点学习
 */
public class ReflectDemo {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException
    {
        //获取类名称
        getReflectClassName();

        //获取类方法
        getReflectClassMethodName();

        //获取类域名
        getReflectClassFieldName();

        //获取构造方法
        getReflectClassConstructFunction();
    }

    @SuppressWarnings("unchecked")
    private static void getReflectClassName() throws InstantiationException, IllegalAccessException
    {
        Class<ReflectDemo> class1 = ReflectDemo.class;
        System.out.println("class1: " + class1);

        try {
            Class<ReflectDemo> class2 = (Class<ReflectDemo>) Class.forName("com.jesse.learn.reflect.ReflectDemo");
            System.out.println("class2: " + class2);
        }
        catch (ClassNotFoundException e) {
            System.out.println("ClassNotFoundException");
        }

        ReflectDemo reflectDemo = ReflectDemo.class.newInstance();
        Class<ReflectDemo> class3 = (Class<ReflectDemo>) reflectDemo.getClass();
        System.out.println("class3: " + class3);
    }

    private static void getReflectClassMethodName() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InvocationTargetException {
        Class<Student> class1 = Student.class;

        //reflecting all the declared methods of the class or interface represented by this Class object,
        //including public, protected, default (package) access, and private methods,
        //but excluding inherited methods
        for (Method method : class1.getDeclaredMethods()) {
            System.out.println("getDeclaredMethods: " + method.getName());
        }

        //reflecting all the public methods of the class or interface represented by this Class object,
        //including those declared by the class or interface
        //and those inherited from superclasses and superinterfaces
        for (Method method : class1.getMethods()) {
            System.out.println("getMethods: " + method.getName());
        }

        Student stu = class1.newInstance();
        Method method1 = class1.getMethod("setName", String.class);
        method1.invoke(stu, "liuliu");

        System.out.println(stu.getName());

        Method method2 = class1.getMethod("getName");
        System.out.println(method2.invoke(stu));

        Method method3 = class1.getMethod("getAge");
        System.out.println(method3.invoke(stu));
    }

    private static void getReflectClassFieldName() throws NoSuchFieldException, SecurityException, InstantiationException, IllegalAccessException
    {
        Class<Student> class1 = Student.class;

        //all the accessible public fields of the class or interface represented by this Class object.
        for (Field field : class1.getFields()) {
            System.out.println("Fields: " + field.getName());
        }

        //reflecting all the fields declared by the class or interface represented by this Class object.
        //This includes public, protected, default (package) access, and private fields, but excludes inherited fields
        for (Field field : class1.getDeclaredFields()) {
            System.out.println("DeclaredFields: " + field.getName());
        }

        Field field1 = class1.getDeclaredField("name");
        Student stu = class1.newInstance();
        stu.setName("chengyingjie");

        //私有变量必须设置访问权限，否则无法直接访问 方式一
        if (!Modifier.isPublic(field1.getModifiers())) {
            AccessController.doPrivileged(new PrivilegedAction<Void>() {
                public Void run() {
                    field1.setAccessible(true);
                    return null;
                }
            });
        }

        //私有变量必须设置访问权限，否则无法直接访问 方式二
//        field1.setAccessible(true);

        System.out.println("name: " + field1.get(stu));
    }

    private static void getReflectClassConstructFunction() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        Class<Student> class1 = Student.class;
        for (Constructor<?> constructor : class1.getConstructors()) {
            System.out.println("Constructors: " + constructor.getName());
        }

        for (Constructor<?> constructor : class1.getDeclaredConstructors()) {
            System.out.println("DeclaredConstructors: " + constructor.getName());
        }

        //注意：如果声明了带整型参数的构造函数，其参数必须声明为Integer，否则，因int不是一个包装类型，反射构建时会报错
        Constructor<Student> constructor = class1.getConstructor(String.class, Integer.class);
        System.out.println("Constructor: " + constructor.getName());

        Student stu2 = constructor.newInstance("chengwang", 20);
        System.out.println("constructorInstance: " + stu2.getName() + ":" + stu2.getAge());
    }
}
