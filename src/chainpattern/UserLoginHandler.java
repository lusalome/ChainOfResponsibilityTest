package chainpattern;

import errorcode.ApiErrorCode;

/**
 * 场景：责任链模式完成用户认证
 *
 * @author wanglu  lusalome@163.com
 * @version 2017-09-20 9:34
 */
public class UserLoginHandler implements CheckHandler {

    //处理标识符，便于模拟业务逻辑。
    private String handleSwitch;

    private ApiErrorCode errorCode;

    public ApiErrorCode execute(CheckHandlerChain chain) {
        System.out.println("UserLoginHandler is working now......");

        //当标识符为“OFF”，本步骤不处理，直接返回
        if ("OFF".equals(handleSwitch)) {
            System.out.println("UserLoginHandler don't need to handle.");
            return chain.execute(chain);
        }

        // 处理过程
        errorCode = ApiErrorCode.SUCCESS;

        // 如果errorCode = SUCCESS，下发责任
        if (errorCode.getErrCode().equals(ApiErrorCode.SUCCESS.getErrCode())) {
            System.out.println(String.format("UserLoginHandler success. errorCode = [%s].\n", errorCode));
            return chain.execute(chain);
        } else {
            System.out.println(String.format("UserLoginHandler fail. errorCode = [%s].\n", errorCode));
            return errorCode;
        }
    }

    //处理标识符的getter和setter方法。
    public String getHandleSwitch() {
        return handleSwitch;
    }

    public void setHandleSwitch(String handleSwitch) {
        this.handleSwitch = handleSwitch;
    }

    public ApiErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ApiErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
