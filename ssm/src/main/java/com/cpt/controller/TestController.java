package com.cpt.controller;

import com.cpt.service.TestService;
import com.cpt.util.ValidateCodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("test")
public class TestController {
	private static Logger logger = LoggerFactory.getLogger(TestController.class);


	@Autowired
	private StringRedisTemplate redisTemplate;
	@Autowired
	private TestService testService;


	@RequestMapping(value = "result",method = RequestMethod.POST)
	@ResponseBody
	public Map<String,Object> test(){
		Map<String,Object> map = new HashMap<>();
		map.put("result","OK");
		map.put("msg","欢迎登陆！");

		return map;
	}


	@RequestMapping(value = "result",method = RequestMethod.GET)
	public ModelMap result(ModelMap map){
		Map<String,Object> map2 = new HashMap<>();
		map2.put("msg","欢迎登陆！");
		redisTemplate.opsForValue().set("result",map2.get("msg").toString());

		return map;
	}

	@RequestMapping("/code")
	public void code(HttpServletRequest request, HttpServletResponse response) {
		try {
			ValidateCodeUtil.getCode(request, response);
		} catch (IOException e) {
			logger.info("获取验证码失败" + e);
		}
	}

	@RequestMapping("cachePutMap")
	public @ResponseBody Map cachePutMap(){


		return testService.cahePutMap(888, 8888);
	}
	@RequestMapping("cache")
	public @ResponseBody String testCache(){


		return testService.getTest(100190, 888);
	}
	@RequestMapping("cache2")
	public @ResponseBody String testCache2(){


		return testService.put(100190, 888);
	}
	
}
