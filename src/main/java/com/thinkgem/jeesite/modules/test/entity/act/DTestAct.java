/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.test.entity.act;

import org.hibernate.validator.constraints.Length;

import com.thinkgem.jeesite.common.persistence.DataEntity;

/**
 * 工作流测试Entity
 * @author ycs
 * @version 2018-08-31
 */
public class DTestAct extends DataEntity<DTestAct> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// name
	private String age;		// age
	private String phone;		// phone
	
	public DTestAct() {
		super();
	}

	public DTestAct(String id){
		super(id);
	}

	@Length(min=0, max=50, message="name长度必须介于 0 和 50 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=50, message="age长度必须介于 0 和 50 之间")
	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	@Length(min=0, max=50, message="phone长度必须介于 0 和 50 之间")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}