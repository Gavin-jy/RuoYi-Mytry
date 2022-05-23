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
import com.ruoyi.consumer.domain.Custevaluation;
import com.ruoyi.consumer.service.ICustevaluationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 我的评价Controller
 * 
 * @author ruoyi
 * @date 2021-12-30
 */
@RestController
@RequestMapping("/consumer/custevaluation")
public class CustevaluationController extends BaseController
{
    @Autowired
    private ICustevaluationService custevaluationService;

    /**
     * 查询我的评价列表
     */
    @PreAuthorize("@ss.hasPermi('consumer:custevaluation:list')")
    @GetMapping("/list")
    public TableDataInfo list(Custevaluation custevaluation)
    {
        startPage();
        List<Custevaluation> list = custevaluationService.selectCustevaluationList(custevaluation);
        return getDataTable(list);
    }

    /**
     * 导出我的评价列表
     */
    @PreAuthorize("@ss.hasPermi('consumer:custevaluation:export')")
    @Log(title = "我的评价", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Custevaluation custevaluation)
    {
        List<Custevaluation> list = custevaluationService.selectCustevaluationList(custevaluation);
        ExcelUtil<Custevaluation> util = new ExcelUtil<Custevaluation>(Custevaluation.class);
        util.exportExcel(response, list, "我的评价数据");
    }

    /**
     * 获取我的评价详细信息
     */
    @PreAuthorize("@ss.hasPermi('consumer:custevaluation:query')")
    @GetMapping(value = "/{custEvaluationId2}")
    public AjaxResult getInfo(@PathVariable("custEvaluationId2") Long custEvaluationId2)
    {
        return AjaxResult.success(custevaluationService.selectCustevaluationByCustEvaluationId2(custEvaluationId2));
    }

    /**
     * 新增我的评价
     */
    @PreAuthorize("@ss.hasPermi('consumer:custevaluation:add')")
    @Log(title = "我的评价", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Custevaluation custevaluation)
    {
        return toAjax(custevaluationService.insertCustevaluation(custevaluation));
    }

    /**
     * 修改我的评价
     */
    @PreAuthorize("@ss.hasPermi('consumer:custevaluation:edit')")
    @Log(title = "我的评价", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Custevaluation custevaluation)
    {
        return toAjax(custevaluationService.updateCustevaluation(custevaluation));
    }

    /**
     * 删除我的评价
     */
    @PreAuthorize("@ss.hasPermi('consumer:custevaluation:remove')")
    @Log(title = "我的评价", businessType = BusinessType.DELETE)
	@DeleteMapping("/{custEvaluationId2s}")
    public AjaxResult remove(@PathVariable Long[] custEvaluationId2s)
    {
        return toAjax(custevaluationService.deleteCustevaluationByCustEvaluationId2s(custEvaluationId2s));
    }
}
