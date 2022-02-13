package de.diskostu.demo.baeldungicodemo1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AppStartTests {

    @Autowired
    private Store store;


    /**
     * We need the qualifier, as we have two beans of type {@link Item}. Therefore, we specify the name of the bean
     * method here. This is just one way of doing this.
     */
    @Qualifier("item2")
    @Autowired
    private Item item;

    /**
     * Another way would be to define a custom name for the bean (in the {@link Configuration} class) and use this
     * name here.
     */
    @Qualifier("itemNumberThree")
    @Autowired
    private Item item3;


    @Test
    void contextLoads() {
        assertThat(item).isNotNull();
        assertThat(item3).isNotNull();
        assertThat(store.getItem()).isNotNull();
    }
}
