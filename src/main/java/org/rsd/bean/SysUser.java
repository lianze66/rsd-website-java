package org.rsd.bean;

import lombok.Data;

import java.util.Date;

@Data
public class SysUser {

    private Integer id;

    private String loginName;

    private String password;

    private String realName;

    private String headPicPath;

    private Integer roleId;

    private String sex;

    private String tel;

    private Date createTime;

}
