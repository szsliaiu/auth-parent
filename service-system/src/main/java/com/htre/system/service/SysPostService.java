package com.htre.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.htre.model.system.SysPost;
import com.htre.model.system.SysRole;
import com.htre.model.vo.SysPostQueryVo;

/**
 * @Author panjinsheng
 * @Create 2022/12/9 20:17
 * Description:
 */
public interface SysPostService extends IService<SysPost> {
    //条件分页查询
    IPage<SysRole> selectPage(Page<SysRole> pageParam, SysPostQueryVo sysPostQueryVo);

    //更改用户状态
    void updateStatus(String id, Integer status);
}
