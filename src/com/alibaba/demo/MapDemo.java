package com.alibaba.demo;

import java.util.ArrayList;
import java.util.List;


import com.alibaba.demo.entity.Employee;
import net.sf.json.JSONArray;


public class MapDemo {

    public static void main(String[] args){

       /* Map<String, String> obj = new HashMap<String, String>(){{
            put("name",  "lisi");
            put("age", "18");
        }};
        System.err.println(obj.toString());*/

        List<Employee> emps = new ArrayList<Employee>();
        for(int i=0;i<3;i++){
            Employee s = new Employee();
            s.setId(i+1);
            s.setName("Bear" + i);
            s.setGender("男");
            emps.add(s);
        }
        JSONArray jsonArr = JSONArray.fromObject(emps);
        String jsonStr = jsonArr.toString();
        System.err.println(jsonStr);
    }
}
