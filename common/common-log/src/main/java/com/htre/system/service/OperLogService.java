package com.htre.system.service;

import com.htre.model.system.SysOperLog;
import com.htre.model.vo.SysOperLogQueryVo;
import com.baomidou.mybatisplus.core.metadata.IPage;

public interface OperLogService {

    public void saveSysLog(SysOperLog sysOperLog);

    //操作日志分页查询
    IPage<SysOperLog> selectPage(Long page, Long limit, SysOperLogQueryVo sysOperLogQueryVo);
}
