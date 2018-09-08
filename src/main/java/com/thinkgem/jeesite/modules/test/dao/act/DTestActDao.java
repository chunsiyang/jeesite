/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.dao.act;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.test.entity.act.DTestAct;

/**
 * 工作流测试DAO接口
 * @author ycs
 * @version 2018-08-31
 */
@MyBatisDao
public interface DTestActDao extends CrudDao<DTestAct> {
	
}