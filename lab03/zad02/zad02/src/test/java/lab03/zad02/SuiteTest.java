package lab03.zad02;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	TestCyfroKradCorrect.class,
	TestCyfroKradCorrectWithParams.class,
	TestCyfroKradException.class,
	TestHeheszkiCorrect.class,
	TestHeheszkiException.class,
	TestHultajChochlaCorrect.class,
	TestHultajChochlaException.class,
	TestNieksztaltekChangeDigits.class,
	TestNieksztaltekDoNothing.class,
	TestTititCorrect.class,
	TestTititException.class
})
public class SuiteTest {   
}  	

