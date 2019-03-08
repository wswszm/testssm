package com.web.testssm.service.impl;

import com.web.testssm.dao.SysUserDao;
import com.web.testssm.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author crystalzhao
 * @version V1.0
 * @date 2019/3/8
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserDao sysUserDao;
}
