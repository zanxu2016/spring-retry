package info.luckydog.springretry.service.impl;

import info.luckydog.springretry.annotation.Retry;
import info.luckydog.springretry.model.RetryRes;
import info.luckydog.springretry.service.RetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * RetryServiceImpl
 *
 * @author eric
 * @since 2019/12/3
 */
@Service
@Slf4j
public class RetryServiceImpl implements RetryService {

    /*
    1、传入[参数]，调用方法
    2、获得结果
    3、[解析结果]-若code为指定值，则刷新[参数]
    4、重试
     */
    @Retry(name = "invalid_token", times = 2)
    @Override
    public RetryRes getRetryRes(String appId, String token) {
        log.info("getRetryRes, appId: {}, token: {}", appId, token);
        RetryRes res = new RetryRes();
        if (StringUtils.hasText(token)) {
            res.setCode(0);
            res.setMsg("success");
        } else {
            res.setCode(1);
            res.setMsg("invalid token");
        }
        return res;
    }

    @Override
    public String getToken(String appId) {
        log.info("getToken, appId: {}", appId);
        return "123";
    }
}
