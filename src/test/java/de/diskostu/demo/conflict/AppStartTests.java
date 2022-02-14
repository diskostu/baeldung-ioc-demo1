package de.diskostu.demo.conflict;

import de.diskostu.demo.model.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Configuration;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * <p>Per default, when executing a test, Spring builds its context via the {@link Configuration}-classes from
 * {@code src/main/java}. If your test is in the same package as the class which is annotated with
 * {@link SpringBootApplication}, the config is found automatically. Otherwise, we have to define our config via
 * the {@link SpringBootTest} annotation.</p>
 *
 * <p>If we want to use an additional Spring config class for testing, we have to define it in {@code src/test/java} and
 * annotate it with {@link TestConfiguration}. Then, we have to explicitly name this config class here in the test.</p>
 *
 * <p>Using <strong>only</strong> a {@link TestConfiguration} class does not work, we need at least 1
 * {@link Configuration} class.</p>
 *
 * <p>But, there can problems if we have two beans with the same type and same name; one in the {@link Configuration}
 * class, another in the {@link TestConfiguration} class. Spring is not able to build the context, because the type
 * is ambigous.</p>
 *
 * <p>I we don't want to activate overrinding, we need to rename one of the conflicting beans to resolve the
 * conflict. Therefore, I renamed the method {@code item1()} in {@link TestConflictConfig} to
 * {@code testItem1()}. Now, the autowired bean {@code item1} can be properly resolved. I also added a second
 * autowired field for the test bean.</p>
 */
@SpringBootTest(classes = {ConflictConfig.class, TestConflictConfig.class})
class AppStartTests {

    @Autowired
    private Item item1;

    @Autowired
    private Item testItem1;


    @Test
    void contextLoads() {
        assertThat(item1).isNotNull();

        System.out.println("item1.getItemName = " + item1.getItemName());
        System.out.println("testItem1.getItemName = " + testItem1.getItemName());
    }
}
