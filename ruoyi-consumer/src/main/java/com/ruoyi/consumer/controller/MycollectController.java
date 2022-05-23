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
import com.ruoyi.consumer.domain.Mycollect;
import com.ruoyi.consumer.service.IMycollectService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 我的收藏Controller
 * 
 * @author ruoyi
 * @date 2021-12-30
 */
@RestController
@RequestMapping("/consumer/mycollect")
public class MycollectController extends BaseController
{
    @Autowired
    private IMycollectService mycollectService;

    /**
     * 查询我的收藏列表
     */
    @PreAuthorize("@ss.hasPermi('consumer:mycollect:list')")
    @GetMapping("/list")
    public TableDataInfo list(Mycollect mycollect)
    {
        startPage();
        List<Mycollect> list = mycollectService.selectMycollectList(mycollect);
        return getDataTable(list);
    }

    /**
     * 导出我的收藏列表
     */
    @PreAuthorize("@ss.hasPermi('consumer:mycollect:export')")
    @Log(title = "我的收藏", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Mycollect mycollect)
    {
        List<Mycollect> list = mycollectService.selectMycollectList(mycollect);
        ExcelUtil<Mycollect> util = new ExcelUtil<Mycollect>(Mycollect.class);
        util.exportExcel(response, list, "我的收藏数据");
    }

    /**
     * 获取我的收藏详细信息
     */
    @PreAuthorize("@ss.hasPermi('consumer:mycollect:query')")
    @GetMapping(value = "/{mycollectId}")
    public AjaxResult getInfo(@PathVariable("mycollectId") Long mycollectId)
    {
        return AjaxResult.success(mycollectService.selectMycollectByMycollectId(mycollectId));
    }

    /**
     * 新增我的收藏
     */
    @PreAuthorize("@ss.hasPermi('consumer:mycollect:add')")
    @Log(title = "我的收藏", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Mycollect mycollect)
    {
        return toAjax(mycollectService.insertMycollect(mycollect));
    }

    /**
     * 修改我的收藏
     */
    @PreAuthorize("@ss.hasPermi('consumer:mycollect:edit')")
    @Log(title = "我的收藏", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Mycollect mycollect)
    {
        return toAjax(mycollectService.updateMycollect(mycollect));
    }

    /**
     * 删除我的收藏
     */
    @PreAuthorize("@ss.hasPermi('consumer:mycollect:remove')")
    @Log(title = "我的收藏", businessType = BusinessType.DELETE)
	@DeleteMapping("/{mycollectIds}")
    public AjaxResult remove(@PathVariable Long[] mycollectIds)
    {
        return toAjax(mycollectService.deleteMycollectByMycollectIds(mycollectIds));
    }
}
