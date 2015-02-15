package tweetmap;

import java.util.List;

import javax.inject.Inject;

import org.springframework.social.twitter.api.GeoCode;
import org.springframework.social.twitter.api.SearchParameters;
import org.springframework.social.twitter.api.Tweet;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TweetSearchController {
	
	private Twitter twitter;

	@Inject
	public TweetSearchController(Twitter twitter) {
		this.twitter = twitter;
	}

	@RequestMapping(value="/searchtweets", method=RequestMethod.GET)
	public List<Tweet> searchTweets(@RequestParam(value="lat", required=true) double latitude, 
			                        @RequestParam(value="lon", required=true) double longitude, 
			                        @RequestParam(value="radius", defaultValue="1") int radius) {
		
		SearchParameters searchParams = new SearchParameters("");
		searchParams.geoCode(new GeoCode(latitude, longitude, radius, GeoCode.Unit.KILOMETER));
		searchParams.includeEntities(false);
		
		return twitter.searchOperations().search(searchParams).getTweets();
	}
}
