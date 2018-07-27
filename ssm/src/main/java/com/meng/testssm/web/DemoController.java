package com.meng.testssm.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.meng.testssm.service.DemoService;

@Controller
@RequestMapping("demo")
public class DemoController {

	@Autowired
	private DemoService demoService;
	
	@RequestMapping("findList")
	@ResponseBody
	public Map<String, Object> findList(){
		Map<String, Object> map = new HashMap<>();
		map.put("list", demoService.findList());
		return map;
	}
}
