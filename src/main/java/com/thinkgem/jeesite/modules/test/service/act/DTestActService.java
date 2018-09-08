/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.service.act;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.test.entity.act.DTestAct;
import com.thinkgem.jeesite.modules.test.dao.act.DTestActDao;

/**
 * 工作流测试Service
 * @author ycs
 * @version 2018-08-31
 */
@Service
@Transactional(readOnly = true)
public class DTestActService extends CrudService<DTestActDao, DTestAct> {

	public DTestAct get(String id) {
		return super.get(id);
	}
	
	public List<DTestAct> findList(DTestAct dTestAct) {
		return super.findList(dTestAct);
	}
	
	public Page<DTestAct> findPage(Page<DTestAct> page, DTestAct dTestAct) {
		return super.findPage(page, dTestAct);
	}
	
	@Transactional(readOnly = false)
	public void save(DTestAct dTestAct) {
		super.save(dTestAct);
	}
	
	@Transactional(readOnly = false)
	public void delete(DTestAct dTestAct) {
		super.delete(dTestAct);
	}
	
}