package Entidades;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import Algoritmos.Pesquisa;

public class Cadastro {
	private String cod,lat,lon,data,hora;
	private byte[] bit;
	
	
	public Cadastro(String cod, String lat, String lon, String data, String hora, byte[] bit) {
		this.cod = cod;
		this.lat = lat;
		this.lon = lon;
		this.data = data;
		this.hora = hora;
		this.bit = bit;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLon() {
		return lon;
	}

	public void setLon(String lon) {
		this.lon = lon;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
 
	public String toString() {
		return "cod: "  + cod + "/lat: " + lat + "/long: " + lon + "/data: " + data + "/hora: " + hora;
	}
	
	public byte[] getBit() {
		return bit;
	}
	
	public void setBit(byte[] bit) {
		this.bit = bit;
	}
	
	public static void exibirCodigosCadastro(ArrayList<Cadastro> c) {
		String msg = "";
		
		for(int i = 0; i < c.size(); i++) {
			Cadastro cad = c.get(i);
			msg += ("\n Cadastro nº " + (i+1) + " Código: " + cad.getCod());
		}
		JOptionPane.showMessageDialog(null, msg);
	}
	public static void ordenaLista(ArrayList<Cadastro> c,int v[] ) {
		Pesquisa p = new Pesquisa();
		Cadastro aux;
		if(c.size() == v.length) {
			for(int i = 0; i < c.size(); i++) {
				if(Integer.parseInt(c.get(i).getCod()) != v[i] ) {
					int index = p.getIndex(c, Integer.toString(v[i]));
					aux = c.get(i);
					c.set(i, c.get(index));
					c.set(index, aux);
				}
			
			}
			
		}
	}
}
