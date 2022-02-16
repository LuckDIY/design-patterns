package singleton;

/**
 * @program: design-patterns
 * @description: 单例是基于进程的，就是在同一个进程内是单例，如果多个进程的话，内存都是虚拟内存，必然就是一个进程一个单例
 *
 * @author: WangChaoLei
 * @create: 2022-02-16 15:18
 **/
public class Demo {

    public static void main(String[] args) {
        System.out.println(EnumSingleton.instance.sum());
        System.out.println(EnumSingleton.getInstance().sum());
    }
}
