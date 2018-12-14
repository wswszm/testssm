package com.web.testssm.service.impl;

import com.web.testssm.dao.SysUserMapper;
import com.web.testssm.entity.SysUser;
import com.web.testssm.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author crystalzhao
 * @version V1.0
 * @date 2018/12/8
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> getUserByLoginName(String loginName) {
        return sysUserMapper.getUserByLoginName(loginName);
    }
}
