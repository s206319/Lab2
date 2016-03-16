package it.polito.tdp.spellchecker.model;

import java.util.*;

public class Dictionary {
	List<String>dizionario=new LinkedList<String>();
	List<RichWord> richWords=new LinkedList<RichWord>();
	
	
	public void loadDictionary(){
		
		
	}
	
	public List<RichWord> spellCheckText(List<String> inputTextList){
		RichWord r=null;

	for(String s:inputTextList){
		r=new RichWord(s);
		if(dizionario.contains(s)){
			richWords.add(r);
			r.setCorretta(true);
		}else{
			r.setCorretta(false);
			richWords.add(r);
		}
		
	}
	return richWords;
		
		
		
	}

}
