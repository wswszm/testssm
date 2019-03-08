package com.web.testssm.web;

import java.util.HashMap;
import java.util.Map;

import com.web.testssm.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("demo")
public class DemoController {

	@Autowired
	private DemoService demoService;
	@Autowired
	private RedisTemplate<Object, Object> redisTemplate;

	@RequestMapping("findList")
	@ResponseBody
	public Map<String, Object> findList(){
		demoService.test();
		return null;
	}
	@RequestMapping("getFile")
	@ResponseBody
	public Map<String, Object> getFile(){
		demoService.test2();
		return null;
	}
}
