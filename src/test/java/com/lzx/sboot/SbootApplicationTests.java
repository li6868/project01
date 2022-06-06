package com.lzx.sboot;

import com.lzx.sboot.entity.User;
import com.lzx.sboot.entity.User22;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SbootApplicationTests {
    /*@BeforeAll
    void befor(){
        System.out.println("qwe");
    }
    @AfterAll
    void after(){
        System.out.println("zxc");
    }*/
    @Autowired
    private User22 user;
    @Test
    void contextLoads() {
        System.out.println(user);
    }

}
