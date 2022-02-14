package de.diskostu.demo.baeldungicodemo1;

import de.diskostu.demo.model.Item;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Configuration;

/**
 * <p>Per default, when executing a test, Spring builds its context via the {@link Configuration}-classes from
 * {@code src/main/java}.</p>
 *
 * <p>If we want to use an additional Spring config class for testing, we have to define it in {@code src/test/java} and
 * annotate it with {@link TestConfiguration}. Then, we have to explicitly name this config class here in the test.</p>
 *
 * <p>But, there can problems if we have two beans with the same type and same name; one in the {@link Configuration}
 * -class, another in the {@link TestConfiguration}-class. Spring is not able to build the context and says: "The
 * bean 'item2', defined in de.diskostu.demo.baeldungicodemo1.TestAppConfig, could not be registered. A bean with
 * that name has already been defined in class path resource [de/diskostu/demo/baeldungicodemo1/AppConfig.class] and
 * overriding is disabled."</p>
 *
 * <p>I we don't want to activate overrinding, we need to rename one of the conflicting beans to resolve the conflict
 * . Therefore, I renamed the method {@code item2()} in {@link TestAppConfig} to {@code testItem2()}</p>. Now, the
 * beans can be properly resolved.
 */
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
