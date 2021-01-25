package com.easy.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 注意：对象名必须要与excel的列名对应上
 *
 * @author jingLv
 * @date 2021/01/25
 */
@Data
@ExcelTarget("students")
public class Student implements Serializable {

    private static final long serialVersionUID = -4127812440236301876L;

    @Excel(name = "编号")
    private String id;
    @Excel(name = "姓名")
    private String name;
    @Excel(name = "年龄")
    private Integer age;
    @Excel(name = "生日", format = "yyyy年MM月dd日")
    private Date bir;
    @Excel(name = "状态", replace = {"激活_1", "锁定_0"})
    private String status;
    @Excel(name = "头像", type = 2, savePath = "/Users/apple/JavaProject/operation-excel/easy-excel/image")
    private String photo;
}
