package interfaceStatistics;

/**
 * @program: design-patterns
 * @description: 测试类
 * @author: WangChaoLei
 * @create: 2022-02-10 20:07
 **/
public class Test {


    public static void main(String[] args) {
        UserController userController = new UserController();

        for (int i = 0; i < 100; i++) {
            userController.login("","");
        }
    }
}
