package chainpattern;

import errorcode.ApiErrorCode;

/**
 * 场景：责任链模式完成用户认证
 *
 * @author wanglu  lusalome@163.com
 * @version 2017-09-20 9:32
 */
public class TestMain {

    public static void main(String[] args) {
        //实例化了四个具体处理对象
        UserLoginHandler userLoginHandler = new UserLoginHandler();
        UserGroupHandler userGroupHandler = new UserGroupHandler();
        UserNameAuthHandler userNameAuthHandler = new UserNameAuthHandler();
        UserCardBindHandler userCardBindHandler = new UserCardBindHandler();

        //仅仅为userNameAuthHandler设置了不需要处理的字段
        //意味着到了userNameAuthHandler对象处理的时候，直接跳过下发到另一个处理者那里了
        userNameAuthHandler.setHandleSwitch("OFF");

        //创建了一个责任链ch1，并以此绑定了具体处理者。
        //因此此责任链的工作顺序也是userLoginHandler->userGroupHandler->userNameAuthHandler
        CheckHandlerChain ch1 = new CheckHandlerChain();
        ch1.setWork(userLoginHandler).setWork(userGroupHandler).setWork(userNameAuthHandler);

        //创建了一个责任链对象ch2，并且绑定了userCardBindHandler为具体处理者
        CheckHandlerChain ch2 = new CheckHandlerChain();
        ch2.setWork(userCardBindHandler);

        //将责任链ch2绑定到ch1责任链的最后，也就是责任链ch1执行后还需要执行ch2的处理者
        ch1.setWork(ch2);

        //从责任链ch1开始执行
        ApiErrorCode result = ch1.execute(ch1);
        System.out.println("\nThe end result:" + result);
    }
}
