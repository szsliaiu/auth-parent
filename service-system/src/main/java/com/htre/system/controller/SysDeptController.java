package com.htre.system.controller;

import com.htre.common.result.Result;
import com.htre.model.system.SysDept;
import com.htre.model.system.SysMenu;
import com.htre.system.service.SysDeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author panjinsheng
 * @Create 2022/12/9 22:17
 * Description:
 */

@Api(tags = "部门管理")
@RestController
@RequestMapping("/admin/system/sysDept")
public class SysDeptController {

    @Autowired
    private SysDeptService sysDeptService;

    //部门列表（树形）
    @ApiOperation("部门列表")
    @GetMapping("findNodes")
    public Result findNodes() {
        List<SysDept> list = sysDeptService.findNodes();
        return Result.ok(list);
    }

    @ApiOperation("更改状态")
    @GetMapping("updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable String id,
                               @PathVariable Integer status){
        sysDeptService.updateStatus(id,status);
        return Result.ok();
    }

    @ApiOperation("增加部门")
    @PostMapping("save")
    public Result save(@RequestBody SysDept sysDept){
        sysDeptService.save(sysDept);
        return Result.ok();
    }

    @ApiOperation("根据id查询菜单")
    @GetMapping("findNode/{id}")
    public Result findNode(@PathVariable String id) {
        SysDept sysDept = sysDeptService.getById(id);
        return  Result.ok(sysDept);
    }

    @ApiOperation("修改部门")
    @PostMapping("update")
    public Result update(@RequestBody SysDept sysDept) {
        sysDeptService.updateById(sysDept);
        return Result.ok();
    }

    @ApiOperation("删除部门")
    @DeleteMapping("remove/{id}")
    public Result removeById(@PathVariable String id) {
        sysDeptService.removeDeptById(id);
        return Result.ok();
    }
}