package it.polito.tdp.parole.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParolaArrayList {
	List<String> elenco;
		
	public ParolaArrayList() {
		elenco=new ArrayList<String>();
	}
	
	public boolean addParola(String p) {
		if(!elenco.contains(p)) {
			elenco.add(p);
			return true;
		}
		else {
			return false;
		}
	}
	
	public String controllaParola(String s) {
		s=s.replaceAll(" ", "");
		s=s.trim();
		s=s.toLowerCase();
		return s;
	}
	
	public List<String> getElenco() {
		Collections.sort(elenco);
		return elenco;
	}
	
	public void reset() {
		elenco.clear();
	}
	
	public boolean cancellaParola(String s) {
		//for(String t:elenco) {
			if(elenco.contains(s)) {
				elenco.remove(s);
				return true;
			}
	//	}
		return false;
	}
	
	public String stampa() {
		String e="";
		for(String s:this.getElenco()) {
			e+=s+ "\n";
		}
		return e;
	}

}

