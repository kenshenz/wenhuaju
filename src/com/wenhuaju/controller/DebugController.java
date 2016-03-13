package com.wenhuaju.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试用Controller
 * @author feng
 * @date 2016年3月13日
 */
@Controller("/debug")
public class DebugController {
	
	Logger log = LoggerFactory.getLogger(getClass());
	
	@RequestMapping(path="/debug.htm")
	public void debug() {
		log.debug("Controller 测试方法");
		
	}
}
