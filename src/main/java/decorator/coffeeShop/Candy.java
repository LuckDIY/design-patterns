package decorator.coffeeShop;

import java.math.BigDecimal;

/**
 * @program: design-patterns
 * @description: 糖
 * @author: WangChaoLei
 * @create: 2022-02-26 17:14
 **/
public class Candy extends CondimentDecorator{

    private Coffee coffee;

    public Candy(Coffee coffee){
        this.coffee=coffee;
    }

    @Override
    public String getName() {
        return coffee.getName()+"+糖";
    }

    @Override
    public String getDesc() {
        return "甜度+10";
    }

    @Override
    public BigDecimal getCost() {
        return coffee.getCost().add(BigDecimal.ONE);
    }
}
