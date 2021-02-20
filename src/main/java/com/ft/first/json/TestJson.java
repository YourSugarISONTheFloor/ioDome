package com.ft.first.json;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ft.first.domain.Student;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class TestJson {
    @Test
    public void Testone() {
        Student stu1 = new Student();
        stu1.setName("张三");
        stu1.setAge(21);
        System.out.println("对象转json：");
        String stu1Json = JSONObject.toJSONString(stu1);
        System.out.println(stu1Json);
        Student stu1to = JSON.parseObject(stu1Json, Student.class);
        System.out.println("json 转对象：");
        System.out.println("从json中获取的对象：" + stu1to);
        System.out.println("从json转对象中获取name：" + stu1to.getName());
        System.out.println("从json转对象中获取age：" + stu1to.getAge());
    }

    @Test
    public void TestTwo() {
        Student stu1 = new Student();
        stu1.setName("张三");
        stu1.setAge(21);
        Student stu2 = new Student();
        stu2.setName("李四");
        stu2.setAge(22);
        List<Student> list = new ArrayList<Student>();
        list.add(stu1);
        list.add(stu2);
        //将Student对象集合转为json
        JSONObject listJson =new JSONObject();
        listJson.put("StudentArray",list);
        System.out.println("输出List<Student>集合的json数组字符串：" + listJson);
        Object[] a = new Object[5];
        String[] strings = {"10-24", "10-25", "10-26", "10-27", "10-28", "10-29", "10-30"};
        double[] ints1={0, 1.0, 529.0, 5435.0, 1888.0, 4304.0, 3487.0};
        double[] ints2={0, 1.0, 529.0, 5435.0, 1888.0, 4304.0, 3487.0};
        double[] ints3={0, 1.0, 529.0, 5435.0, 1888.0, 4304.0, 3487.0};
        double[] ints4={0, 1.0, 529.0, 5435.0, 1888.0, 4304.0, 3487.0};
        a[0] = strings;
        a[1]=ints1;
        a[2]=ints2;
        a[3]=ints3;
        a[4]=ints4;
        listJson.put("arrayJSON",a);
        JSONObject allJSON=new JSONObject();
        allJSON.put("data",listJson);
        System.out.println(allJSON.toJSONString());
    }

    @Test
    public void TestThree() {
        Student stu1 = new Student();
        stu1.setName("张三");
        stu1.setAge(21);
        Student stu2 = new Student();
        stu2.setName("李四");
        stu2.setAge(22);
        List<Student> list = new ArrayList<Student>();
        list.add(stu1);
        list.add(stu2);
        //将Student对象集合转为json
        String listJson = JSONObject.toJSONString(list);
        System.out.println("输出List<Student>集合的json数组字符串：" + listJson);
        //将json数组转为javabean
        List<Student> studentList = JSON.parseArray(listJson, Student.class);
        for (Student student : studentList) {
            System.out.println("获取json数组转为java对象的Student的name：" + student.getName());
        }
    }

    @Test
    public void TestFour() {
        Student stu1 = new Student();
        stu1.setName("张三");
        stu1.setAge(21);
        Student stu2 = new Student();
        stu2.setName("李四");
        stu2.setAge(22);
        List<Student> list = new ArrayList<Student>();
        list.add(stu1);
        list.add(stu2);
        //将Student对象集合转为json
        String listJson = JSONObject.toJSONString(list);
        System.out.println("输出List<Student>集合的json数组字符串：" + listJson);
        //将json数组转为javabean
        List<Student> studentList = JSON.parseArray(listJson, Student.class);
        System.out.println(studentList);
        for (Student student : studentList) {
            System.out.println("获取json数组转为java对象的Student的name：" + student.getName());
        }
        //创建一个JSONObject对象
        JSONObject jsona = new JSONObject();
        //给JSONObject对象添加对象
        jsona.put("number", "1");
        //再创建一个JSONObject对象
        JSONObject jsonb = new JSONObject();
        //给jsonb添加一个数组
        jsonb.put("listMap", list);
        //创建一个JSONObject对象
        JSONObject jsonAll = new JSONObject();
        //给jsonAll添加其他两个JSONObject
        jsonAll.put("jsona", jsona);
        jsonAll.put("jsonb", jsonb);
        //将jsonAll转为字符串
        String jsonAllStr = JSONObject.toJSONString(jsonAll);
        //输出转换为json格式的字符串
        System.out.println("最后的json格式jsonAll：" + jsonAllStr);
        String getJsona = JSON.parseObject(jsonAllStr).getString("jsona");
        System.out.println("获取jsonAll中jsona的对象：" + getJsona);
        String getJsonb = JSON.parseObject(jsonAllStr).getString("jsonb");
        System.out.println("获取jsonAll中jsonb的对象：" + getJsonb);
        String getlistMap = JSON.parseObject(getJsonb).getString("listMap");
        System.out.println("获取Jsonb中listMap的对象：" + getlistMap);
        String strjsona = JSON.parseObject(getJsona, String.class);
        System.out.println("只拿jsona信息：" + strjsona);
        String strjsonb = JSON.parseObject(getJsonb, String.class);
        System.out.println("只拿jsonb信息：" + strjsonb);
        List<Student> strListStudent = JSON.parseArray(getlistMap, Student.class);
        System.out.println("只拿listMap信息：" + strListStudent);
    }
}
