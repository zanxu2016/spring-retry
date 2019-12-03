package info.luckydog.springretry.service;

import info.luckydog.springretry.model.RetryRes;

/**
 * RetryService
 *
 * @author eric
 * @since 2019/12/3
 */
public interface RetryService {

    RetryRes getRetryRes(String appId, String token);

    String getToken(String appId);
}
