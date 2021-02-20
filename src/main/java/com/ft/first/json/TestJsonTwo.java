package com.ft.first.json;


import com.alibaba.fastjson.JSONObject;
import com.ft.first.domain.Student;
import org.junit.Test;


public class TestJsonTwo {
    @Test
    public void TestOne() {
//        System.out.println( "json字符串转java代码" );
//        String jsonstr="{\"name\":\"张三\",\"age\":\"20\"}";
//        JSONObject jsonObject=new JSONObject(jsonstr);
//        Student stu1 = new Student();
//        stu1.setName("张三");
//        stu1.setAge("21");
//        Student stu2 = new Student();
//        stu2.setName("李四");
//        stu2.setAge("22");
//        List<Student> list = new ArrayList<Student>();
//        list.add(stu1);
//        list.add(stu2);
//
//        JSONObject jsonb = new JSONObject();
//        jsonb.put("Student", list);
//        JSONObject jsona = new JSONObject();
//        jsona.put("xml", jsonb);
//
//        String xml = XML.toString(jsona);
//        System.out.println(xml);
//    }
//
//    @Test
//    public void TestJsonToXML() {
//        String result = "<applications>" + "<versions__delta>1</versions__delta>" + "<apps__hashcode></apps__hashcode>" + "</applications>";
//        //将xml转为json
//        JSONObject xmlJSONObj = XML.toJSONObject(result);
//        //输出json
//        System.out.println("XML转为json：" + xmlJSONObj);
//        //设置缩进
//        String jsonPrettyPrintString = xmlJSONObj.toString(4);
//        //输出格式化后的json
//        System.out.println("设置缩进后的json：" + jsonPrettyPrintString);
//        Student stu1 = new Student();
//        stu1.setName("张三");
//        stu1.setAge("21");
//        Student stu2 = new Student();
//        stu2.setName("李四");
//        stu2.setAge("22");
//        List<Student> list = new ArrayList<Student>();
//        list.add(stu1);
//        list.add(stu2);
//        //将Student对象集合转为json
//        String listJson = JSONObject.valueToString(list);
//        System.out.println("输出List<Student>集合的json数组字符串：" + listJson);
//
//        //创建一个JSONObject对象
//        JSONObject jsona = new JSONObject();
//        //给JSONObject对象添加对象
//        jsona.put("number", "1");
//        //再创建一个JSONObject对象
//        JSONObject jsonb = new JSONObject();
//        //给jsonb添加一个数组
//        jsonb.put("listMap", list);
//        //创建一个JSONObject对象
//        JSONObject jsonAll = new JSONObject();
//        //给jsonAll添加其他两个JSONObject
//        jsonAll.put("jsona", jsona);
//        jsonAll.put("jsonb", jsonb);
//        System.out.println(jsonAll);
//        //将json转为XML
//        String xml = XML.toString(jsonAll);
//        System.out.println("输出json转为XML后的数据：" + xml);
    }

    @Test
    public void javabeantojson() {
        Student stu1 = new Student();
        stu1.setName("张三");
        stu1.setAge(21);
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(stu1);
        String stu1Json = JSONObject.toJSONString(stu1);
        System.out.println(jsonObject);
    }

    @Test
    public void test() {
        String result = "<applications>" + "<versions_delta>1</versions_delta>" + "<apps_hashcode>你好</apps_hashcode>" + "</applications>";
        System.out.println("XML文件：" + result);
        System.out.println("JSON文件：" + JSONtoXMLUtil.documentToJSONObject(result).toJSONString());
        //XML转JSON
        String xml="<?xml version=\"1.0\" encoding=\"utf-8\" ?><MoBaoAccount MessageType=\"UserMobilePay\" PlatformID=\"b2ctest\"><OrderNo>M20150521084825</OrderNo><TradeAmt>5000.00</TradeAmt><Commission>0.5</Commission><UserID>zhuxiaolong</UserID><MerchID>zhuxiaolong1</MerchID><tradeType>0</tradeType><CustParam>123</CustParam> <NotifyUrl>http://mobaopay.com/callback.do</NotifyUrl><TradeSummary>订单</TradeSummary></MoBaoAccount>";
        System.out.println(xml);
    }
}
