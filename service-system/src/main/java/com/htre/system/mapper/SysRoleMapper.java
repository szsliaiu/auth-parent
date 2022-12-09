package com.htre.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.htre.model.system.SysRole;
import com.htre.model.vo.SysRoleQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author panjinsheng
 * @Create 2022/11/04/18:39
 * Description:
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {

    //条件分页查询
    IPage<SysRole> selectPage(Page<SysRole> pageParam,@Param("vo") SysRoleQueryVo sysRoleQueryVo);

}
