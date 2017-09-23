package errorcode;

/**
 * 错误码
 *
 * @author wanglu  lusalome@163.com
 * @version 2017-09-20 9:54
 */
public enum CommonResCode {

    SUCCESS("000"), // 成功
    INVALID_PARAM("101"), // 参数错误
    SYS_ERROR("999"), // 系统异常
    USER_NOT_IN_PRODUCT_GROUP("201"),//用户不在人组中
    USER_NOT_LOGIN("202"),//用户未登陆
    USER_NOT_NAME_AUTH("203"),//用户未实名
    USER_NOT_BIND_CARD("204"),//用户未绑卡
    ;

    private String code;

    public String getCode() {
        return code;
    }

    CommonResCode(String code) {
        this.code = code;
    }
}
