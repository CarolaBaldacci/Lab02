package it.polito.tdp.lab02.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Word {

	private String alienWord;
	private Set <String> translations;
	
	public Word(String alienWord) {
		super();
		this.alienWord = alienWord;
		this.translations= new HashSet<String>();
	}

	public String getAlienWord() {
		return alienWord;
	}

	public void setAlienWord(String alienWord) {
		this.alienWord = alienWord;
	}

	public String getTranslations() {
		String t="";
		for(String a :translations) {
			t+= a+"\n";
		}
		return t;
	}

	public void addTranslations(String alienWord) {
		this.translations.add(alienWord);
	}

	@Override
	public int hashCode() {
		return Objects.hash(alienWord);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return Objects.equals(alienWord, other.alienWord);
	}
	
	
}
