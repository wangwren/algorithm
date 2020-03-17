package basis.class01.after;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
            //记录当前i的位置
            int tmp = i;
            for (int j = i - 1; j < i && j >= 0; j--) {

                User user1 = users.get(j);
                User user = users.get(tmp);
                if (sort == 1){
                    if (user1.grade > user.grade){
                        //升序，交换位置
                        swap(users,tmp,j);
                        tmp = j;
                    }
                } else {
                    //降序
                    if (user1.grade < user.grade){
                        //升序，交换位置
                        swap(users,tmp,j);
                        tmp = j;
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

