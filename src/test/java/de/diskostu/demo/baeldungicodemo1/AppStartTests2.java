package de.diskostu.demo.baeldungicodemo1;

import de.diskostu.demo.model.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Configuration;

@SpringBootTest(classes = TestAppConfig.class)
class AppStartTests2 {

    @Autowired
    private Item item1;

    @Autowired
    private Item item2;

    @Autowired
    private Item testItem2;


    @Test
    void contextLoads() {
        Assertions.assertThat(item1).isNotNull();

        System.out.println("item1.getItemName() = " + item1.getItemName());
        System.out.println("item2.getItemName() = " + item2.getItemName());
        System.out.println("testItem2.getItemName() = " + testItem2.getItemName());
    }
}
