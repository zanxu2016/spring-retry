package info.luckydog.springretry.model;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * Demo
 *
 * @author eric
 * @since 2019/12/3
 */
public class Demo {


    @Test
    public void test() throws UnsupportedEncodingException {
        byte[] strByte = null;
        System.out.println(new String(strByte, "utf8"));
    }
}
