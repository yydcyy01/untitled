package demo2;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.*;

/**
 * @author YYDCYY
 * @create 2019-09-04
 * 方法引用 Demo
 */
public class MethodReference {
        /**
         *方法引用课看作是 Lambda 表达式的深层次表达, 即是函数式接口的一个实例, 通过方法名来指向一个方法, 可认为是 Lambda 表达式的一个语法糖.
         *  格式 : 操作符 '::' 分割 类与方法
         *  对象::实例方法名
         *  类::静态/实例 方法名 (非静态即实例方法)
         *
         *
         */


        /*
        情况一: 对象::实例方法名
        Consumer 中的void accept(T t)
        PrintStream 中的 void println(T t)
         */
        @Test
        public void test1(){
            Consumer<String> con1 = str -> System.out.println(str);
            con1.accept("东北");

            System.out.println("********************");
            PrintStream ps = System.out;
            Consumer<String> con2 = ps::println;   // 对象::实例方法名
            con2.accept("DongBei");
        }

        @Test
        public void test2(){
            final Employee emp = new Employee();
            Supplier<String> sup = () -> emp.getName();  //代替匿名内部类
            String str = sup.get();
            System.out.println(str);

            Supplier<Integer> sup2 = emp::getAge;
            Integer num = sup2.get();
            System.out.println(num);

        }

        /*
        情况二  类::静态方法名
        Comparator 中的 int compare(T t1, T t2)
        Integer 中的 int compare(T t1, T t2)
        脑子要记住方法体长什么样
         */
        @Test
        public void test3(){
            Comparator<Integer> com = (t1, t2) -> Integer.compare(t1, t2);
            System.out.println(com.compare(12,  13));

            System.out.println("******************");

            Comparator<Integer> com1 = Integer::compare; //不是靠逻辑推 , 熟悉熟悉就好
            System.out.println(com1.compare(12,13));
        }

    /**
     *               Function 中的 R apply(T t)
     *             Math 中的 Long round(Double d)
     */
    public void test4(){
             Function<Double, Long> func = new Function<Double, Long>(){

                 @Override
                 public Long apply(Double aDouble) {
                     return Math.round(aDouble);
                 }
             };

             System.out.println("******************");
             Function<Double,Long> func1 = d -> Math.round(d);  // 对上面形式 简写
             System.out.println(func1.apply(15.67)); //四舍五入

             System.out.println("********************");
             Function<Double, Long> func2 = Math:: round; // Function 和 Math.round 格式类似, 传 T, 返 R ,故直接调用
             System.out.println(func2.apply(15.67));


             BiPredicate<String, String> bp = (x,y) -> x.equals(y);
             BiPredicate<String, String> bp2 = String::equals;
         }
        /*
            情况 三  类::实例方法名
            Comparator 中的 int comapre(T t1 , T t2)
         */
         public void test5(){

            Supplier<Employee> sup = () -> new Employee();

            //构造器引用方式
            Supplier<Employee> sup2=Employee::new;//使用无参构造器
            Employee emp=sup2.get();
            System.out.println(emp);

            Function<Integer,Employee> fun2=(x)->new Employee(x);
            Employee emp2=fun2.apply(101);
            System.out.println(emp2);

            BiFunction<String,Integer,Employee> bf=Employee::new;
         }

        //数组引用
        @Test
        public void test6(){
            Function<Integer,String[]> fun=(x)->new String[x];
            String[] strs=fun.apply(10);
            System.out.println(strs.length);

            Function<Integer,String[]> fun2=String[]::new;
            String[] str2=fun2.apply(20);
            System.out.println(str2.length);
        }

}
