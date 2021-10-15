package com.zhouyu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ZhouyuController {

	@GetMapping("/test")
	public String test(){
		return "zhouyu";
	}
}
