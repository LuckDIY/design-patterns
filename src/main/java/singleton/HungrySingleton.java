package singleton;

/**
 * @program: design-patterns
 * @description: 饿汉单例
 * 优点:
 *    无锁，性能好
 *    提前创建对象不会导致第一次访问时创建时间慢问题
 * @author: WangChaoLei
 * @create: 2022-02-16 10:35
 **/
public class HungrySingleton {

    private final static HungrySingleton singleton = new HungrySingleton();


    /**
     * 1. 构造函数私有
     */
    private HungrySingleton(){

    }


    /**
     * 2. 提供对外获取实例的静态方法
     * 如果实懒汉的话，对象创建时还需要保证线程安全问题
     * @return
     */
    public static HungrySingleton getInstance(){
        return singleton;
    }



}
