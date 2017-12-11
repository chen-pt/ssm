package com.cpt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 版权所有(C) 2017 上海银路投资管理有限公司
 * 描述:
 * 作者: chen_pt
 * 创建日期: 2017/11/7
 * 修改记录:
 */
@RequestMapping("/")
@Controller
public class IndexController {

    @RequestMapping("index")
    public void index(){

    }

    @RequestMapping("about")
    public void about(){

    }

}
