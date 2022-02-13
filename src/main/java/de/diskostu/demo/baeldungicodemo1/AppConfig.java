package de.diskostu.demo.baeldungicodemo1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * The {@link Configuration} annotation is used to mark a class as a source of bean definitions. Multiple
 * configuration classes are possible.
 */
@Configuration
public class AppConfig {

    /**
     * We use the {@link Bean} annotation on a method to define a bean. If we don't specify a custom name, then the bean
     * name will default to the method name.
     */
    @Bean
    public Item item() {
        return new ItemImpl1();
    }


    @Bean
    public Store store() {
        return new Store(item());
    }
}
