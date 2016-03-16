package it.polito.tdp.spellchecker.model;

import java.util.*;

public class TestModel {

	public static void main(String[] args) {
		Dictionary d=new ItalianDictionary();
		d.loadDictionary();
		List<String> s=new LinkedList<String>();
		s.add("abate");
		s.add("casa");
		s.add("abazia");
		s.add("abtae");
		
		
		for(RichWord r:d.spellCheckText(s))
		System.out.println(r.toString());
	}

}
