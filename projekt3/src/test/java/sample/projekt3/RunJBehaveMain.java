package sample.projekt3;

import java.util.Arrays;
import java.util.List;

import org.jbehave.core.embedder.Embedder;
import org.jbehave.core.io.LoadFromClasspath;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.CandidateSteps;

public class RunJBehaveMain {

	private static Embedder embedder = new Embedder();
	private static List<String> storyPaths = Arrays.asList("Hasz1.story","Hasz2.story","Hasz3.story", "Hasz4.story", "Hasz5.story");
	
	public static void main(String[] args) {
		embedder.configuration().useStoryLoader(new LoadFromClasspath())
		  .useStoryReporterBuilder(new StoryReporterBuilder()
				  .withDefaultFormats() 
				    .withFormats(Format.CONSOLE, Format.TXT));
		embedder.candidateSteps().add((CandidateSteps) new MySteps());
		embedder.runStoriesAsPaths(storyPaths);
	}

}

