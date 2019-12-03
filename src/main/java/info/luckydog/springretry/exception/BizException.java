package info.luckydog.springretry.exception;

import lombok.Data;

/**
 * BizException
 *
 * @author eric
 * @since 2019/12/2
 */
@Data
public class BizException extends RuntimeException {

    private String msg;

    public BizException(String msg) {
        super(msg);
    }
}
