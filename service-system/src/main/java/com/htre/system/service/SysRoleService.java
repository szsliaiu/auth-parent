package com.htre.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htre.model.system.SysRole;
import com.htre.model.vo.AssginRoleVo;
import com.htre.model.vo.SysRoleQueryVo;

import java.util.Map;

/**
 * @Author panjinsheng
 * @Create 2022/12/6 12:30
 * Description:
 */
public interface SysRoleService extends IService<SysRole> {
    //条件分页查询
    IPage<SysRole> selectPage(Page<SysRole> pageParam, SysRoleQueryVo sysRoleQueryVo);

    //获取用户的角色数据
    Map<String, Object> getRolesByUserId(String userId);

    //用户分配角色
    void doAssign(AssginRoleVo assginRoleVo);
}
