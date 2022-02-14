package de.diskostu.demo.conflict;

import de.diskostu.demo.model.Item;
import de.diskostu.demo.model.ItemImpl1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConflictConfig {

    @Bean
    public Item item1() {
        return new ItemImpl1(ConflictConfig.class.getSimpleName() + " / item1");
    }
}
