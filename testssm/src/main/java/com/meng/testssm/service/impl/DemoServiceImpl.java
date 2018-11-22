package com.meng.testssm.service.impl;

import java.util.List;

import com.meng.testssm.dao.DemoMapper;
import com.meng.testssm.entity.DemoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meng.testssm.entity.Demo;
import com.meng.testssm.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	private DemoMapper demoMapper;
	
	@Override
	public List<Demo> findList() {
		DemoExample demoExample = new DemoExample();

		return demoMapper.selectByExample(demoExample);
	}
	
}
