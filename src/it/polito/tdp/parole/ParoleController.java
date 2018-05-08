package it.polito.tdp.parole;

import it.polito.tdp.parole.model.ParolaArrayList;

/**
 * Sample Skeleton for 'Parole.fxml' Controller Class
 */


import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ParoleController {
	
	Parole elenco ;
	ParolaArrayList elencoAr;

    @FXML // ResourceBundle that was given to the FXMLLoader
    private ResourceBundle resources;

    @FXML // URL location of the FXML file that was given to the FXMLLoader
    private URL location;

    @FXML // fx:id="txtParola"
    private TextField txtParola; // Value injected by FXMLLoader

    @FXML // fx:id="txtResult"
    private TextArea txtResult; // Value injected by FXMLLoader
    
    @FXML
    private Button btnReset;

    @FXML // fx:id="btnInserisci"
    private Button btnInserisci; // Value injected by FXMLLoader
    
    @FXML
    private TextArea txtTempo;
    

    @FXML
    private TextArea txtTempo2;

    @FXML
    void doInsert(ActionEvent event) {
    	String word=txtParola.getText();
    	if(!word.equals("")) {
    		long t3=System.nanoTime();
        	String word2=word;
        	word2=elencoAr.controllaParola(word2);
        	txtParola.clear();
        	if(elencoAr.addParola(word2)) {
            	txtResult.setText(elencoAr.stampa());
        	}
        	else
        		txtResult.setText("Parola già presente nell'elenco \n"+elencoAr.stampa());
        	long t4=System.nanoTime();
        	this.stampaArr(t3,t4);
        	
        	
        	long t1=System.nanoTime();
        	word=elenco.controllaParola(word);
        	txtParola.clear();
        	if(elenco.addParola(word2)) {
            	txtResult.setText(elenco.stampa());
        	}
        	else
        		txtResult.setText("Parola già presente nell'elenco \n"+elenco.stampa());
        	long t2=System.nanoTime();
        	this.stampa(t1,t2);
    	}
    	else {
    		txtResult.setText("Inserisci parola");
    	}
    	
    	// TODO
    }
    
    private void stampaArr(long t3, long t4) {	
    	long result=t4-t3;
    	double sec=result/1000000;
    	txtTempo.setText("Tempo operazione in nano sec: "+result+"\nTempo operazione in millisec (sec 10^-3): "+sec);
	}

	private void stampa(long t1, long t2) {
		long result=t2-t1;
		double sec=result/1000000;
		txtTempo2.setText("Tempo operazione in nano sec: "+result+"\nTempo operazione in millisec (sec 10^-3): "+sec);
	}

	@FXML
    void doReset(ActionEvent event) {
    	long t3=System.nanoTime();
    	elencoAr.reset();
    	txtParola.clear();
    	txtResult.setText("Lista vuota");
    	long t4=System.nanoTime();
    	this.stampaArr(t3,t4);
		
		long t1=System.nanoTime();
    	elenco.reset();
    	txtParola.clear();
    	txtResult.setText("Lista vuota");
    	long t2=System.nanoTime();
    	this.stampa(t1,t2);
    }
    

    @FXML
    void onCancella(ActionEvent event) {
    	String pa=txtParola.getText();
    	
    	if(!pa.equals("")) {
    		long t3=System.nanoTime();
        	pa=elencoAr.controllaParola(pa);
        	if(elencoAr.cancellaParola(pa)) {
        		txtResult.setText("Parola "+pa+" cancellata \n\n" +elenco.stampa());
        	}
        	else {
        		if(!elencoAr.getElenco().isEmpty()) {
            		txtResult.setText("Parola "+pa+" non presente in lista \n\n" +elenco.stampa());
        		}
        		else {
            		txtResult.setText("Elenco vuoto");
        		}
        	}
        	txtParola.clear();
        	long t4=System.nanoTime();
        	this.stampaArr(t3,t4);
        	
        	long t1=System.nanoTime();
        	pa=elenco.controllaParola(pa);
        	if(elenco.cancellaParola(pa)) {
        		txtResult.setText("Parola "+pa+" cancellata \n\n" +elenco.stampa());
        	}
        	else {
        		if(!elenco.getElenco().isEmpty()) {
            		txtResult.setText("Parola "+pa+" non presente in lista \n\n" +elenco.stampa());
        		}
        		else {
            		txtResult.setText("Elenco vuoto");
        		}
        	}
        	txtParola.clear();
        	long t2=System.nanoTime();
        	this.stampa(t1,t2);
    	}
    	else {
    		txtResult.setText("Parola non valida");
    	}
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtTempo != null : "fx:id=\"txtTempo\" was not injected: check your FXML file 'Parole.fxml'.";
        assert txtTempo2 != null : "fx:id=\"txtTempo2\" was not injected: check your FXML file 'Parole.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Parole.fxml'.";

        elenco = new Parole() ;
        elencoAr=new ParolaArrayList();
        
    }
}
