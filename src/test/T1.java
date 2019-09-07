package test;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author YYDCYY
 * @create 2019-09-07
 */
public class T1 {
        public static void main(String[] args) {
            Scanner in = new Scanner(System.in);
                String a = in.nextLine();
                String b = in.nextLine();

                if (a.length() == 0 || b.length() == 0) {
                    System.out.println(b);
                    return ;
                }
            HashMap<Character, Integer> hashMap = new HashMap<>();
            for (int i = 0; i < b.length(); i ++){
                Character temp = b.charAt(i);
                hashMap.put(temp,hashMap.getOrDefault(temp, 0) + 1);
            }
            for (int i = 0; i < a.length();i ++ ){
                Character temp =  a.charAt(i);
                hashMap.put(temp, hashMap.get(temp) -1);
            }

            for (int i = 0; i < b.length(); i ++){
                Character temp = b.charAt(i);
                if (hashMap.get(temp) > 0){
                    System.out.print(temp);
                    return;
                }
            }
        }

}
