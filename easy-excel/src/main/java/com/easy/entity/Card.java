package com.easy.entity;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jingLv
 * @date 2021/01/20
 */
@Data
@ExcelTarget("card")
public class Card implements Serializable {

    private static final long serialVersionUID = 9083730912519223193L;

    @Excel(name = "身份证号", orderNum = "7")
    private String idCard;
    @Excel(name = "家庭住址", orderNum = "8")
    private String address;
}
