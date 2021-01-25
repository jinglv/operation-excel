package com.hutool.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * @author jingLv
 * @date 2020/11/10
 */
@Data
@Accessors(chain = true)
public class User implements Serializable {

    private static final long serialVersionUID = -3764618099931012959L;

    /**
     * 用户名
     */
    private String username;
    /**
     * 性别
     */
    private String sex;
    /**
     * 日期
     */
    private Date date;
    /**
     * 年龄
     */
    private Integer age;
}
