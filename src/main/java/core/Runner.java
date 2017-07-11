package core;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.reporters.StoryReporterBuilder.Format;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;
import steps.Example;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

/**
 * Created by mdd_1 on 26/7/2017.
 */
    public class Runner extends JUnitStory {

        @Override
        public Configuration configuration() {
            URL storyURL = null;
            try {
                // This requires you to start Maven from the project directory
                //on Mac or Linux:
                storyURL = new URL("file://" + "/Users/marcelodiaz/Documents/w/JBehaveOK/src/main/stories");
                //on Windows:
                //storyURL = new URL("file://" + "C:\\w\\FunctTest\\src\\main\\stories");
                //+ System.getProperty("user.dir")

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            return new MostUsefulConfiguration().useStoryLoader(
                    new LoadFromRelativeFile(storyURL)).useStoryReporterBuilder(
                    new StoryReporterBuilder().withFormats(Format.HTML));
        }

        @Override
        public List<CandidateSteps> candidateSteps() {
            return new InstanceStepsFactory(configuration(), new Example())
                    .createCandidateSteps();
        }

        @Override
        @Test
        public void run() {
            try {
                super.run();
            } catch (Throwable e) {
                e.printStackTrace();
            }
        }
    }
