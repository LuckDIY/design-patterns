package singleton;

/**
 * @program: design-patterns
 * @description: 懒汉双重检索
 *   有锁，影响性能
 * @author: WangChaoLei
 * @create: 2022-02-16 11:39
 **/
public class LazySingleton {

    private volatile static LazySingleton lazySingleton = null;


    /**
     * 1. 构造方法私有
     */
    private LazySingleton(){}


    /**
     * 2. 提供获取实例的静态方法
     * 懒加载，需要加锁
     * 双重检索
     *    外层if作用，保证性能，不满足无锁直接返回
     *    内层if作用, 保证安全，在有锁情况下判断以及创建对象
     * @return
     */
    public static LazySingleton getInstance(){
        if(lazySingleton==null){
            synchronized (LazySingleton.class){
                if(lazySingleton==null){
                    lazySingleton=new LazySingleton();
                }
            }
        }
        return lazySingleton;
    }

}
