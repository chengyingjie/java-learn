package com.jesse.learn.polymorphic;

/**
 * 重载、重写demo
 */
public class Demo {

    class Base {
        Base() {
            g();
        }

        private void g() {
            System.out.println("base g");
        }

        public void f(int num) {
            System.out.println("base f" + num);
        }
    }

    class SubBase extends Base {
        // 1.重写前提条件是：子类方法可见性要大于等于父类
        // 2.子类的g如果返参定义为非void，会报错，因为无法构成重写条件，必须和父类返参相同
        public void g() {
            System.out.println("SubBase g");
        }

        // 和父类的方法f产生的是重载关系
        public void f(long num) {
            System.out.println("SubBase f" + num);
        }
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.initDemo();
    }

    private void initDemo() {
        Base base = new SubBase();
        base.f(5);
//        base.f(5L);    多态具有编译时类型和运行时类型，此处在编译期会报错，因父类无f(long num)方法
    }
}
