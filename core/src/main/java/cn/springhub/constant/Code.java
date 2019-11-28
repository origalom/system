package cn.springhub.constant;

/**
 *  系统使用的编码
 * @author  A.I.
 * @date   2019/11/25 11:20
 * @version   1.0
 **/
public enum Code implements Constant<Integer> {

    OK(0, "请求正常")
    , ERROR(-1, "系统中未捕获的异常")

    , PARMAS_TYPE_ERROR(1000, "参数格式有误")
    , PARAMS_ASSERT_ERROR(1001, "参数认证失败")

    ;

    private Integer code;

    private String desc;

    Code(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public Integer getValue() {
        return code;
    }

    @Override
    public String getDescription() {
        return desc;
    }
}
