package com.web.testssm.service.impl;

import java.util.List;
import java.util.Map;

import com.web.testssm.dao.DemoMapper;
import com.web.testssm.dao.KwKcapMapper;
import com.web.testssm.dao.KwXkXxMapper;
import com.web.testssm.entity.Demo;
import com.web.testssm.entity.KwKcap;
import com.web.testssm.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	private DemoMapper demoMapper;
	@Autowired
	private KwKcapMapper kwKcapMapper;

	@Override
	public Demo findList() {
        return demoMapper.selectByPrimaryKey("1");
	}

	@Override
	public void test() {
		List<KwKcap> list = kwKcapMapper.test();
		list.forEach(kwKcap -> {
			String ksly = "";
			for(String k : kwKcap.getKcxh().split(",")){
				List<Map<String, Object>> l = kwKcapMapper.test1(k, kwKcap.getZydm());
				if(l.size()>0 && ksly.indexOf(l.get(0).get("aaa").toString()) < 0){
					ksly += "+" + l.get(0).get("aaa");
				}

			}
			if(ksly.length()>0){
				ksly = ksly.substring(1,ksly.length());
				kwKcap.setKsly(ksly);
			}
			kwKcapMapper.updateByPrimaryKey(kwKcap);
		});
	}

}
