package linilq.shop.service;


/**
 * @author lizhijian
 * @description
 * @date 2019/5/21
 */
public interface BaseService<T> {

    T selectById(String id);
}
