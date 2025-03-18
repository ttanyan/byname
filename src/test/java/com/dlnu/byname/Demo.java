package com.dlnu.byname;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;

/**
 * @author Tan Lianwang
 * @title: Demo
 * @date 2023/5/6 14:21
 */
public class Demo {

    public static int test(int n ){
        if(n==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        int first = 1;
        int second = 2;
        int result = 0;
        for (int i = 3; i < n; i++) {
            result = first+second;
            first = second;
            second = result;

        }
        return result;
    }


    public static void main(String[] args) {

//            String str = "{\"0\":\"zhangsan\",\"1\":\"lisi\",\"2\":\"wangwu\",\"3\":\"maliu\"}";
//            //第一种方式
//            Map maps = (Map) JSON.parse(str);
//            System.out.println("这个是用JSON类来解析JSON字符串!!!");
//            for (Object map : maps.entrySet()){
//                System.out.println(((Map.Entry)map).getKey()+"     " + ((Map.Entry)map).getValue());
//            }
//
//        Map<String,String> map1 = (Map<String, String>) JSON.parse(str);
//        System.out.println(map1);
//        //第二种方式
//            Map<String, Object> mapTypes = JSON.parseObject(str);
//            System.out.println("这个是用JSON类的parseObject来解析JSON字符串!!!");
//            for (Object obj : mapTypes.keySet()){
//                System.out.println("key为："+obj+"值为："+mapTypes.get(obj));
//            }
//            //第三种方式
//            Map mapType = JSON.parseObject(str,Map.class);
//            System.out.println("这个是用JSON类,指定解析类型，来解析JSON字符串!!!");
//            for (Object obj : mapType.keySet()){
//                System.out.println("key为："+obj+"值为："+mapType.get(obj));
//            }
//            //第四种方式
//            /**
//             * JSONObject是Map接口的一个实现类
//             */
//            Map json = (Map) JSONObject.parse(str);
//            System.out.println("这个是用JSONObject类的parse方法来解析JSON字符串!!!");
//            for (Object map : json.entrySet()){
//                System.out.println(((Map.Entry)map).getKey()+"  "+((Map.Entry)map).getValue());
//            }
//            //第五种方式
//            /**
//             * JSONObject是Map接口的一个实现类
//             */
//            JSONObject jsonObject = JSONObject.parseObject(str);
//            System.out.println("这个是用JSONObject的parseObject方法来解析JSON字符串!!!");
//            for (Object map : json.entrySet()){
//                System.out.println(((Map.Entry)map).getKey()+"  "+((Map.Entry)map).getValue());
//            }
//            //第六种方式
//            /**
//             * JSONObject是Map接口的一个实现类
//             */
//            Map mapObj = JSONObject.parseObject(str,Map.class);
//            System.out.println("这个是用JSONObject的parseObject方法并执行返回类型来解析JSON字符串!!!");
//            for (Object map: json.entrySet()){
//                System.out.println(((Map.Entry)map).getKey()+"  "+((Map.Entry)map).getValue());
//            }
//            String strArr = "{{\"0\":\"zhangsan\",\"1\":\"lisi\",\"2\":\"wangwu\",\"3\":\"maliu\"}," +
//                    "{\"00\":\"zhangsan\",\"11\":\"lisi\",\"22\":\"wangwu\",\"33\":\"maliu\"}}";
//            // JSONArray.parse()
//            System.out.println(json);

            //n 台阶  每次上一或二级台阶  多少上法。
        /**
         *  n=1  1
         *  n=2  2
         *  n=3 3
         *  f(n)= f(n-1) +f(n-2)
         */
        System.out.println(test(10));







    }
}


