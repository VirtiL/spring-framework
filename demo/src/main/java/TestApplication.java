import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * @author: virtiL
 */
public class TestApplication {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext annotationConfigApplicationContext = new AnnotationConfigApplicationContext(TestConfig.class);

		Test test = annotationConfigApplicationContext.getBean("test", Test.class);
		System.out.println(test);



	}
}