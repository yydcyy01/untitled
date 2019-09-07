package test;

import java.util.Scanner;

/**
 * @author YYDCYY
 * @create 2019-09-07
 */
public class T3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        Boolean unflag; // 输出过, 记录下
        while (n -- > 0) {
            unflag = true;
            in.next();
            String str = in.nextLine();

            if (str.length() < 8 && unflag == true){
                System.out.println("NO");
                unflag = false;
                continue;
            }

            //数字开头, 不合法
            int len = str.charAt(0) - '0';
            if (len >= 0 && len <= 9 && unflag == true){
                System.out.println("NO");
                unflag = false;
                continue;
            }




            int[] ok = {0,0,0}; // 0数字  1 小字母  2 大字母
            //合法处理, 其他全部 continue, 继续执行输出 NO
            for (int i = 0; i < str.length(); i ++){
                Character temp = str.charAt(i);
                //合法情况
                if ( temp - '0' >= 0 && '9' -temp  <= 9) {
                   if (ok[0] == 0)                       ok[0] = 1;

                }else if (temp - 'a' >= 0 && 'z' - temp <= 26){
                    if (ok[1] == 0)                        ok[1] = 1;
                }else if (temp - 'A' >= 0 && 'Z' - temp <= 26){
                    if (ok[2] == 0)                      ok[2] = 1;
                }else
                    continue ;
                //全部合理, 输出

                if (i == str.length() - 1){
                    Boolean count = ok[0] + ok[1] + ok[2] >= 2;
                    if (count){
                        System.out.println("YES");
                        unflag = false;
                        continue;
                    }
                }
            }


            for (int i = 0; i < str.length(); i ++) {
                Character temp = str.charAt(i);
                //非法情况
                if ((!(temp - '0' >= 0 && '9' - temp <= 9) || (temp - 'a' >= 0 && 'z' - temp <= 26) || (temp - 'A' >= 0 && 'Z' - temp <= 26)) && unflag == true) {
                    System.out.println("NO");
                    unflag = false;
                    continue;
                }
            }

        }

    }
}

/**
 while( n ){
 int[] ok =[0,0,0];
 // 记录大写 , 小写, 数字.  0 表无, 1 表有.count = ok1 +ok2 +ok3 >= 2?  统计密码安全
 且统计过程中,若超出 大小写, 数字范围, 则直接 sout NO
 for (int i = 0; i < )
 }

 */
