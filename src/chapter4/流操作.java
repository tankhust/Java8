package chapter4;

import java.util.List;
import java.util.stream.Collectors;
import static chapter4.Dish.menu;
/**
 * @author tank
 * @create 2019/10/09 09:42
 */
public class 流操作 {
    public static void main(String[] args) {
        List<String> names = menu.stream()
                .filter(d -> {
                    System.out.println("filtering" + d.getName());
                    return d.getCalories() > 300;
                })
                .map(d -> {
                    System.out.println("mapping" + d.getName());
                    return d.getName();
                })// filter和map用到了循环合并
                .limit(3)// 短路
                .collect(Collectors.toList());
        System.out.println(names);
        menu.stream().forEach(System.out::println);
        /**
         * 输出:
         *
         * filteringpork
         * mappingpork
         * filteringbeef
         * mappingbeef
         * filteringchicken
         * mappingchicken
         * [pork, beef, chicken]
         */
    }

}
