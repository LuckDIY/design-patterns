package decorator.coffeeShop;

import com.alibaba.fastjson.JSON;

/**
 * @program: design-patterns
 * @description:
 * @author: WangChaoLei
 * @create: 2022-02-26 16:38
 **/
public class CoffeeDemo {

    public static void main(String[] args) {
        BlackCoffee blackCoffee = new BlackCoffee();
        Whip whip = new Whip(blackCoffee);
        Whip doubleWhip = new Whip(whip);
        Candy candy = new Candy(doubleWhip);
        System.out.println(JSON.toJSONString(candy));
    }
}
