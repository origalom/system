package cn.springhub.constant;

/**
 *  系统使用的编码
 * @author  A.I.
 * @date   2019/11/25 11:20
 * @version   1.0
 **/
public enum Code implements Constant<Integer> {

    ;

    private Integer code;

    Code(int code) {
        this.code = code;
    }

    @Override
    public Integer getValue() {
        return code;
    }
}
