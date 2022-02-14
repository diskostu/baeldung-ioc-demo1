package de.diskostu.demo.conflict;

import de.diskostu.demo.model.Item;
import de.diskostu.demo.model.ItemImpl1;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class TestConflictConfig {
    @Bean
    public Item item1() {
        return new ItemImpl1(TestConflictConfig.class.getSimpleName() + " / item1");
    }

}
