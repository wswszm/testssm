package com.meng.testssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meng.testssm.dao.DemoDao;
import com.meng.testssm.entity.Demo;
import com.meng.testssm.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	private DemoDao demoDao;
	
	@Override
	public List<Demo> findList() {
		
		return demoDao.findList();
	}
	
}
