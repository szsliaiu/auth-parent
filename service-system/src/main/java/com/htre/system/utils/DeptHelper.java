package com.htre.system.utils;

import com.htre.model.system.SysDept;
import com.htre.model.system.SysMenu;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author panjinsheng
 * @Create 2022/12/9 22:23
 * Description:
 */

public class DeptHelper {

    //构建树形结构
    public static List<SysDept> bulidTree(List<SysDept> SysDeptList) {
        //创建集合封装最终数据
        List<SysDept> trees = new ArrayList<>();
        //遍历所有菜单集合
        for (SysDept sysDept : SysDeptList) {
            //找到递归入口，parentid=0
            if (sysDept.getParentId().longValue() ==0 ) {
                trees.add(findChildren(sysDept,SysDeptList));
            }
        }
        return trees;
    }

    //从根节点进行递归查询，查询子节点
    // 判断 id =  parentid是否相同，如果相同是子节点，进行数据封装
    private static SysDept findChildren(SysDept sysDept, List<SysDept> treeNodes) {
        //数据初始化
        sysDept.setChildren(new ArrayList<>());
        //遍历递归查找
        for (SysDept treeNode : treeNodes) {
            //获取当前菜单id
//            String id = sysMenu.getId();
//            long cid = Long.parseLong(id);
            //获取所有菜单parentid
//            Long parentId = treeNode.getParentId();
            //比对
            if (Long.parseLong(sysDept.getId())==treeNode.getParentId()) {
                if (sysDept.getChildren() == null){
                    sysDept.setChildren(new ArrayList<>());
                }
                sysDept.getChildren().add(findChildren(treeNode,treeNodes));
            }
        }
        return sysDept;
    }
}