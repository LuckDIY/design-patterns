package builder;

import java.util.HashMap;

/**
 * @program: design-patterns
 * @description:
 * @author: WangChaoLei
 * @create: 2022-02-18 16:41
 **/
public class Demo implements Cloneable{

    private int a;

    public static void main(String[] args) throws CloneNotSupportedException {
        //System.out.println(ConstructorArg.builder().setIsRef(false).setArg(1).setType(Integer.class).build());

        Demo demo = new Demo();
        demo.a=1;

        HashMap<Integer, Demo> map = new HashMap<>();
        map.put(1,demo);

        HashMap<Integer, Demo> cloneMap = (HashMap<Integer, Demo>) map.clone();

        cloneMap.get(1).a++;

        System.out.println("原始demo"+map);
        System.out.println("clone demo"+cloneMap);

    }

    @Override
    public String toString() {
        return "Demo{" +
                "a=" + a +
                '}';
    }
}
