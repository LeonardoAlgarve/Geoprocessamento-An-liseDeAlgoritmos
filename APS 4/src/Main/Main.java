package Main;

import java.awt.EventQueue;
import java.util.ArrayList;

import Entidades.Cadastro;
import Frame.Janela;

public class Main {
	public static ArrayList<Cadastro> CD = new ArrayList<Cadastro>();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Janela frame = new Janela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}
	
	

}
