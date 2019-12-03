package info.luckydog.springretry.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * User
 *
 * @author eric
 * @since 2019/12/2
 */
@Data
@AllArgsConstructor
public class User {
    private long id;
    private String name;
}
