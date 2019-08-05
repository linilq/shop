package linilq.shop.bean.database;

import lombok.Data;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author lizhijian
 * @description 基础数据库bean
 * @date 2019/7/2
 */
@Data
public class BaseEntity implements Serializable {

    private String id;
    private String createBy;
    private String updateBy;
    private Date createTime;
    private Date updateTime;
    private Integer isDelete;


}
