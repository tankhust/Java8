package chapter3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author tank
 * @create 2019/10/08 19:31
 */
public class Lamada表达式的演进 {
    public static void main(String[] args) {
        // 1. 传递代码
        ArrayList<Apple1> inventory = new ArrayList<>();
        inventory.addAll(Arrays.asList(new Apple1(80,"green"), new Apple1(155, "green"), new Apple1(120, "red")));
        inventory.sort(new AppleComparator());
        System.out.println(inventory);
        // 2. 使用匿名类
        inventory.sort(new Comparator<Apple1>() {
            @Override
            public int compare(Apple1 o1, Apple1 o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
//        System.out.println(inventory);
        // 3. 使用Lamada表达式
//        inventory.sort((Apple1 a1, Apple1 a2) -> (a1.getWeight().compareTo(a2.getWeight())));
//        System.out.println(inventory);
        // 4. 使用方法引用(Lamada表达式的升级版)
        inventory.sort(Comparator.comparing(Apple1::getWeight));
        System.out.println(inventory);
    }
}
class Apple1 implements Comparable<Apple1>{
    Integer weight;
    String color;

    public Apple1(Integer weight, String color) {
        this.weight = weight;
        this.color = color;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Apple1 o) {
        return this.getWeight()- o.getWeight();
    }

    @Override
    public String toString() {
        return "Apple1{" +
                "weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}

class AppleComparator implements Comparator<Apple1> {

    @Override
    public int compare(Apple1 a1, Apple1 a2) {
        return a1.getWeight().compareTo(a2.getWeight());
    }
}