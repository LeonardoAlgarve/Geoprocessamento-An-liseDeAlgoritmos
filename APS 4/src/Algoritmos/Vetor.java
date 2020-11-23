package Algoritmos;

import java.util.ArrayList;

import Entidades.Cadastro;

public class Vetor {
	private int codigos[];
	

	public Vetor(ArrayList<Cadastro> c) {
		codigos = new int[c.size()];
		for(int i = 0; i < c.size(); i++) {
			codigos[i] = Integer.parseInt(c.get(i).getCod());
		}
	}
	public Vetor(){
		
	}
	
	public int[] getVetor() {
		return codigos;
	}
	
	 public int[] preencherVetor(int v[]) {
		 
		 for(int i = 0;i < v.length;i++) {
			 v[i] = (int)(Math.random() * v.length);
		 }
		 return v;
	 }
	 
	 public int[] preencherVetor(int v[],int tam) {
		 v = new int[tam];
		 for(int i = 0;i < v.length;i++) {
			 v[i] = (int)(Math.random() * tam);
		 }
		 return v;
	 }
	 
	 public int[] preencherVetorSemiOrd(int v[],int tam) {
		 v = new int[tam];
		 int random = (int)(Math.random()*(v.length));
		 for(int i = 0; i < (v.length/2);i++ ) {
			 v[i] = i;
		 }
		 for(int i =(v.length/2);i < v.length; i++ ) {
			random = (int)(Math.random()*(v.length));
			 while(random < (v.length/2)) {
				 random = (int)(Math.random()*(v.length));
			 }
			 v[i] = random; 
		 }
		 return v;
	 }
	 
	 public int[] preencherVetorOrd(int v[],int tam) {
		 v = new int[tam];
		 for(int i = 0; i < v.length;i++ ) {
			 v[i] = i;
		 }
		
		 return v;
	 }
}
