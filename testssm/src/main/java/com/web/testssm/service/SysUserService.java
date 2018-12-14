package com.web.testssm.service;

import com.web.testssm.entity.SysUser;

import java.util.List;

/**
 * @author crystalzhao
 * @version V1.0
 * @date 2018/12/8
 */
public interface SysUserService {
    public List<SysUser> getUserByLoginName(String loginName);
}
