package com.example.seed.model.constant;

/**
 * @author wuxiaopeng
 * @description:
 * @date 2020/4/16 10:27
 */
public enum UserInfoStatusEnum {
    /**
     * 未退休
     */
    /**
     * 已退休
     */
    NORETIRE(0, "NORETIRE"),
    RETIRE(1, "RETIRE");

    // 自定义的属性code
    private final Integer status;
    // 自定义的属性msg
    private final String msg;

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * 自定义的构造函数，传入属性
     *
     * @param status
     * @param msg
     */
    private UserInfoStatusEnum(Integer status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    /**
     * 根据code获取枚举对象
     *
     * @param code
     * @return
     */
    public static UserInfoStatusEnum getEnumByCode(Integer code) {
        UserInfoStatusEnum status = null;
        Class<?> clasz = UserInfoStatusEnum.class;
        if (clasz.isEnum()) {
            // 返回该枚举类型的所有元素，如果Class对象不是枚举类型，则返回null。
            UserInfoStatusEnum[] values = (UserInfoStatusEnum[]) clasz.getEnumConstants();
            for (UserInfoStatusEnum statusEnum : values) {
                if (statusEnum.getStatus().equals(code)) {
                    status = statusEnum;
                }
            }
        }
        return status;
    }
}
