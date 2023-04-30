package com.ankitlnu.mongodb.springbootmongodbexample.document;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "demo_collection")
public class Sentiment {

	
	@Id
    private String _id;
    private String text;
    private String processed_text;
    private Long subjectivity;
    private String polarity;
    private String sentiment;
	public Sentiment(String _id, String text, String processed_text, Long subjectivity, String polarity,
			String sentiment) {
		super();
		this._id = _id;
		this.text = text;
		this.processed_text = processed_text;
		this.subjectivity = subjectivity;
		this.polarity = polarity;
		this.sentiment = sentiment;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getProcessed_text() {
		return processed_text;
	}
	public void setProcessed_text(String processed_text) {
		this.processed_text = processed_text;
	}
	public Long getSubjectivity() {
		return subjectivity;
	}
	public void setSubjectivity(Long subjectivity) {
		this.subjectivity = subjectivity;
	}
	public String getPolarity() {
		return polarity;
	}
	public void setPolarity(String polarity) {
		this.polarity = polarity;
	}
	public String getSentiment() {
		return sentiment;
	}
	public void setSentiment(String sentiment) {
		this.sentiment = sentiment;
	}
	
    
	
    
    
}
