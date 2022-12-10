package com.htre.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.htre.model.system.SysDept;
import com.htre.model.system.SysMenu;

import java.util.List;

/**
 * @Author panjinsheng
 * @Create 2022/12/9 22:18
 * Description:
 */
public interface SysDeptService extends IService<SysDept> {
    //部门列表（树形）
    List<SysDept> findNodes();

    //更改状态
    void updateStatus(String id, Integer status);

    //删除部门
    void removeDeptById(String id);
}
