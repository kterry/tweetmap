package tweetmap;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tweetmap.TweetmapApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TweetmapApplication.class)
@WebAppConfiguration
public class TweetmapApplicationTests {

	@Test
	public void contextLoads() {
	}

}
