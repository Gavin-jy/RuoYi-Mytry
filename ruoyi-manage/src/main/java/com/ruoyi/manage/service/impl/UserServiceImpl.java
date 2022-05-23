package com.ruoyi.manage.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.UserMapper;
import com.ruoyi.manage.domain.User;
import com.ruoyi.manage.service.IUserService;

/**
 * 用户 Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-12-29
 */
@Service
public class UserServiceImpl implements IUserService 
{
    @Autowired
    private UserMapper userMapper;

    /**
     * 查询用户 
     * 
     * @param userId 用户 主键
     * @return 用户 
     */
    @Override
    public User selectUserByUserId(String userId)
    {
        return userMapper.selectUserByUserId(userId);
    }

    /**
     * 查询用户 列表
     * 
     * @param user 用户 
     * @return 用户 
     */
    @Override
    public List<User> selectUserList(User user)
    {
        return userMapper.selectUserList(user);
    }

    /**
     * 新增用户 
     * 
     * @param user 用户 
     * @return 结果
     */
    @Override
    public int insertUser(User user)
    {
        return userMapper.insertUser(user);
    }

    /**
     * 修改用户 
     * 
     * @param user 用户 
     * @return 结果
     */
    @Override
    public int updateUser(User user)
    {
        user.setUpdateTime(DateUtils.getNowDate());
        return userMapper.updateUser(user);
    }

    /**
     * 批量删除用户 
     * 
     * @param userIds 需要删除的用户 主键
     * @return 结果
     */
    @Override
    public int deleteUserByUserIds(String[] userIds)
    {
        return userMapper.deleteUserByUserIds(userIds);
    }

    /**
     * 删除用户 信息
     * 
     * @param userId 用户 主键
     * @return 结果
     */
    @Override
    public int deleteUserByUserId(String userId)
    {
        return userMapper.deleteUserByUserId(userId);
    }
}
