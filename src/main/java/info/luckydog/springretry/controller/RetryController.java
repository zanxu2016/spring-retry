package info.luckydog.springretry.controller;

import info.luckydog.springretry.model.RetryRes;
import info.luckydog.springretry.service.RetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * RetryController
 *
 * @author eric
 * @since 2019/12/3
 */
@RestController
@Slf4j
public class RetryController {

    @Autowired
    private RetryService retryService;

    @RequestMapping("retry")
    public RetryRes getRetryRes(@RequestParam("token") String token) {
        String appId = "abc456";
        return retryService.getRetryRes(appId, token);
    }
}
