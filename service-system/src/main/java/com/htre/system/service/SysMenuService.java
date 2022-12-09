package com.htre.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.htre.model.system.SysMenu;
import com.htre.model.vo.AssginMenuVo;
import com.htre.model.vo.RouterVo;

import java.util.List;

/**
 * <p>
 * 菜单表 服务类
 * </p>
 *
 * @author panjinsheng
 * @since 2022-11-05
 */
public interface SysMenuService extends IService<SysMenu> {

    //菜单列表（树形）
    List<SysMenu> findNodes();

    // //删除菜单
    void removeMenuById(String id);

    //根据角色分配菜单
    List<SysMenu> findMenuByRoleId(String roleId);

    //给角色分配菜单权限
    void doAssign(AssginMenuVo assginMenuVo);

    //根据userid查询菜单权限值
    List<RouterVo> getUserMenuList(String userId);

    //根据userid查询按钮权限值
    List<String> getUserButtonList(String userId);
}
