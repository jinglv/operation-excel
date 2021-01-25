package com.easy.entity;

import cn.afterturn.easypoi.excel.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author jingLv
 * @date 2021/01/19
 */
@Data
@ExcelTarget("users")
public class User implements Serializable {
    private static final long serialVersionUID = -3764618099931012959L;

    @Excel(name = "编号", orderNum = "1")
    private String id;
    @Excel(name = "姓名", orderNum = "2")
    private String name;
    // @Excel(name = "年龄", orderNum = "4", suffix = " $")
    @ExcelIgnore
    private Integer age;
    @Excel(name = "生日", orderNum = "3", width = 20.0, exportFormat = "yyyy年MM月dd日")
    private Date bir;
    @Excel(name = "状态", orderNum = "5", replace = {"激活_1", "锁定_0"})
    private String status;
    // @Excel(name = "爱好", orderNum = "6", width = 20.0)
    // 1. 忽略该字段
    @ExcelIgnore
    private List<String> habits;
    // 2. 定义爱好字符串代替habits
    @Excel(name = "爱好", orderNum = "6", width = 20.0)
    private String habitsStr;

    // 3. 修改get方法
    public String getHabitsStr() {
        StringBuilder sb = new StringBuilder();
        this.habits.forEach(s -> sb.append(s).append("、"));
        return sb.toString();
    }

    // 标识一对一的关系
    @ExcelEntity(name = "card")
    private Card card;

    @ExcelCollection(name = "订单信息", orderNum = "8")
    private List<Order> orders;

    /**
     * 定义头像 直接写指定图片路径
     * type的值一定要指定为2
     */
    @Excel(name = "头像信息", type = 2, orderNum = "0", width = 12, height = 12)
    private String photo;
}
