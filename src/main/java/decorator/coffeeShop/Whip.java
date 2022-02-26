package decorator.coffeeShop;

import java.math.BigDecimal;

/**
 * @program: design-patterns
 * @description: 奶泡调味料
 * @author: WangChaoLei
 * @create: 2022-02-26 16:32
 **/
public class Whip extends CondimentDecorator{

    @Override
    public String getDesc() {
        return "香味+10";
    }

    private Coffee coffee;

    /**
     * 只有咖啡抽象类的子类才能装饰奶泡
     * 可以是被修饰过的咖啡
     * @param coffee
     */
    public Whip(Coffee coffee){
        this.coffee=coffee;
    }


    @Override
    public BigDecimal getCost() {

        //被奶泡装饰后的价格
        //被传进来的咖啡子类的价格+奶泡价格
        return coffee.getCost().add(BigDecimal.valueOf(3));
    }


    @Override
    public String getName() {
        return coffee.getName()+"+奶泡";
    }

}
