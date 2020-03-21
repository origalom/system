package cn.springhub.constant;

/**
 *  状态
 * @author  A.I.
 * @date   2020/2/1 17:03
 * @version   1.0
 **/
public enum Status implements Constant<Integer> {

    OK(0, "正常")
    ;

    private int code;

    private String description;

    Status(int code, String description) {
        this.code = code;
        this.description = description;
    }

    @Override
    public Integer getValue() {
        return null;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
