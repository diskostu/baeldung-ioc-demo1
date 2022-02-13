package de.diskostu.demo.baeldungicodemo1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AppStartTests {

    @Autowired
    private Store store;


    @Test
    void contextLoads() {
        assertThat(store.getItem()).isNotNull();
    }
}
