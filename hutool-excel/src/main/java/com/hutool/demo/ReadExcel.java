package com.hutool.demo;

import cn.hutool.core.io.FileUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.hutool.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 读取Excel
 *
 * @author jingLv
 * @date 2020/11/06
 */
public class ReadExcel {

    public static void main(String[] args) {
        ExcelReader reader = ExcelUtil.getReader(FileUtil.file("/Users/apple/JavaProject/operation-excel/HutoolWrite.xlsx"));
        // read() -- 返回list 读取所有的行
        List<List<Object>> read = reader.read();
        read.forEach(System.out::println);

        // readAll() -- 返回Map 读取所有的行
        List<Map<String, Object>> maps = reader.readAll();
        // 列名:对应的值
        maps.forEach(map -> map.forEach((key, value) -> System.out.println(key + ":" + value)));

        // 根据实体类进行字段的对应
        List<User> users = reader.readAll(User.class);
        System.out.println(users.toString());
    }
}
