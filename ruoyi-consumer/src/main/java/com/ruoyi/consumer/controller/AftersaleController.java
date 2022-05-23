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
import com.ruoyi.consumer.domain.Aftersale;
import com.ruoyi.consumer.service.IAftersaleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 我的售后Controller
 * 
 * @author ruoyi
 * @date 2021-12-30
 */
@RestController
@RequestMapping("/consumer/aftersale")
public class AftersaleController extends BaseController
{
    @Autowired
    private IAftersaleService aftersaleService;

    /**
     * 查询我的售后列表
     */
    @PreAuthorize("@ss.hasPermi('consumer:aftersale:list')")
    @GetMapping("/list")
    public TableDataInfo list(Aftersale aftersale)
    {
        startPage();
        List<Aftersale> list = aftersaleService.selectAftersaleList(aftersale);
        return getDataTable(list);
    }

    /**
     * 导出我的售后列表
     */
    @PreAuthorize("@ss.hasPermi('consumer:aftersale:export')")
    @Log(title = "我的售后", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Aftersale aftersale)
    {
        List<Aftersale> list = aftersaleService.selectAftersaleList(aftersale);
        ExcelUtil<Aftersale> util = new ExcelUtil<Aftersale>(Aftersale.class);
        util.exportExcel(response, list, "我的售后数据");
    }

    /**
     * 获取我的售后详细信息
     */
    @PreAuthorize("@ss.hasPermi('consumer:aftersale:query')")
    @GetMapping(value = "/{aftersaleId}")
    public AjaxResult getInfo(@PathVariable("aftersaleId") Long aftersaleId)
    {
        return AjaxResult.success(aftersaleService.selectAftersaleByAftersaleId(aftersaleId));
    }

    /**
     * 新增我的售后
     */
    @PreAuthorize("@ss.hasPermi('consumer:aftersale:add')")
    @Log(title = "我的售后", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Aftersale aftersale)
    {
        return toAjax(aftersaleService.insertAftersale(aftersale));
    }

    /**
     * 修改我的售后
     */
    @PreAuthorize("@ss.hasPermi('consumer:aftersale:edit')")
    @Log(title = "我的售后", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Aftersale aftersale)
    {
        return toAjax(aftersaleService.updateAftersale(aftersale));
    }

    /**
     * 删除我的售后
     */
    @PreAuthorize("@ss.hasPermi('consumer:aftersale:remove')")
    @Log(title = "我的售后", businessType = BusinessType.DELETE)
	@DeleteMapping("/{aftersaleIds}")
    public AjaxResult remove(@PathVariable Long[] aftersaleIds)
    {
        return toAjax(aftersaleService.deleteAftersaleByAftersaleIds(aftersaleIds));
    }
}
