import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;
import steps.Example;

import java.util.List;
import java.util.Arrays;

/**
 * Created by mdd_1 on 25/7/2017.
 */
public class JBehaveRunner extends JUnitStories {
        public JBehaveRunner() {
            super();
        }

        @Override
        public InjectableStepsFactory stepsFactory() {
            return new InstanceStepsFactory( configuration(),
                    new Example() );
        }

        @Override
        protected List<String> storyPaths() {

            return Arrays.asList( "/Users/marcelodiaz/Documents/w/JBehaveOK/src/main/stories/example.story");
                    //"stories/Original.story");
        }
    }
