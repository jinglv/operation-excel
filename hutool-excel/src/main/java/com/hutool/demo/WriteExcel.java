package com.hutool.demo;

import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.hutool.entity.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 写入Excel
 *
 * @author jingLv
 * @date 2020/11/10
 */
public class WriteExcel {

    public static void main(String[] args) {
        // 声明写入的Excel
        ExcelWriter writer = ExcelUtil.getWriter("/Users/apple/JavaProject/operation-excel/HutoolWrite.xlsx");
        // 自定义标题别名
        writer.addHeaderAlias("userName", "姓名");
        writer.addHeaderAlias("sex", "性别");
        writer.addHeaderAlias("age", "年龄");
        writer.addHeaderAlias("date", "日期");
        // 写入数据的实例
        List<User> users = new ArrayList<User>();
        User user = new User();
        users.add(user.setUsername("王晓霞").setSex("女").setDate(new Date()).setAge(18));
        // 写入内容
        writer.write(users, true);
        // 关闭 writer，释放内存
        writer.close();
    }
}
