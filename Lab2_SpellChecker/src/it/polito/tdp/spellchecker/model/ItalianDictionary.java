package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class ItalianDictionary extends Dictionary{
	List<String> dizionarioIta=new LinkedList<String>();
	
	@Override
	public void loadDictionary() {
		try {
			FileReader fr = new FileReader("rsc/Italian.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
			dizionarioIta.add(word);
			dizionario.add(word);
			}
			br.close();
			} catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
		
		
	
	}
	

}
