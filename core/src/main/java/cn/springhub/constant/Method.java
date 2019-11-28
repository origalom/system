package cn.springhub.constant;

/**
 *  http请求方法
 * @author  A.I.
 * @date   2019/11/28 16:20
 * @version   1.0
 **/
public enum Method implements Constant<String> {

    GET("GET")
    , POST("POST")
    , PUT("PUT")
    , DELETE("DELETE", "删除请求URI指定的资源")
    , HEAD("HEAD", "不需要服务器在响应里返回消息主体, 被用来测试超文本链接的有效性，可访问性，和最近的改变")
    , TRACE("TRACE", "激发一个远程的应用层的请求消息回路")
    , OPTIONS("OPTIONS", "对一个已有的request/response chain，请求URI指定资源的选项信息")
    , CONNECT("CONNECT", "用于能动态切换到隧道的代理服务器（proxy）")
    ;

    private String method;

    private String desc;

    Method(String method) {
        this.method = method;
    }

    Method(String method, String desc) {
        this.method = method;
        this.desc = desc;
    }

    @Override
    public String getValue() {
        return this.method;
    }

    @Override
    public String getDescription() {
        return desc;
    }
}
