/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.adrevirw.service.adrevirw;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.act.service.ActTaskService;
import com.thinkgem.jeesite.modules.act.utils.ActUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.adrevirw.entity.adrevirw.DAdRevirw;
import com.thinkgem.jeesite.modules.adrevirw.dao.adrevirw.DAdRevirwDao;

/**
 * adRevirwService
 *
 * @author adRevirw
 * @version 2018-09-03
 */
@Service
@Transactional(readOnly = true)
public class DAdRevirwService extends CrudService<DAdRevirwDao, DAdRevirw> {

    @Autowired
    private ActTaskService actTaskService;

    public DAdRevirw get(String id) {
        return super.get(id);
    }

    public List<DAdRevirw> findList(DAdRevirw dAdRevirw) {
        return super.findList(dAdRevirw);
    }

    public Page<DAdRevirw> findPage(Page<DAdRevirw> page, DAdRevirw dAdRevirw) {
        return super.findPage(page, dAdRevirw);
    }

    @Transactional(readOnly = false)
    public void save(DAdRevirw dAdRevirw) {
        if (StringUtils.isBlank(dAdRevirw.getId())) {
            dAdRevirw.preInsert();
            dao.insert(dAdRevirw);
            Map<String, Object> var = new HashMap<String, Object>();
            var.put("from", dAdRevirw.getValue());
            actTaskService.startProcess(ActUtils.PD_AD_REVIEW[0], ActUtils.PD_AD_REVIEW[1], dAdRevirw.getId(), dAdRevirw.getName(), var);
        }
        // 重新编辑申请
        else {
            dAdRevirw.preUpdate();
            dao.update(dAdRevirw);
            dAdRevirw.getAct().setComment("yes");

            // 完成流程任务
            Map<String, Object> vars = Maps.newHashMap();
            vars.put("pass", dAdRevirw.getValue());
            if (dAdRevirw.getType().equals("1")) {
                vars.put("pass", 0);
            }
            vars.put("isBack", dAdRevirw.getType());
            vars.put("backTo", dAdRevirw.getValue());
            actTaskService.complete(dAdRevirw.getAct().getTaskId(), dAdRevirw.getAct().getProcInsId(), dAdRevirw.getAct().getComment(), dAdRevirw.getName(), vars);
        }
    }

    @Transactional(readOnly = false)
    public void delete(DAdRevirw dAdRevirw) {
        super.delete(dAdRevirw);
    }

}