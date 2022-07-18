package hrmLogin;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class TestNGTranform implements IAnnotationTransformer{

	
	
	public void transform(ITestAnnotation annotation,
            java.lang.Class testClass,
            java.lang.reflect.Constructor testConstructor,
            java.lang.reflect.Method testMethod) 
	{
		
		
		annotation.setRetryAnalyzer(RetryLogicExample.class);
		
	}
	
	
}
