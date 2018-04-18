package com.zp.txt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Author:zp
 * Date:2018/3/23 0023
 * Description:
 */
public class Test {

    public static void main(String[] args) {
        File file = new File("d://asdfa.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
            String s = null;
            int count = 0;
            while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                int index = s.indexOf("totalAmount");
                if (index < 0) {
                    continue;
                }
                s = s.substring(index);
                s = s.replace("totalAmount = ", "");
                int i = s.indexOf(",");
                s = s.substring(0, i);
                double a = Double.valueOf(s);
                if (a > 10) {
                    count++;
                }
                System.out.println(s);
            }
            System.out.println("count = " + count);
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
