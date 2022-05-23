package com.ruoyi.manage.controller;

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
import com.ruoyi.manage.domain.Deliver;
import com.ruoyi.manage.service.IDeliverService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物流公司Controller
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
@RestController
@RequestMapping("/manage/deliver")
public class DeliverController extends BaseController
{
    @Autowired
    private IDeliverService deliverService;

    /**
     * 查询物流公司列表
     */
    @PreAuthorize("@ss.hasPermi('manage:deliver:list')")
    @GetMapping("/list")
    public TableDataInfo list(Deliver deliver)
    {
        startPage();
        List<Deliver> list = deliverService.selectDeliverList(deliver);
        return getDataTable(list);
    }

    /**
     * 导出物流公司列表
     */
    @PreAuthorize("@ss.hasPermi('manage:deliver:export')")
    @Log(title = "物流公司", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Deliver deliver)
    {
        List<Deliver> list = deliverService.selectDeliverList(deliver);
        ExcelUtil<Deliver> util = new ExcelUtil<Deliver>(Deliver.class);
        util.exportExcel(response, list, "物流公司数据");
    }

    /**
     * 获取物流公司详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:deliver:query')")
    @GetMapping(value = "/{deliverId}")
    public AjaxResult getInfo(@PathVariable("deliverId") Long deliverId)
    {
        return AjaxResult.success(deliverService.selectDeliverByDeliverId(deliverId));
    }

    /**
     * 新增物流公司
     */
    @PreAuthorize("@ss.hasPermi('manage:deliver:add')")
    @Log(title = "物流公司", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Deliver deliver)
    {
        return toAjax(deliverService.insertDeliver(deliver));
    }

    /**
     * 修改物流公司
     */
    @PreAuthorize("@ss.hasPermi('manage:deliver:edit')")
    @Log(title = "物流公司", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Deliver deliver)
    {
        return toAjax(deliverService.updateDeliver(deliver));
    }

    /**
     * 删除物流公司
     */
    @PreAuthorize("@ss.hasPermi('manage:deliver:remove')")
    @Log(title = "物流公司", businessType = BusinessType.DELETE)
	@DeleteMapping("/{deliverIds}")
    public AjaxResult remove(@PathVariable Long[] deliverIds)
    {
        return toAjax(deliverService.deleteDeliverByDeliverIds(deliverIds));
    }
}
