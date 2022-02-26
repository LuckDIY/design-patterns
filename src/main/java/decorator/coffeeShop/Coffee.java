package decorator.coffeeShop;

import java.math.BigDecimal;

/**
 * @program: design-patterns
 * @description: 咖啡抽象类
 * @author: WangChaoLei
 * @create: 2022-02-26 16:22
 **/
public abstract class Coffee {


    /**
     * 咖啡名字
     * @return
     */
    public abstract String getName();


    /**
     * 咖啡价格
     * @return
     */
    public abstract BigDecimal getCost();





}
