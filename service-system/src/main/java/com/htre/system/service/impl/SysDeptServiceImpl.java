package com.htre.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htre.model.system.SysDept;
import com.htre.model.system.SysMenu;
import com.htre.system.exception.MyException;
import com.htre.system.mapper.SysDeptMapper;
import com.htre.system.service.SysDeptService;
import com.htre.system.utils.DeptHelper;
import com.htre.system.utils.MenuHelper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author panjinsheng
 * @Create 2022/12/9 22:18
 * Description:
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements SysDeptService {

    //部门列表（树形）
    @Override
    public List<SysDept> findNodes() {
        List<SysDept> sysDeptList = baseMapper.selectList(null);
        List<SysDept> resultList = DeptHelper.bulidTree(sysDeptList);
        return resultList;
    }

    //更改状态
    @Override
    public void updateStatus(String id, Integer status) {
        SysDept sysDept = baseMapper.selectById(id);
        sysDept.setStatus(status);
        baseMapper.updateById(sysDept);
    }

    //删除部门
    @Override
    public void removeDeptById(String id) {
        QueryWrapper<SysDept> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id",id);
        Integer rows = baseMapper.selectCount(queryWrapper);
        if (rows > 0) {
            throw new MyException(201,"请先删除子部门");
        }
        baseMapper.deleteById(id);
    }
}