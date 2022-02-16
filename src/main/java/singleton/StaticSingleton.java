package singleton;

/**
 * @program: design-patterns
 * @description: 静态内部类方式实现单例
 * 静态内部类 不会随外部创建而创建，只会在被调用时创建
 * 问题: 如果同时调用内部类，内部类的创建流程是什么样，为什么不会出现并发问题
 * 多线程环境中被正确地加锁、同步，如果多个线程同时去初始化一个类，那么只会有一个线程去执行这个类的<clinit>()方法，其他线程都需要阻塞等待，直到活动线程执行<clinit>()方法完毕
 * instance 的唯一性、创建过程的线程安全性，都由 JVM 来保证。所以，这种实现方法既保证了线程安全，又能做到延迟加载。
 * @author: WangChaoLei
 * @create: 2022-02-16 11:50
 **/
public class StaticSingleton {

    private StaticSingleton(){}

    private static class SingletonHolder{
        private final static StaticSingleton staticSingleton = new StaticSingleton();
    }

    public static StaticSingleton getInstance(){
        return SingletonHolder.staticSingleton;
    }

}
