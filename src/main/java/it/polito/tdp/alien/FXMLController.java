package it.polito.tdp.alien;

import java.util.StringTokenizer;

import it.polito.tdp.lab02.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class FXMLController {
	
	private Dictionary dictionary = new Dictionary();

    @FXML
    private Button btnTraduci;
    
    @FXML
    private Button btnClear;

    @FXML
    private TextField txtParola;

    @FXML
    private TextField txtResult;

    @FXML
    void doClear(ActionEvent event) {
    	txtResult.clear();
    	txtParola.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {

    	txtResult.clear();
    	String riga=txtParola.getText();
    	if(riga== null || riga.length()==0) {
    		txtResult.setText("Inserire una parola da tradurre o da aggiungere al dizionario");
    		return;
    	}
    	
    	StringTokenizer st = new StringTokenizer(riga," ");
    	
    	if(!st.hasMoreElements()) {
    		txtResult.setText("Inserire una parola da tradurre o da aggiungere al dizionario");
    		return;
    	}
    	
    	String alienWord= st.nextToken();
    	
    	if(st.hasMoreTokens()) {
    		
    		String translation =st.nextToken();
    		
    		if(!alienWord.matches("[a-zA-Z]*") || !translation.matches("[a-zA-Z]*")) {
    			txtResult.setText("Inserire solo caratteri alfabetici");
    			return;
    		}
    		
    		this.dictionary.addWord(alienWord, translation);
    		txtResult.setText("La parola:\""+alienWord+" \", con traduzione: \""+translation+ "\",è stata inserita nel dizionario.");
    		
    	}
    	else {
    		if(!alienWord.matches("[a-zA-Z?]*")) {
    			txtResult.setText("Inserire solo caratteri alfabetici");
    			return;
    		}
    		
    		String translation;
    		
    		translation=this.dictionary.translate(alienWord);
    		
    		if(translation!=null) {
    			txtResult.setText(translation);
    		}
    		else {
    			txtResult.setText("La parola cercata non esiste nel dizionario");
    		}
    	}
    	
    }

}

