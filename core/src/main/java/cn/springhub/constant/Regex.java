package cn.springhub.constant;

/**
 *  正则表达式
 * @author A.I.
 * @createAt 2019/11/30 16:17
**/
public enum Regex implements Constant<String> {
    POSITIVE_INTEGER("//d+", "正整数")
    ;

    private String regex;

    private String msg;

    Regex(String regex) {
        this.regex = regex;
    }

    Regex(String regex, String msg) {
        this.regex = regex;
        this.msg = msg;
    }

    @Override
    public String getValue() {
        return this.regex;
    }

    @Override
    public String getDescription() {
        return this.msg;
    }
}
