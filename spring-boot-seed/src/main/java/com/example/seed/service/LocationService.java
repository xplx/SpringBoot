package com.example.seed.service;

import com.example.seed.model.entity.Location;
import tk.mybatis.template.core.Service;


/**
 * @author wuxiaopeng
 * @date 2020/06/11
 */
public interface LocationService extends Service<Location> {
    /**
     *保存本地信息
     * @param location
     */

    void saveLocation(Location location);

    /**
     * 保存本地信息
     * @param location
     */
    void saveLocationException(Location location);

    /**
     * 测试事物传播属性
     */
    void saveLocationPropagation();

}
