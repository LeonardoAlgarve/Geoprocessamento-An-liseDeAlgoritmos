package Algoritmos;
import java.util.ArrayList;

import Entidades.Cadastro;

public class Pesquisa {
	public boolean checaCod(ArrayList<Cadastro> cd,String cod) {
		for(int i = 0; i < cd.size();i++) {
			Cadastro c = cd.get(i);
			if(c.getCod().equals(cod)) {
				return true;
			} 
		}
		return false;
	}
	
	public int getIndex(ArrayList<Cadastro> cd,String cod) {
		for(int i = 0; i < cd.size();i++) {
			Cadastro c = cd.get(i);
			if(c.getCod().equals(cod)) {
				return i;
			} 
		}
		return -1;
	}
}
	


