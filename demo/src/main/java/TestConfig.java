import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

/**
 * @author: virtiL
 */
@Configurable
public class TestConfig {



	@Bean
	public Test test(){
		return new Test();
	}



}