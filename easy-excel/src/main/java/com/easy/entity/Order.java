package com.easy.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author jingLv
 * @date 2021/01/20
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ExcelTarget("orders")
public class Order implements Serializable {

    private static final long serialVersionUID = -8486811488058323527L;

    @Excel(name = "订单编号", orderNum = "9")
    private String id;
    @Excel(name = "订单名称", orderNum = "10")
    private String name;
}
