package singleton;

/**
 * 枚举实现单例
 * 枚举天生就是多例的，只需要枚举有一个就是单例
 * 而且枚举支持变量和方法
 */
public enum EnumSingleton {

    /**
     * 单例
     */
    instance;

    private int a=1;

    private EnumSingleton(){

    }

    public static EnumSingleton getInstance(){
        return instance;
    }

    public int sum(){
        return a+1;
    }
}
