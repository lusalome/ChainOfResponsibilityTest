package chainpattern;

import errorcode.ApiErrorCode;

import java.util.ArrayList;

/**
 * 场景：责任链模式完成用户认证
 *
 * @author wanglu  lusalome@163.com
 * @version 2017-09-20 9:31
 */
public class CheckHandlerChain implements CheckHandler {

    //成员变量ArrayList里面储存的是所有被注册进来的具体处理者对象。
    private ArrayList<CheckHandler> workList = new ArrayList<CheckHandler>();

    //定义一个计数器，用来辅助调用下一个处理者
    int index = 0;

    public ApiErrorCode execute(CheckHandlerChain chain) {
        //当计数器大于或等于具体处理者列表，直接返回，防止下标越界。
        if (index >= workList.size()) return ApiErrorCode.SUCCESS;

        //没有越界，则从列表中拿出当前的具体处理者。
        CheckHandler work = workList.get(index);

        //下标字增加
        index++;

        //具体处理者具体调用处理方法，传入该责任链对象
        return work.execute(chain);

    }

    //注册具体处理者到责任链的方法。
    public CheckHandlerChain setWork(CheckHandler work) {
        workList.add(work);
        return this;
    }
}