package demo1;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author YYDCYY
 * @create 2019-09-04
 */

@FunctionalInterface //声明下, 函数是接口 ; 不声明也是接口
interface  MyInterface{
    void method();
}


public class Function {
    /**
     * 函数式接口[定义] : 接口内部只声明了一个抽象方法.   可以在接口上使用注解 @FunctionalInterface 判断是否是一个函数式接口
     * Java 内置 4 大函数式接口 :  Consumer<T> 消费型接口    T     void         包含 方法 : void accept(T t);   对 T 进行应用操作  返回 void
     *                           Supplier<T> 供给型接口    void  T             包含方法 : T get();
     *                           Function<T,R> 函数型接口  T     R            包含 : R apply (T t) ;    对 T 操作, 返回 R 类型结果,
     *                           Predicate<T> 断定型接口     T  boolean       包含方法  : boolean test(T t)

     还有其他 函数式接口,  BiFunction<> 等等等等, 需要百度一下.
     */

    @Test  // Consumer() 方法 , lambda 用法 Demo
    public void test1(){
        // 原来写法
        happyTime(5, new Consumer<Double>() {
            @Override
            public void accept(Double aDouble) {
                System.out.println("东方树叶-茉莉花茶, 价格为: "+aDouble);
            }
        });

        //lambda 表达式写法
        happyTime(5, money -> System.out.println("东方树叶-乌龙茶 口味, 价格为: " + money + " -- Lambda 表达式"));
    }

    public void happyTime(double money, Consumer<Double> con){
        con.accept(money);
    }



    @Test
    public void test2(){
        List<String> list = Arrays.asList("北京","天津","南京","东京","黄金","美金","西经","普京");

        List<String> filterStrs = filterString(list, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("京");
            }
        });

        System.out.println(filterStrs);

        List<String> filterStrs2 = filterString(list, s -> s.contains("京")); //s -> s.contains("京") 只要这部分时 Predicate 的 lmbda 简写
        System.out.println(filterStrs2 + "  -- lambda 表达式");
    }

    //根据给定字符串, 及判定规则 predicate , 过滤符合规则结果并返回
    public List<String> filterString(List<String> list, Predicate<String> pre){
        ArrayList<String> filterList = new ArrayList<>();

        for (String s: list){
            if (pre.test(s)){
                filterList.add(s);
            }
        }
        return filterList;
    }


}



