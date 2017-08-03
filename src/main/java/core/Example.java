package core;

import java.io.FileInputStream;
import java.net.URL;
import java.util.List;
import java.util.Properties;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.LoadFromRelativeFile;
import org.jbehave.core.junit.JUnitStory;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.reporters.StoryReporterBuilder.Format;
import org.jbehave.core.steps.CandidateSteps;
import org.jbehave.core.steps.InstanceStepsFactory;
import org.junit.Test;

/**
 * Created by mdd_1 on 26/7/2017.
 */
public class Example extends JUnitStory {

    private String[] listOperSystem={"Windows","Mac","Linux"};
    //According to each environment, must be set 0=Win, 1=Mac, 2=Linux
    private String currentSO=listOperSystem[1];
    Properties data = new Properties();

    @Override
    public Configuration configuration() {
        URL storyURL = null;

        try {
            data= setProperties(data);
            storyURL = new URL("file://" + data.getProperty(currentSO+".storiesPath"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new MostUsefulConfiguration().useStoryLoader(
                new LoadFromRelativeFile(storyURL)).useStoryReporterBuilder(
                new StoryReporterBuilder().withFormats(Format.HTML));
    }

    @Override
    public List<CandidateSteps> candidateSteps() {
        return new InstanceStepsFactory(configuration(), new steps.Example())
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
    public Properties setProperties(Properties prop){

        try{
            if (currentSO.equals("Windows")) {
                prop.load(new FileInputStream("C:\\w\\FunctTest\\src\\main\\resources\\data.properties"));

            } else if (currentSO.equals("Mac")) {
                prop.load(new FileInputStream("/Users/marcelodiaz/Documents/w/JBehaveOK/src/main/resources/data.properties"));
            } else  {
                prop.load(new FileInputStream("/Users/marcelodiaz/Documents/w/JBehaveOK/src/main/resources/data.properties"));
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return prop;
    }
}
