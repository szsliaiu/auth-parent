package com.htre.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.htre.model.system.SysPost;
import com.htre.model.system.SysRole;
import com.htre.model.vo.SysPostQueryVo;
import com.htre.system.mapper.SysPostMapper;
import com.htre.system.service.SysPostService;
import org.springframework.stereotype.Service;

/**
 * @Author panjinsheng
 * @Create 2022/12/9 20:17
 * Description:
 */
@Service
public class SysPostServiceImpl extends ServiceImpl<SysPostMapper, SysPost> implements SysPostService {

    //条件分页查询
    @Override
    public IPage<SysRole> selectPage(Page<SysRole> pageParam, SysPostQueryVo sysPostQueryVo) {
        IPage<SysRole> pageModel = baseMapper.selectPage(pageParam, sysPostQueryVo);
        return pageModel;
    }

    //更改用户状态
    @Override
    public void updateStatus(String id, Integer status) {
        SysPost sysPost = baseMapper.selectById(id);
        sysPost.setStatus(status);
        baseMapper.updateById(sysPost);
    }
}