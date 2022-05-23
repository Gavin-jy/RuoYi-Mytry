package com.ruoyi.consumer.service;

import java.util.List;
import com.ruoyi.consumer.domain.Aftersale;

/**
 * 我的售后Service接口
 * 
 * @author ruoyi
 * @date 2021-12-30
 */
public interface IAftersaleService 
{
    /**
     * 查询我的售后
     * 
     * @param aftersaleId 我的售后主键
     * @return 我的售后
     */
    public Aftersale selectAftersaleByAftersaleId(Long aftersaleId);

    /**
     * 查询我的售后列表
     * 
     * @param aftersale 我的售后
     * @return 我的售后集合
     */
    public List<Aftersale> selectAftersaleList(Aftersale aftersale);

    /**
     * 新增我的售后
     * 
     * @param aftersale 我的售后
     * @return 结果
     */
    public int insertAftersale(Aftersale aftersale);

    /**
     * 修改我的售后
     * 
     * @param aftersale 我的售后
     * @return 结果
     */
    public int updateAftersale(Aftersale aftersale);

    /**
     * 批量删除我的售后
     * 
     * @param aftersaleIds 需要删除的我的售后主键集合
     * @return 结果
     */
    public int deleteAftersaleByAftersaleIds(Long[] aftersaleIds);

    /**
     * 删除我的售后信息
     * 
     * @param aftersaleId 我的售后主键
     * @return 结果
     */
    public int deleteAftersaleByAftersaleId(Long aftersaleId);
}
