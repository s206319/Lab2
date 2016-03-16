package it.polito.tdp.spellchecker.controller;

import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;



import it.polito.tdp.spellchecker.model.Dictionary;
import it.polito.tdp.spellchecker.model.EnglishDictionary;
import it.polito.tdp.spellchecker.model.ItalianDictionary;
import it.polito.tdp.spellchecker.model.RichWord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


public class SpellCheckerController {
	private Dictionary d;
	String scelta;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<String> boxLingue;

    @FXML
    private TextField TextInsert;

    @FXML
    private Button btnCheck;

    @FXML
    private TextFlow TxtRisposta;

    @FXML
    private Label lblCommento;

    @FXML
    private Button btnClear;

    @FXML
    private Label lblTime;
    
    public void setModel(Dictionary d){
    	this.d=d;
    }
    
    @FXML
    void DoClear(ActionEvent event) {
    	TextInsert.clear();
    	TxtRisposta.getChildren().clear();
    	lblCommento.setText("");
    	lblTime.setText("");
    }

  
    @FXML
    void DoSpellCheck(ActionEvent event) {
    	long le9 = 1000000000;
    	long t0 = System.nanoTime();
    	List<String> parole=new LinkedList<String>();
    	if(boxLingue.getValue()==null){
    		lblCommento.setText("Scegli una lingua");
    		TextInsert.clear();
    		return;
    	}
    	if(boxLingue.getValue().compareTo("Italian")==0){
    		d=new ItalianDictionary();
    		d.loadDictionary();
    		 String array []=TextInsert.getText().toLowerCase().split("[:, ]+");
    		for(int i=0;i<array.length;i++){
    			parole.add(array[i]);
    		}
    		for(RichWord r:d.spellCheckText(parole)){
    			if(r.isCorretta()){
    				Text t = new Text(r.getParola()+" ");
    				TxtRisposta.getChildren().add(t);
    				  lblCommento.setText("il testo non contiene errori");
    				  lblTime.setText("Spell check completed in : "+(float)(System.nanoTime()-t0)/le9);
    			}
    			if(!r.isCorretta()){
    				Text t = new Text(r.getParola()+" ");
    				t.setFill(javafx.scene.paint.Color.RED);
    				TxtRisposta.getChildren().add(t);
    				 lblCommento.setText("il testo contiene errori");
   				  lblTime.setText("Spell check completed in : "+(float)(System.nanoTime()-t0)/le9);

    			}
    			
    			
    			
    		}
    	}
    	else{
    		d=new EnglishDictionary();
    		d.loadDictionary();
    		 String array []=TextInsert.getText().toLowerCase().split(" ");
    		for(int i=0;i<array.length;i++){
    			parole.add(array[i]);
    		}
    		for(RichWord r:d.spellCheckText(parole)){
    			if(r.isCorretta()){
    				Text t = new Text(r.getParola()+" ");
    				TxtRisposta.getChildren().add(t);
    				  lblCommento.setText("il testo non contiene errori");
    				  lblTime.setText("Spell check completed in : "+(float)(System.nanoTime()-t0)/le9);

    			}
    			if(!r.isCorretta()){
    				Text t = new Text(r.getParola()+" ");
    				t.setFill(javafx.scene.paint.Color.RED);
    				TxtRisposta.getChildren().add(t);
    				 lblCommento.setText("il testo contiene errori");
   				  lblTime.setText("Spell check completed in : "+(float)(System.nanoTime()-t0)/le9);

    			}
    			
    			
    			
    		}
    		
    		
    		
    	}
    	
    }

    @FXML
    void initialize() {
    	 lblCommento.setText("");
    	boxLingue.getItems().addAll("Italian","English");
        assert boxLingue != null : "fx:id=\"boxLingue\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert TextInsert != null : "fx:id=\"TextInsert\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnCheck != null : "fx:id=\"btnCheck\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert TxtRisposta != null : "fx:id=\"TxtRisposta\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblCommento != null : "fx:id=\"lblCommento\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'SpellChecker.fxml'.";
        assert lblTime != null : "fx:id=\"lblTime\" was not injected: check your FXML file 'SpellChecker.fxml'.";

    }
}
