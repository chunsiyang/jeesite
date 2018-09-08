/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.web.act;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.activiti.engine.ProcessEngine;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.test.entity.act.DTestAct;
import com.thinkgem.jeesite.modules.test.service.act.DTestActService;

/**
 * 工作流测试Controller
 * @author ycs
 * @version 2018-08-31
 */
@Controller
@RequestMapping(value = "${adminPath}/test/act/dTestAct")
public class DTestActController extends BaseController {

	@Autowired
	private DTestActService dTestActService;
	@Autowired
	private ProcessEngine processEngine;
	
	@RequiresPermissions("test:act:dTestAct:view")
	@RequestMapping(value = {"list", ""})
	public String list(DTestAct dTestAct, HttpServletRequest request, HttpServletResponse response, Model model) {
		return "modules/test/act/dTestActList";
	}

	@RequiresPermissions("test:act:dTestAct:view")
	@RequestMapping(value = "startAct")
	public String startAct(DTestAct dTestAct, Model model) {
//		processEngine.
		return "modules/test/act/dTestActForm";
	}

}