package com.web.testssm.service.impl;

import java.util.List;

import com.web.testssm.dao.DemoMapper;
import com.web.testssm.entity.Demo;
import com.web.testssm.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	private DemoMapper demoMapper;
	
	@Override
	public Demo findList() {
        return demoMapper.selectByPrimaryKey("1");
	}
	
}
