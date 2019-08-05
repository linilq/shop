package linilq.shop.bean.database;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author lizhijian
 * @description 系统用户
 * @date 2019/7/2
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysUser extends BaseEntity {
    private String userName;
    private String passWord;
    private String realName;
    private String salt;
    private Integer lockState;

}
