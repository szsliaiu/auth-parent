package com.htre.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.htre.model.system.SysLoginLog;
import com.htre.model.vo.SysLoginLogQueryVo;

/**
 * @Author panjinsheng
 * @Create 2022/12/8 18:28
 * Description:
 */
public interface LoginLogService {

    //登录日志
    public void recordLoginLog(String username,Integer status,
                               String ipaddr,String message);

    //条件分页查询登录日志
    IPage<SysLoginLog> selectPage(long page, long limit, SysLoginLogQueryVo sysLoginLogQueryVo);
}
