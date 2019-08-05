package linilq.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import linilq.shop.bean.database.SysUser;
import linilq.shop.dao.SysUserMapper;
import linilq.shop.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lizhijian
 * @description
 * @date 2019/5/21
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public SysUser selectById(String id) {
        return sysUserMapper.selectById(id);
    }

    @Override
    public SysUser selectOne(QueryWrapper<SysUser> wrapper) {
        return sysUserMapper.selectOne(wrapper);
    }
}
