package chapter5;

import java.util.stream.Stream;

/**
 * @author tank
 * @create 2019/10/09 15:41
 */
public class test1 {
    public static void main(String[] args) {
        Stream.iterate(0, n -> n + 2)
                .limit(10)// 不加limit会一直打印下去
                .forEach(System.out::println);
        Stream.iterate(new int[]{0, 1},
                t -> new int[]{t[1], t[0] + t[1]})
                .limit(20)
                .map(t -> t[0])
                .forEach(System.out::println);
     }
}
