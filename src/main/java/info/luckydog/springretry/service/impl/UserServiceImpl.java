package info.luckydog.springretry.service.impl;

import info.luckydog.springretry.exception.BizException;
import info.luckydog.springretry.model.User;
import info.luckydog.springretry.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * UserService
 *
 * @author eric
 * @since 2019/12/2
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    /**
     * 测试重试 @Retryable
     *
     * @param token token
     * @return User
     */
    @Retryable(value = BizException.class, maxAttempts = 2, backoff = @Backoff(delay = 5000, maxDelay = 10000))
    @Override
    public User getUser(String token) {
        log.info("getUser, token:{}", token);
        if (!StringUtils.hasText(token)) {
            log.info("token is empty.");
            throw new BizException("token is empty");
        }
        return new User(1L, "eric");
    }

    /**
     * 重试无果后执行该方法
     *
     * @param e
     * @return
     */
    @Recover
    public User recover(BizException e) {
        log.info("recover, e: {}", e);
        return new User(0L, "default_name");
    }
}
