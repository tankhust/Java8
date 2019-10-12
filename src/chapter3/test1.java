package chapter3;

import java.util.function.Supplier;

/**
 * @author tank
 * @create 2019/10/08 17:18
 */
public class test1 {
    public static void main(String[] args) {
        /**
         * 1
         */
        Runnable r = () -> {
            System.out.println("hello tank");
        };
        /**
         * 2
         */
        int portNumber = 1337;
        Runnable r1 = () ->{
            System.out.println(portNumber);
        };
//        portNumber = 1;
        /**
         * 3. 方法引用Apple::new调用Apple类的默认构造函数
         */
        Supplier<Apple> c1 = Apple::new;
        Apple i1 = c1.get();
    }
}
class Apple{

}
