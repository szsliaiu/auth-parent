package com.htre.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.htre.model.system.SysPost;
import com.htre.model.system.SysRole;
import com.htre.model.vo.SysPostQueryVo;
import com.htre.model.vo.SysRoleQueryVo;
import org.apache.ibatis.annotations.Param;

/**
 * @Author panjinsheng
 * @Create 2022/12/9 20:17
 * Description:
 */
public interface SysPostMapper extends BaseMapper<SysPost> {

    //条件分页查询
    IPage<SysRole> selectPage(Page<SysRole> pageParam, @Param("vo") SysPostQueryVo sysPostQueryVo);

}
