package decorator.coffeeShop;

import java.math.BigDecimal;

/**
 * @program: design-patterns
 * @description: 黑咖啡实现类
 * @author: WangChaoLei
 * @create: 2022-02-26 16:26
 **/
public class BlackCoffee extends Coffee{


    @Override
    public String getName() {
        return "黑咖啡";
    }

    @Override
    public BigDecimal getCost() {
        return BigDecimal.valueOf(5);
    }

}
