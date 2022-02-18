package builder;

/**
 * 在下面的 ConstructorArg 类中，
 * 当 isRef 为 true 的时候，arg 表示 String 类型的 refBeanId，type 不需要设置；
 * 当 isRef 为 false 的时候，arg、type 都需要设置。
 * 请根据这个需求，完善 ConstructorArg 类。
 */
public class ConstructorArg {
    private boolean isRef;
    private Class type;
    private Object arg;


    /**
     * 1.构造函数私有，不允许其他人创建
     */
    private ConstructorArg(ConstructorArgBuilder constructorArgBuilder) {
        this.isRef=constructorArgBuilder.isRef;
        this.type=constructorArgBuilder.type;
        this.arg=constructorArgBuilder.arg;
    }

    @Override
    public String toString() {
        return "ConstructorArg{" +
                "isRef=" + isRef +
                ", type=" + type +
                ", arg=" + arg +
                '}';
    }


    public static ConstructorArgBuilder builder(){
        return new ConstructorArgBuilder();
    }

    /**
     * 构建对象生成器
     */
    public static class ConstructorArgBuilder {

        private boolean isRef;

        private Class type;

        private Object arg;


        private ConstructorArgBuilder() {

        }

        public ConstructorArg build(){
            if (this.isRef) {
                this.arg="引用beanId";
            }else{
                //false
                if(this.arg==null || this.type==null){
                    throw new RuntimeException("isRef 为 false 的时候，arg、type 都需要设置");
                }
            }
            return new ConstructorArg(this);
        }


        public ConstructorArgBuilder setType(Class type) {
            this.type = type;
            return this;
        }

        public ConstructorArgBuilder setArg(Object arg) {
            this.arg = arg;
            return this;
        }

        public ConstructorArgBuilder setIsRef(boolean isRef) {
            this.isRef = isRef;
            return this;
        }
    }
}