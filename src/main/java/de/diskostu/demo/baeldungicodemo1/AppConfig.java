package de.diskostu.demo.baeldungicodemo1;

import de.diskostu.demo.model.Item;
import de.diskostu.demo.model.ItemImpl1;
import de.diskostu.demo.model.Store;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>The {@link Configuration} annotation is used to mark a class as a source of bean definitions. Multiple
 * configuration classes are possible.</p>
 * <p>If we want to have beans in the context which are not declared in this package hierarchy, we have to mention
 * these other packages via {@link ComponentScan}.</p>
 */
@Configuration
@ComponentScan("de.diskostu.demo.otherpackage")
public class AppConfig {

    /**
     * We use the {@link Bean} annotation on a method to define a bean. If we don't specify a custom name, then the bean
     * name will default to the method name.
     */
    @Bean
    public Item item1() {
        return new ItemImpl1(AppConfig.class.getSimpleName() + " / item1");
    }


    /**
     * Here, we have two beans of type {@link Item}.
     */
    @Bean
    public Item item2() {
        return new ItemImpl1(AppConfig.class.getSimpleName() + " / item2");
    }


    /**
     * Here, we use a custom name for the bean.
     */
    @Bean(name = "itemNumberThree")
    public Item item3() {
        return new ItemImpl1(AppConfig.class.getSimpleName() + " / item3");
    }


    @Bean
    public Store store() {
        return new Store(item1());
    }
}
