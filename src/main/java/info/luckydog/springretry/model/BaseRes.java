package info.luckydog.springretry.model;

/**
 * BaseRes
 *
 * @author eric
 * @since 2019/12/3
 */
public class BaseRes {

    private int code;
    private String msg;
    private boolean retry;

    public BaseRes() {
    }

    public BaseRes(int code, String msg, boolean retry) {
        this.code = code;
        this.msg = msg;
        this.retry = retry;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
        this.setRetry();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isRetry() {
        return retry;
    }

    private void setRetry() {
        this.retry = this.getCode() == 1;
    }
}
