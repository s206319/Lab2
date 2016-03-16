package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class EnglishDictionary extends Dictionary{
List<String>dizionarioEng=new LinkedList<String>();
	@Override
	public void loadDictionary() {
		try {
			FileReader fr = new FileReader("rsc/English.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
				dizionarioEng.add(word);
				dizionario.add(word);
			}
			br.close();
			} catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
		
	}
	
	

}
