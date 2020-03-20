package basis.class01.after;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 查找和排序
 *
 * 题目：输入任意（用户，成绩）序列，可以获得成绩从高到低或从低到高的排列,相同成绩
 * 都按先录入排列在前的规则处理。
 *
 * 示例：
 * jack      70
 * peter     96
 * Tom       70
 * smith     67
 *
 * 从高到低  成绩
 * peter     96
 * jack      70
 * Tom       70
 * smith     67
 *
 * 从低到高
 *
 * smith     67
 *
 * jack      70
 * Tom      70
 * peter     96
 *
 *
 * 输入描述:
 * 输入多行，先输入要排序的人的个数，然后输入排序方法0（降序）或者1（升序）再分别输入他们的名字和成绩，以一个空格隔开
 *
 *
 *
 * 输出描述:
 * 按照指定方式输出名字和成绩，名字和成绩之间以一个空格隔开
 *
 * 示例1
 *
 * 输入
 *
 * 3
 * 0
 * fang 90
 * yang 50
 * ning 70
 *
 * 输出
 *
 * fang 90
 * ning 70
 * yang 50
 */
public class Main01 {

    public class User{
        public String name;
        public int grade;
    }

    public static void main(String[] args) {
        Main01 main01 = new Main01();

        Scanner sc = new Scanner(System.in);
        //人数
        Integer num = 0;

        //排序方式，0：降序；1：升序
        Integer sort = 0;



        List<User> users = new ArrayList<>();

        //牛客上的OJ是多个case，需要持续输入
        while(sc.hasNext()){

            num = sc.nextInt();
            //System.out.println("num:" + num);
            sort = sc.nextInt();
            //System.out.println("sort:" + num);

            main01.read(sc,num,users);

            //System.out.println("users.size:" + users.size());

            //排序
            main01.selectSort(users,sort);

            //输出
            main01.out(users,num);
        }
    }

    /**
     * 输入
     */
    public void read(Scanner sc,Integer num,List<User> users){
        //多组case只能用num来控制了
        for (int i = 0; i < num; i++) {
            User user = new User();
            user.name = sc.next();
            user.grade = sc.nextInt();

            //System.out.println("输入的姓名：" + user.name + " 成绩：" + user.grade);

            users.add(user);
        }
    }

    /**
     * 输出
     */
    public void out(List<User> users,Integer num){

        //多组case只能用num来控制了
        for (int i = 0; i < num; i++) {
            System.out.println(users.get(i).name + " " + users.get(i).grade);
        }

        //输出后清空集合数据
        users.clear();
    }

    /**
     * 排序,用的插入排序
     */
    public void selectSort(List<User> users,Integer sort){
        for (int i = 1; i < users.size(); i++) {
            for (int j = i - 1; j >= 0; j--) {

                User user1 = users.get(j);
                User user = users.get(j + 1);
                if (sort == 1){
                    if (user1.grade > user.grade){
                        //升序，交换位置
                        swap(users,j + 1,j);
                    }
                } else {
                    //降序
                    if (user1.grade < user.grade){
                        //升序，交换位置
                        swap(users,j + 1,j);
                    }
                }

            }
        }
    }

    /**
     * 交换
     */
    public void swap(List<User> users,Integer i,Integer j){

        User temp = new User();
        temp = users.get(i);
        users.set(i,users.get(j));
        users.set(j,temp);
    }
}

