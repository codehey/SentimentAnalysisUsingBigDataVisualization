package com.ankitlnu.mongodb.springbootmongodbexample.resource;

import com.ankitlnu.mongodb.springbootmongodbexample.document.Sentiment;
import com.ankitlnu.mongodb.springbootmongodbexample.repository.SentimentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping("/rest/sentiments")
public class SentimentResource {
	private SentimentRepository sentimentRepository;

	
	  public SentimentResource(SentimentRepository sentimentRepository) {
	  this.sentimentRepository = sentimentRepository; }
	 
    @GetMapping("/all")
    public List<Sentiment> getAll() {
        return sentimentRepository.findAll();
    }
    @GetMapping("/getPositiveTweets")
    public Integer getPositiveTweets() {
    	List<Sentiment> tweetSentiments = sentimentRepository.findAll();
    	 int positiveTweets =  0;
    	for(Sentiment currSentiment : tweetSentiments) {
        	if(currSentiment.getSentiment().equalsIgnoreCase("Positive"))
        		positiveTweets++;
        	
        }
    	return  positiveTweets;
        
    }
    
    @GetMapping("/getNegativeTweets")
    public Integer getNegativeTweets() {
    	List<Sentiment> tweetSentiments = sentimentRepository.findAll();
    	 int negativeTweets =  0;
    	for(Sentiment currSentiment : tweetSentiments) {
        	if(currSentiment.getSentiment().equalsIgnoreCase("Negative"))
        		negativeTweets++;
        	
        }
    	return  negativeTweets;
        
    }
    
    @GetMapping("/getNeutralTweets")
    public Integer getNeutralTweets() {
    	List<Sentiment> tweetSentiments = sentimentRepository.findAll();
    	 int neutralTweets =  0;
    	for(Sentiment currSentiment : tweetSentiments) {
        	if(currSentiment.getSentiment().equalsIgnoreCase("Neutral"))
        		neutralTweets++;
        	
        }
    	return  neutralTweets;
        
    }
    
    @RequestMapping(value = "drawGraph", method = RequestMethod.GET)
    public ModelAndView getPieChart(Model model) {
        Map<String, Integer> graphData = new TreeMap<>();
        List<Sentiment> tweetSentiments = sentimentRepository.findAll();
        ModelAndView modelAndView = new ModelAndView();
        int positiveTweets =  0;
        int negativeTweets =0;
        int neutralTweets = 0;
        
        for(Sentiment currSentiment : tweetSentiments) {
        	if(currSentiment.getSentiment().equalsIgnoreCase("Positive"))
        		positiveTweets++;
        	if(currSentiment.getSentiment().equalsIgnoreCase("Negative"))
        		negativeTweets++;
        	if(currSentiment.getSentiment().equalsIgnoreCase("Neutral"))
        		neutralTweets++;
        }
        
        graphData.put("Positive", positiveTweets);
        graphData.put("Negative", negativeTweets);
        graphData.put("Neutral", neutralTweets);
        model.addAttribute("chartData", graphData);
        modelAndView.setViewName("sentiments-charts");
        return modelAndView;
    }
}