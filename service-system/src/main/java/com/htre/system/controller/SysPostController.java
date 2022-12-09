package com.htre.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.htre.common.result.Result;
import com.htre.model.system.SysPost;
import com.htre.model.system.SysRole;
import com.htre.model.vo.SysPostQueryVo;
import com.htre.model.vo.SysRoleQueryVo;
import com.htre.system.service.SysPostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @Author panjinsheng
 * @Create 2022/12/9 20:16
 * Description:
 */

@Api(tags = "岗位管理接口")
@RestController
@RequestMapping("/admin/system/sysPost")
public class SysPostController {

    @Autowired
    private SysPostService sysPostService;

    @ApiOperation("更改用户状态")
    @GetMapping("updateStatus/{id}/{status}")
    public Result updateStatus(@PathVariable String id,
                               @PathVariable Integer status){
        sysPostService.updateStatus(id,status);
        return Result.ok();
    }

    //6 修改-最终修改
    @ApiOperation("最终修改")
    @PostMapping("update")
    public Result updatePost(@RequestBody SysPost sysPost){
        boolean isSuccess = sysPostService.updateById(sysPost);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }

    //5 修改-根据id查询
    @ApiOperation("根据id查询")
    @PostMapping("findPostById/{id}")
    public Result findRoleById(@PathVariable String id) {
        SysPost sysPost = sysPostService.getById(id);
        return Result.ok(sysPost);
    }

    @ApiOperation("增加岗位")
    @PostMapping("savePost")
    public Result savePost(@RequestBody SysPost sysPost){
        boolean isSuccess = sysPostService.save(sysPost);
        if (isSuccess) {
            return Result.ok();
        }else {
            return Result.fail("增加岗位失败");
        }
    }

    //3 条件分页查询
    // page当前页  limit每页记录数
    @ApiOperation("条件分页查询")
    @GetMapping("{page}/{limit}")
    public Result findPageQueryRole(@PathVariable Long page,
                                    @PathVariable Long limit,
                                    SysPostQueryVo sysPostQueryVo) {
        //创建page对象
        Page<SysRole> pageParam = new Page<>(page, limit);
        //调用service方法
        IPage<SysRole> pageModel = sysPostService.selectPage(pageParam, sysPostQueryVo);
        //返回
        return Result.ok(pageModel);
    }

    //2 逻辑删除接口
    @ApiOperation("逻辑删除接口")
    @DeleteMapping("remove/{id}")
    public Result removePost(@PathVariable Long id){
        boolean isSuccess = sysPostService.removeById(id);
        if (isSuccess) {
            return Result.ok();
        } else {
            return Result.fail();
        }
    }
}