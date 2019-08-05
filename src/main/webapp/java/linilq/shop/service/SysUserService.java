package linilq.shop.service;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import linilq.shop.bean.database.SysUser;

public interface SysUserService extends BaseService<SysUser> {

    SysUser selectOne(QueryWrapper<SysUser> wrapper);
}
