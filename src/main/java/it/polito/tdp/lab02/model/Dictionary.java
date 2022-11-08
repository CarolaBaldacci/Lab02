package it.polito.tdp.lab02.model;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {

	private Map<String, Word> dictionary;

	public Dictionary() {
		super();
		this.dictionary = new HashMap<>();
	}
	
	public void addWord(String alienWord,String translation) {
		if(!dictionary.containsKey(alienWord)) {
			dictionary.put(alienWord,  new Word(alienWord));
		}
		dictionary.get(alienWord).addTranslations(translation);
	}
	
	public String translate(String alienWord) {
		if(dictionary.containsKey(alienWord))
			return dictionary.get(alienWord).getTranslations();
		else 
			return null;
	}
	
	
	
}