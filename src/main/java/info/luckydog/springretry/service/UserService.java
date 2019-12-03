package info.luckydog.springretry.service;

import info.luckydog.springretry.model.User;

/**
 * RetryService
 *
 * @author eric
 * @since 2019/12/2
 */
public interface UserService {

    User getUser(String token);
}
