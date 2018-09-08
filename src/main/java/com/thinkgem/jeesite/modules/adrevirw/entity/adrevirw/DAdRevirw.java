/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.adrevirw.entity.adrevirw;

import com.thinkgem.jeesite.common.persistence.ActEntity;
import org.hibernate.validator.constraints.Length;


/**
 * adRevirwEntity
 * @author adRevirw
 * @version 2018-09-03
 */
public class DAdRevirw extends ActEntity<DAdRevirw> {
	
	private static final long serialVersionUID = 1L;
	private String name;		// 名字
	private String type;		// 类型
	private String value;		// 数值
	
	public DAdRevirw() {
		super();
	}

	public DAdRevirw(String id){
		super(id);
	}
	
	@Length(min=0, max=62, message="名字长度必须介于 0 和 62 之间")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Length(min=0, max=62, message="类型长度必须介于 0 和 62 之间")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	@Length(min=0, max=62, message="数值长度必须介于 0 和 62 之间")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}