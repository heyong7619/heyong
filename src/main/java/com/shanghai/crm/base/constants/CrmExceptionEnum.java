package com.shanghai.crm.base.constants;

public enum CrmExceptionEnum {
    LOGIN_ACCOUNT_ERROR("001","用户名或密码错误"),
    LOGIN_EXPIRE_EXCEPTION("001", "用户失效"),
    LOGIN_LOCK_EXCEPTION("001", "用户锁定"),
    LOGIN_IP_EXCEPTION("001", "ip地址不合法");

    private String code;

    private String mess;

    CrmExceptionEnum(String code, String mess) {
        this.code = code;
        this.mess = mess;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }
}
