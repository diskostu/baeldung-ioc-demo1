package de.diskostu.demo.baeldungicodemo1;

import de.diskostu.demo.model.Item;
import de.diskostu.demo.model.ItemImpl1;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestAppConfig {

    @Bean
    public Item testItem2() {
        return new ItemImpl1(TestAppConfig.class.getSimpleName() + " / item2");
    }
}
