package com.cpt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cpt.model.PostInfo;
import com.cpt.service.IPostInfoService;

@Controller
@RequestMapping("post")
public class PostInfoController {

	@Autowired private IPostInfoService postInfoService;
	
	@RequestMapping("getLst")
	public @ResponseBody List<PostInfo> getLst(ModelMap map){

		return postInfoService.getLst();
	}
	
}
