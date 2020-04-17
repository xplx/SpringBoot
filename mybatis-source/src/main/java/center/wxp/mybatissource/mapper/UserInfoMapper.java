package center.wxp.mybatissource.mapper;

import center.wxp.mybatissource.mode.UserInfoVo;

import java.util.List;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/4/16 16:20
 */
public interface UserInfoMapper {
    UserInfoVo getById(Integer id);

    List<UserInfoVo> getAll();
}
