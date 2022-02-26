package decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @program: design-patterns
 * @description: 装饰者模式
 * @author: WangChaoLei
 * @create: 2022-02-21 11:06
 **/
public class Demo {


    public static void main(String[] args) {


        try {
            //查看 io 装饰者实现
            FileInputStream fileInputStream = new FileInputStream("/");

            //装饰上缓冲区
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            byte[] data = new byte[128];
            while (bufferedInputStream.read(data) != -1) {
                //...

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
