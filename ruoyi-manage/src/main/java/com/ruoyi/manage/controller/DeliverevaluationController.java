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
import com.ruoyi.manage.domain.Deliverevaluation;
import com.ruoyi.manage.service.IDeliverevaluationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 系统物流评价Controller
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
@RestController
@RequestMapping("/manage/deliverevaluation")
public class DeliverevaluationController extends BaseController
{
    @Autowired
    private IDeliverevaluationService deliverevaluationService;

    /**
     * 查询系统物流评价列表
     */
    @PreAuthorize("@ss.hasPermi('manage:deliverevaluation:list')")
    @GetMapping("/list")
    public TableDataInfo list(Deliverevaluation deliverevaluation)
    {
        startPage();
        List<Deliverevaluation> list = deliverevaluationService.selectDeliverevaluationList(deliverevaluation);
        return getDataTable(list);
    }

    /**
     * 导出系统物流评价列表
     */
    @PreAuthorize("@ss.hasPermi('manage:deliverevaluation:export')")
    @Log(title = "系统物流评价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Deliverevaluation deliverevaluation)
    {
        List<Deliverevaluation> list = deliverevaluationService.selectDeliverevaluationList(deliverevaluation);
        ExcelUtil<Deliverevaluation> util = new ExcelUtil<Deliverevaluation>(Deliverevaluation.class);
        util.exportExcel(response, list, "系统物流评价数据");
    }

    /**
     * 获取系统物流评价详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:deliverevaluation:query')")
    @GetMapping(value = "/{logisticsEvaluationId2}")
    public AjaxResult getInfo(@PathVariable("logisticsEvaluationId2") Long logisticsEvaluationId2)
    {
        return AjaxResult.success(deliverevaluationService.selectDeliverevaluationByLogisticsEvaluationId2(logisticsEvaluationId2));
    }

    /**
     * 新增系统物流评价
     */
    @PreAuthorize("@ss.hasPermi('manage:deliverevaluation:add')")
    @Log(title = "系统物流评价", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Deliverevaluation deliverevaluation)
    {
        return toAjax(deliverevaluationService.insertDeliverevaluation(deliverevaluation));
    }

    /**
     * 修改系统物流评价
     */
    @PreAuthorize("@ss.hasPermi('manage:deliverevaluation:edit')")
    @Log(title = "系统物流评价", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Deliverevaluation deliverevaluation)
    {
        return toAjax(deliverevaluationService.updateDeliverevaluation(deliverevaluation));
    }

    /**
     * 删除系统物流评价
     */
    @PreAuthorize("@ss.hasPermi('manage:deliverevaluation:remove')")
    @Log(title = "系统物流评价", businessType = BusinessType.DELETE)
	@DeleteMapping("/{logisticsEvaluationId2s}")
    public AjaxResult remove(@PathVariable Long[] logisticsEvaluationId2s)
    {
        return toAjax(deliverevaluationService.deleteDeliverevaluationByLogisticsEvaluationId2s(logisticsEvaluationId2s));
    }
}
