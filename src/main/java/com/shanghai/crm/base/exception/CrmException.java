package com.shanghai.crm.base.exception;

import com.shanghai.crm.base.constants.CrmExceptionEnum;

public class CrmException extends RuntimeException {

    private CrmExceptionEnum exceptionEnum;

    public CrmException(CrmExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMess());
        this.exceptionEnum = exceptionEnum;
    }

    public CrmExceptionEnum getExceptionEnum() {
        return exceptionEnum;
    }

    public void setExceptionEnum(CrmExceptionEnum exceptionEnum) {
        this.exceptionEnum = exceptionEnum;
    }
}
