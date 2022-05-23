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
import com.ruoyi.manage.domain.Businessevaluation;
import com.ruoyi.manage.service.IBusinessevaluationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 系统商家评价Controller
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
@RestController
@RequestMapping("/manage/businessevaluation")
public class BusinessevaluationController extends BaseController
{
    @Autowired
    private IBusinessevaluationService businessevaluationService;

    /**
     * 查询系统商家评价列表
     */
    @PreAuthorize("@ss.hasPermi('manage:businessevaluation:list')")
    @GetMapping("/list")
    public TableDataInfo list(Businessevaluation businessevaluation)
    {
        startPage();
        List<Businessevaluation> list = businessevaluationService.selectBusinessevaluationList(businessevaluation);
        return getDataTable(list);
    }

    /**
     * 导出系统商家评价列表
     */
    @PreAuthorize("@ss.hasPermi('manage:businessevaluation:export')")
    @Log(title = "系统商家评价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Businessevaluation businessevaluation)
    {
        List<Businessevaluation> list = businessevaluationService.selectBusinessevaluationList(businessevaluation);
        ExcelUtil<Businessevaluation> util = new ExcelUtil<Businessevaluation>(Businessevaluation.class);
        util.exportExcel(response, list, "系统商家评价数据");
    }

    /**
     * 获取系统商家评价详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:businessevaluation:query')")
    @GetMapping(value = "/{businessEvaluationId2}")
    public AjaxResult getInfo(@PathVariable("businessEvaluationId2") Long businessEvaluationId2)
    {
        return AjaxResult.success(businessevaluationService.selectBusinessevaluationByBusinessEvaluationId2(businessEvaluationId2));
    }

    /**
     * 新增系统商家评价
     */
    @PreAuthorize("@ss.hasPermi('manage:businessevaluation:add')")
    @Log(title = "系统商家评价", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Businessevaluation businessevaluation)
    {
        return toAjax(businessevaluationService.insertBusinessevaluation(businessevaluation));
    }

    /**
     * 修改系统商家评价
     */
    @PreAuthorize("@ss.hasPermi('manage:businessevaluation:edit')")
    @Log(title = "系统商家评价", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Businessevaluation businessevaluation)
    {
        return toAjax(businessevaluationService.updateBusinessevaluation(businessevaluation));
    }

    /**
     * 删除系统商家评价
     */
    @PreAuthorize("@ss.hasPermi('manage:businessevaluation:remove')")
    @Log(title = "系统商家评价", businessType = BusinessType.DELETE)
	@DeleteMapping("/{businessEvaluationId2s}")
    public AjaxResult remove(@PathVariable Long[] businessEvaluationId2s)
    {
        return toAjax(businessevaluationService.deleteBusinessevaluationByBusinessEvaluationId2s(businessEvaluationId2s));
    }
}
