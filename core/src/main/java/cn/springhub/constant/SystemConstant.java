package cn.springhub.constant;

/**
 *  系统需要用到的常量变量
 * @author  A.I.
 * @date   2019/11/29 15:39
 * @version   1.0
 **/
public enum SystemConstant implements Constant<String> {

    SYSTEM_ASSERT_ERROR
    , COMMA(",", "逗号")
    , COLON(":", "冒号")
    ;

    private String value;

    private String msg;

    SystemConstant() {
    }

    SystemConstant(String value) {
        this.value = value;
    }

    SystemConstant(String value, String msg) {
        this.value = value;
        this.msg = msg;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public String getDescription() {
        return this.msg;
    }
}
