package kz.karyakin.employeeservice.util;

public enum MessageCode {

    EMPLOYEE_DOES_NOT_EXISTS(1, "Employee does not exist");

    int errorCode;
    private String defaultMessage;

    MessageCode(int code, String defaultMessage){
        this.errorCode = code;
        this.defaultMessage = defaultMessage;
    }

    public String getDefaultMessage() {
        return defaultMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
