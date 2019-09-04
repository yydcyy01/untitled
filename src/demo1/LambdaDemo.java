package demo1;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * @author YYDCYY
 * @create 2019-09-04
 */
public class LambdaDemo {
    /**
     * 格式说明 :  (o1,o2) ->Integer.compare(o1,o2);
     * 左边 : lambda 形参列表(接口中抽象的形参列表, 可写类型 : Integer o1, 可以省略)   右边 : lambda 体(重写的抽象方法体)
     *
     * 使用分六种情况
     * 1 无参,无返回值  eg : Runnable r1 = () ->{System.out.println("谁知道屏幕背后是不是乔碧萝呢");}
     *
     * 2 有参, 无返回值  eg : Consumer<String> con = (String str) -> { System.out.println(str);};
     *
     * 3 类型参数省略.   俗称"类型推断", 可由编译器推断出  类似  List<String> list = new ArrayList<>();  后一个<>就是类型推断
     *      eg : Consumer<String> con = (str) -> { System.out.println(str);};
     *
     * 4 lambda 若只需要一个参数时, 参数小括号可以省
     * Consumer<String> con = str -> { System.out.println(str);};
     *
     * 5 lambda 有两个及2 个上参数, 多条执行语句, 有返回值情况
     *
     * 6 lambda 若只有一条语句时, return 与大括号若有, 都可省
     *
     *总结 : 左边 : lambda 形参列表中参数类型可以省, 若只有一个参数, ()括号可省
     *      右边 : 应有{};包裹方法体内想表达的代码. 若只有一条执行语句(return 语句 或 无返回值,仅一条语句情况), 可省一对大括号和 return 关键字. eg test6();
     *
     * 1 lambda 表达式本质: 作为函数式接口的实例. 即要想用 lambda表达式, 一定依赖于函数式接口
     * 2 函数式接口 : 接口内部只声明了一个抽象方法.   可以在接口上使用注解 @FunctionalInterface 判断是否是一个函数式接口
     * 3 故 : 以前用匿名内部类表示的现在都可以用 lambda 表达式来写
     *
     *
     */
    @Test
    public void test1() {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("谁知道屏幕背后是不是乔碧萝呢");
            }
        };

        r1.run();

        System.out.println("************");
        Runnable r2 = () -> System.out.println("打赏么, 我萝莉音");
        r2.run();
    }
    @Test
    public void test2(){
        Comparator<Integer> com1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        System.out.println(com1.compare(100,880));

        System.out.println("*************lambda 表达式: *******");

        Comparator<Integer> com2 = (o1,o2) ->Integer.compare(o1,o2);
        System.out.println(com2.compare(100, 880)); // 返回 正 > ; 0 = ; -1 <
    }

    @Test
    public void test3(){

        Consumer<String> con = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        con.accept("生儿子后对各路恐龙如数家珍");


        System.out.println("*************lambda 表达式: *******");

        Consumer<String> con2 = (String s) ->{
        //Consumer<String> con2 = (s) ->{ //类型推断, 可省了;
            System.out.println(s);
        };
        con2.accept("生儿子后对各路恐龙如数家珍" + "    -- by Lambda");
    }

     @Test
    public void test4(){
         /**
          * 类型 4 测试
          */
        System.out.println("************* lambda 表达式: *******");

        Consumer<String> con2 = s ->{
        //Consumer<String> con2 = (s) ->{ //类型推断, 可省了;
            System.out.println(s);
        };
        con2.accept("生儿子后对各路恐龙如数家珍" + "    -- by Lambda");
    }

    @Test
    public void test5(){
        /**
         * 类型 5 测试 : 多参, 多语句, 有返回值
          */
        System.out.println("************* lambda 表达式: *******");

        Comparator <Integer> com = (Integer o1,Integer o2) ->{
            System.out.println(o1);
            System.out.println(o2);

            return o1.compareTo(o2);
        };
        System.out.println(com.compare(1000,3000));
    }

    @Test
    public void test6(){
        /**
         * 类型 6 测试 :lambda 若只有一条语句时, return 与大括号若有, 都可省
         */
        System.out.println("************* lambda 表达式: *******");
        Comparator <Integer> com = (o1,o2) ->o1.compareTo(o2);
        System.out.println("com.compare(1000,3000) :" + com.compare(1000,3000));

        System.out.println("*****************************************************");
        Consumer<String> con = s -> System.out.println(s);
        con.accept("生儿子后对各路恐龙如数家珍");
    }
}
