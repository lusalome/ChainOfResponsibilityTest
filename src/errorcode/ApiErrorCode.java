package errorcode;

/**
 * 错误码
 *
 * @author wanglu  lusalome@163.com
 * @version 2017-09-20 9:49
 */
public enum ApiErrorCode implements ErrorCode {
    SUCCESS(CommonResCode.SUCCESS.getCode(), "成功"),
    INVALID_PARAM(CommonResCode.INVALID_PARAM.getCode(), "参数错误"),
    SYS_ERROR(CommonResCode.SYS_ERROR.getCode(), "系统异常"),
    USER_NOT_IN_PRODUCT_GROUP(CommonResCode.USER_NOT_IN_PRODUCT_GROUP.getCode(), "用户不在人组中"),
    USER_NOT_LOGIN(CommonResCode.USER_NOT_LOGIN.getCode(), "用户未登陆"),
    USER_NOT_NAME_AUTH(CommonResCode.USER_NOT_NAME_AUTH.getCode(), "用户未实名"),
    USER_NOT_BIND_CARD(CommonResCode.USER_NOT_BIND_CARD.getCode(), "用户未绑卡"),
    ;

    private String code;
    private String msg;

    ApiErrorCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getErrMsg() {
        return msg;
    }

    @Override
    public String getErrCode() {
        return code;
    }

    @Override
    public String toString() {
        return "ApiErrorCode{" + this.name() + "," + getErrCode() + ":'" + getErrMsg() + "}";
    }
}