package com.example.seed.support.mybatis.typeHandler;

import com.example.seed.model.constant.UserInfoStatusEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/4/16 11:47
 */
public class StatusEnumTypeHandler extends BaseTypeHandler<UserInfoStatusEnum> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, UserInfoStatusEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, parameter.getStatus().toString());
    }

    @Override
    public UserInfoStatusEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int code = rs.getInt(columnName);
        return UserInfoStatusEnum.getEnumByCode(code);
    }

    @Override
    public UserInfoStatusEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int code = rs.getInt(columnIndex);
        return UserInfoStatusEnum.getEnumByCode(code);
    }

    @Override
    public UserInfoStatusEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int code = cs.getInt(columnIndex);
        return UserInfoStatusEnum.getEnumByCode(code);
    }
}
