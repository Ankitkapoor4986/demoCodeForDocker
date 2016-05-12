package com.bb.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.bb.domain.Feed;

@Controller
public class FeedController {

	private static final String VIEW_INDEX = "index";
	private static String URI = "http://restapp:8080/FeedRestApp/rest/feed/";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(FeedController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView listFeedBacks() {
		
		logger.debug("starting the app.................");
		List<Feed> feeds = getFeedsData(URI);
//		List<Feed> feeds = getFeedsData();
		ModelAndView model = new ModelAndView(VIEW_INDEX);
		model.addObject("data", feeds);
		return model;

	}
	
	private List<Feed> getFeedsData() {
		List<Feed> list = new ArrayList<Feed>();
		Feed feed = new Feed();
		feed.setDescription("Good One");
		feed.setTitle("I am a feed back");
		feed.setUrl("htt://feedback.com");
		list.add(feed);
		return list;
	}
	
	
	private List<Feed> getFeedsData(String URI) {
		
		RestTemplate restTemplate = getRestTemplate();
		
		
		
        ParameterizedTypeReference<List<Feed>> parameterizedTypeReference = new ParameterizedTypeReference<List<Feed>>() {
        };
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        ResponseEntity<List<Feed>> response = restTemplate.exchange(URI, HttpMethod.GET, null,
                parameterizedTypeReference);
        List<Feed> feeds = response.getBody();
        return feeds;
	}
	
	
	private RestTemplate getRestTemplate(){

		RestTemplate restTemplate = new RestTemplate();
		ArrayList<HttpMessageConverter<?>> httpMessageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter convertor = new MappingJackson2HttpMessageConverter();
		httpMessageConverters.add(convertor);
		restTemplate.setMessageConverters(httpMessageConverters);
		return restTemplate;
	}
	
}
