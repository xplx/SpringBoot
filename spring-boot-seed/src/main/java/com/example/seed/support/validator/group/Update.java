package com.example.seed.support.validator.group;

import javax.validation.groups.Default;

/**
 * 需要继承Default，不然不会验证没有添加的分组
 * @author liguoping@itonghui.org
 * @ClassName: Update
 * @Description: 修改校验组
 * @date 2016-5-12 上午9:50:41
 */
public interface Update extends Default {

}
