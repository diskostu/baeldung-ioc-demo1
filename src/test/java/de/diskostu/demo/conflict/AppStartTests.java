package de.diskostu.demo.conflict;

import de.diskostu.demo.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AppStartTests {

    @Autowired
    private Item item1;


    @Test
    void contextLoads() {
        assertThat(item1).isNotNull();

        System.out.println("item1.getItemName = " + item1.getItemName());
    }
}
