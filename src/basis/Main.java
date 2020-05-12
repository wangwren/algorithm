package basis;

/**
 * 阿里巴巴  Java七天学习训练营 day3 测试题
 *
 * https://developer.aliyun.com/article/755087
 */
public class Main {

    public static void main(String[] args) {

        //1. float a = 0.125f; double b = 0.125d; System.out.println((a - b) == 0.0); 代码的输出结果是什么？
        float a = 0.125f;
        double b = 0.125d;
        System.out.println((a - b) == 0.0);

        //2. double c = 0.8; double d = 0.7; double e = 0.6; 那么c-d与d-e是否相等？
        double c = 0.8d;
        double d = 0.7d;
        double e = 0.6d;

        System.out.println(c - d);
        System.out.println(d - e);

        //3. System.out.println(1.0 / 0); 的结果是什么？
        System.out.println(1.0 / 0);

        //4. System.out.println(0.0 / 0.0); 的结果是什么？
        System.out.println(0.0 / 0.0);

        //5. >>和>>>的区别是？
        /*
            A. 任何整数没有区别
            B. 负整数一定没有区别
            C. 浮点数可以>>运算，但是不可以>>>运算
            D. 正整数一定没有区别
         */
        System.out.println(4 >> 1);
        System.out.println(4 >>> 1);

        System.out.println();

        System.out.println(-4 >> 1);
        System.out.println(-4 >>> 1);

        System.out.println();

        //6. 某个类有两个重载方法：void f(String s) 和 void f(Integer i)，那么f(null)的会调用哪个方法？
        //f(null);  编译出错

        //7. 某个类有两个重载方法：void g(double d) 和 void g(Integer i)，那么g(1)的会调用哪个方法？
        g(1); //调用后者

        //8. String a = null; switch(a)匹配case中的哪一项？

        String str = null;
        switch (str) { //抛出空异常
            case "" :
                System.out.println("");
                break;
            case "null" :
                System.out.println("null");
        }

        //9. <String, T, Alibaba> String get(String string, T t) { return string; } 此方法：编译正确

        //10.

    }


    public static void f(String s) {
        System.out.println(s);
    }

    public static void f(Integer i) {
        System.out.println(i);
    }

    public static void g(Double d) {
        System.out.println(d);
    }

    public static void g(Integer i) {
        System.out.println(i);
    }


    <String,T,Alibaba>String get(String string,T t) {
        return string;
    }
}
