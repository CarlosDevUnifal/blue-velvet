package bluevelvet.JpaConnection;

import config.ApplicationConfig;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = ApplicationConfig.class)
@EntityScan()
class JpaConnectionApplicationTests {

	@Test
	void contextLoads() {
	}

}
