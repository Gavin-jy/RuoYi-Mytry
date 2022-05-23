package com.ruoyi.consumer.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.consumer.domain.Myorder;
import com.ruoyi.consumer.service.IMyorderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 我的订单Controller
 * 
 * @author ruoyi
 * @date 2021-12-30
 */
@RestController
@RequestMapping("/consumer/myorder")
public class MyorderController extends BaseController
{
    @Autowired
    private IMyorderService myorderService;

    /**
     * 查询我的订单列表
     */
    @PreAuthorize("@ss.hasPermi('consumer:myorder:list')")
    @GetMapping("/list")
    public TableDataInfo list(Myorder myorder)
    {
        startPage();
        List<Myorder> list = myorderService.selectMyorderList(myorder);
        return getDataTable(list);
    }

    /**
     * 导出我的订单列表
     */
    @PreAuthorize("@ss.hasPermi('consumer:myorder:export')")
    @Log(title = "我的订单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Myorder myorder)
    {
        List<Myorder> list = myorderService.selectMyorderList(myorder);
        ExcelUtil<Myorder> util = new ExcelUtil<Myorder>(Myorder.class);
        util.exportExcel(response, list, "我的订单数据");
    }

    /**
     * 获取我的订单详细信息
     */
    @PreAuthorize("@ss.hasPermi('consumer:myorder:query')")
    @GetMapping(value = "/{myorderId}")
    public AjaxResult getInfo(@PathVariable("myorderId") Long myorderId)
    {
        return AjaxResult.success(myorderService.selectMyorderByMyorderId(myorderId));
    }

    /**
     * 新增我的订单
     */
    @PreAuthorize("@ss.hasPermi('consumer:myorder:add')")
    @Log(title = "我的订单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Myorder myorder)
    {
        return toAjax(myorderService.insertMyorder(myorder));
    }

    /**
     * 修改我的订单
     */
    @PreAuthorize("@ss.hasPermi('consumer:myorder:edit')")
    @Log(title = "我的订单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Myorder myorder)
    {
        return toAjax(myorderService.updateMyorder(myorder));
    }

    /**
     * 删除我的订单
     */
    @PreAuthorize("@ss.hasPermi('consumer:myorder:remove')")
    @Log(title = "我的订单", businessType = BusinessType.DELETE)
	@DeleteMapping("/{myorderIds}")
    public AjaxResult remove(@PathVariable Long[] myorderIds)
    {
        return toAjax(myorderService.deleteMyorderByMyorderIds(myorderIds));
    }
}
