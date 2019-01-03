package com.lewis.tool;

import java.io.*;

/**
 * @author: 刘文鑫(liuwenxin03)
 * @date: 2018-12-29 11:03
 * @desc: 类描述
 */
public class StringTools {


    /**
     * @return String  格式化后的字符串
     * @deac 普通的文本字符串，转成Java标准的字符串
     */

    public static String commonStringFormat(String inputFilepath,MysqlFormat mysqlFormat) {

        File file = new File(inputFilepath);
        String outputStr = "";
        BufferedReader bufferedReader = null;


        try {
            bufferedReader = new BufferedReader(new FileReader(file));

            StringBuffer sb = new StringBuffer();
            String line = bufferedReader.readLine();
            while (line != null) { // 如果 line 为空说明读完了
                sb.append(line); // 将读到的内容添加到 buffer 中
                //buffer.append("\n"); // 添加换行符
                mysqlFormat.getSql(new String(line));
                line = bufferedReader.readLine(); // 读取下一行

            }

            outputStr = sb.toString();
            mysqlFormat.print();

        } catch (Exception e) {


        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        return outputStr;

    }


    public static void main(String[] args) {

        MysqlFormat mysqlFormat = new MysqlFormat();

        commonStringFormat("/users/lwx/data/demo的副本.txt",mysqlFormat);

        String str ="(?,?)";
       str =str.replaceFirst("\\?", "a").replaceFirst("\\?", "b");
        System.out.println(str);



        String  down_str=mysqlFormat.getDown_str();
        String up_str=mysqlFormat.getUp_str();
       String values[]= down_str.split(",");
       for(String value:values){
            if(value!=null) {
                value = value.replaceFirst(" ", "");
                value =value.split("\\(")[0];
                value="'"+value+"'";

            }
           value= value==null?null:value;
           up_str=up_str.replaceFirst("\\?",value);



       }
     // up_str= up_str.replaceAll("'null'", null);
        System.out.println(up_str);


    }
}

class MysqlFormat {

    final String GAP = "-----";

    String up_str = "";

    String down_str = "";

    boolean flag = false;

    public String getUp_str() {
        return up_str;
    }

    public void setUp_str(String up_str) {
        this.up_str = up_str;
    }

    public String getDown_str() {
        return down_str;
    }

    public void setDown_str(String down_str) {
        this.down_str = down_str;
    }

    boolean isGap(String str) {

        boolean b = GAP.equals(str);
        if (b) flag = true;

        return b;
    }


    void getSql(String str) {

        if (!isGap(str) && !flag) {

            up_str += str;
        } else {
            if(!isGap(str))
            down_str += str;

        }

    }


    String sqlFormat(String str) {

        getSql(str);


        return null;


    }


    void print() {

        System.out.println("up_str:" + up_str);
        System.out.println("down_str:" + down_str);

    }


}
