package chainpattern;

import errorcode.ApiErrorCode;

/**
 * 场景：责任链模式完成用户认证
 *
 * @author wanglu  lusalome@163.com
 * @version 2017-09-20 9:28
 */
public interface CheckHandler {

    ApiErrorCode execute(CheckHandlerChain chain);
}
