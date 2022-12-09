package com.htre.system.utils;

import com.htre.model.system.SysMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author panjinsheng
 * @Create 2022/12/7 8:38
 * Description:
 */

public class MenuHelper {

    //构建树形结构
    public static List<SysMenu> bulidTree(List<SysMenu> sysMenuList) {
        //创建集合封装最终数据
        List<SysMenu> trees = new ArrayList<>();
        //遍历所有菜单集合
        for (SysMenu sysMenu : sysMenuList) {
            //找到递归入口，parentid=0
            if (sysMenu.getParentId().longValue() ==0 ) {
                trees.add(findChildren(sysMenu,sysMenuList));
            }
        }
        return trees;
    }

    //从根节点进行递归查询，查询子节点
    // 判断 id =  parentid是否相同，如果相同是子节点，进行数据封装
    private static SysMenu findChildren(SysMenu sysMenu, List<SysMenu> treeNodes) {
        //数据初始化
        sysMenu.setChildren(new ArrayList<SysMenu>());
        //遍历递归查找
        for (SysMenu treeNode : treeNodes) {
            //获取当前菜单id
//            String id = sysMenu.getId();
//            long cid = Long.parseLong(id);
            //获取所有菜单parentid
//            Long parentId = treeNode.getParentId();
            //比对
            if (Long.parseLong(sysMenu.getId())==treeNode.getParentId()) {
                if (sysMenu.getChildren() == null){
                    sysMenu.setChildren(new ArrayList<>());
                }
                sysMenu.getChildren().add(findChildren(treeNode,treeNodes));
            }
        }
        return sysMenu;
    }
}