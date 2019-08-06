package base;

/**
 * @Author qishiyu
 * @create 2019/8/6 21:03
 */
public class BaseTest {
    public static void main(String[] args) {
        int a = 1;
        Object b = a;
        if (b instanceof Integer) {
            System.out.println("tttt");
        }
    }
}
