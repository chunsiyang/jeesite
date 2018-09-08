/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.adrevirw.web.adrevirw;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.thinkgem.jeesite.modules.adrevirw.entity.adrevirw.DAdRevirw;
import com.thinkgem.jeesite.modules.adrevirw.service.adrevirw.DAdRevirwService;

/**
 * adRevirwController
 * @author adRevirw
 * @version 2018-09-03
 */
@Controller
@RequestMapping(value = "${adminPath}/adrevirw/adrevirw/dAdRevirw")
public class DAdRevirwController extends BaseController {

	@Autowired
	private DAdRevirwService dAdRevirwService;
	
	@ModelAttribute
	public DAdRevirw get(@RequestParam(required=false) String id) {
		DAdRevirw entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = dAdRevirwService.get(id);
		}
		if (entity == null){
			entity = new DAdRevirw();
		}
		return entity;
	}
	
	@RequiresPermissions("adrevirw:adrevirw:dAdRevirw:view")
	@RequestMapping(value = {"list", ""})
	public String list(DAdRevirw dAdRevirw, HttpServletRequest request, HttpServletResponse response, Model model) {

		return "modules/adrevirw/adrevirw/dAdRevirwList";
	}

	@RequiresPermissions("adrevirw:adrevirw:dAdRevirw:view")
	@RequestMapping(value = "form2")
	public String form2(DAdRevirw dAdRevirw, Model model) {
		model.addAttribute("dAdRevirw", dAdRevirw);
		return "modules/adrevirw/adrevirw/dAdRevirwForm";
	}

	@RequiresPermissions("adrevirw:adrevirw:dAdRevirw:view")
	@RequestMapping(value = "save")
	public String save(DAdRevirw dAdRevirw, Model model) {
		dAdRevirwService.save(dAdRevirw);
		model.addAttribute("dAdRevirw", dAdRevirw);
		return "modules/adrevirw/adrevirw/dAdRevirwForm";
	}

}