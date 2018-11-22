package com.web.testssm.web;

import java.util.HashMap;
import java.util.Map;

import com.web.testssm.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("demo")
public class DemoController {

	@Autowired
	private DemoService demoService;
	
	@RequestMapping("findList")
	@ResponseBody
	public Map<String, Object> findList(){
		Map<String, Object> map = new HashMap<>();
		map.put("demo", demoService.findList());
		return map;
	}
}
