package com.web.testssm.entity;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class SysUser implements Serializable {
    private String id;
    private String loginName;
    private String password;
    private String no;
    private String name;
    private String enName;
    private String email;
    private String mobile;
    private String userType;
    private String photo;
    private String loginIp;
    private Date loginDate;
    private Integer loginNum;
    private String loginFlag;
    private String isFirst;
    private String passwordTmp;
    private String createBy;
    private Date createDate;
    private String updateBy;
    private Date updateDate;
    private String remarks;
    private static final long serialVersionUID = 1L;

}