package com.ruoyi.manage.mapper;

import java.util.List;
import com.ruoyi.manage.domain.User;

/**
 * 用户 Mapper接口
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
public interface UserMapper 
{
    /**
     * 查询用户 
     * 
     * @param userId 用户 主键
     * @return 用户 
     */
    public User selectUserByUserId(String userId);

    /**
     * 查询用户 列表
     * 
     * @param user 用户 
     * @return 用户 集合
     */
    public List<User> selectUserList(User user);

    /**
     * 新增用户 
     * 
     * @param user 用户 
     * @return 结果
     */
    public int insertUser(User user);

    /**
     * 修改用户 
     * 
     * @param user 用户 
     * @return 结果
     */
    public int updateUser(User user);

    /**
     * 删除用户 
     * 
     * @param userId 用户 主键
     * @return 结果
     */
    public int deleteUserByUserId(String userId);

    /**
     * 批量删除用户 
     * 
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserByUserIds(String[] userIds);
}
