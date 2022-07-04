package org.rsd.bean;

import lombok.Data;

import java.util.Date;

@Data
public class SysRole {

    private Integer id;

    private String name;

    private Date createTime;
}
