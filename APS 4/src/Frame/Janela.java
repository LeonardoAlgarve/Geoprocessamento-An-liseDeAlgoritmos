package Frame;

import java.awt.AlphaComposite;
import java.awt.CardLayout;

import Algoritmos.Ordenacao;
import Algoritmos.Pesquisa;
import Algoritmos.Vetor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import Entidades.Cadastro;
import Main.Main;
import javax.swing.border.BevelBorder;

public class Janela extends JFrame {
	public Ordenacao ord = new Ordenacao();
	public Pesquisa p = new Pesquisa();
	private JPanel contentPane;
	private JTextField tfLatitude;
	private JTextField tfLongitude;
	private JTextField tfDia;
	private JTextField tfMes;
	private JTextField tfAno;
	private JTextField tfHora;
	private JTextField tfMinuto;
	private JTextField tfSegundos;
	private JTextField tfCod;
	private JTextField tfCodDel;
	private JTextField tfCodCon;
	private JTextField tfCodAtt;
	private JTextField tfLatAtt;
	private JTextField tfLongAtt;
	private JTextField tfDiaAtt;
	private JTextField tfMesAtt;
	private JTextField tfAnoAtt;
	private JTextField tfHoraAtt;
	private JTextField tfMinutoAtt;
	private JTextField tfSegundoAtt;
	private File imagem;
	private JLabel lblImagem; 
	DecimalFormat df = new DecimalFormat("#,###.00");

	
	public Janela() {
		setTitle("Sistema de Geoprocessamento");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnOrdenacao = new JMenu("Ordenar Vetores");
		mnOrdenacao.setForeground(Color.BLACK);
		menuBar.add(mnOrdenacao);
		
		JMenuItem mntmBubble = new JMenuItem("Bubble Sort");
		mntmBubble.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] menu = {"Ordenar Cadastros","Ordenar Vetor Aleatório"};
				int opt = JOptionPane.showOptionDialog(null, "Qual tipo de vetor deseja ordenar?","Bubble",JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,menu,menu[0]);
				if(opt == 0) {
					String msg = "";
					Vetor vet = new Vetor(Main.CD);
					int v[] = vet.getVetor();
					JOptionPane.showMessageDialog(null, "A ordenação irá iniciar quando você clicar em ok \n isso pode levar alguns minutos");
					double ini = System.currentTimeMillis();
					ord.bubble(v);
					double tempo = System.currentTimeMillis() - ini;
					Cadastro.ordenaLista(Main.CD, v);
					msg += "Tamanho do vetor: " + v.length +"\n Tempo Decorrido: " + df.format(tempo);
					JOptionPane.showMessageDialog(null, msg);
				} else if(opt == 1) {
					String msg = "";
					int tam = Integer.parseInt(JOptionPane.showInputDialog("Insira o tamanho do vetor:"));
					int v[] = null;
					Vetor vet = new Vetor();
					v = vet.preencherVetorOrd(v, tam);
					JOptionPane.showMessageDialog(null, "A ordenação irá iniciar quando você clicar em ok \n isso pode levar alguns minutos");
					double ini = System.currentTimeMillis();
					ord.bubble(v);
					double tempo = System.currentTimeMillis() - ini;
					if(v.length > 6) {
						msg += "Tamanho do vetor: " + v.length 
						+ "\n { " + v[0] +","+ v[1] + "," + v[2]  + "," + v[3] + "," + v[4] + "..."+  v[v.length-5] + "," +  v[v.length-4] + "," + v[v.length-3] +"," +  v[v.length-2] + "," +  v[v.length-1] + "}"
						+"\n Tempo Decorrido: " + df.format(tempo) + "ms";
						JOptionPane.showMessageDialog(null, msg);
					} else if(v.length < 3)  {
						msg += "Tamanho de Vetor Insuficiente";
						JOptionPane.showMessageDialog(null, msg);
					} else {	
						msg += "Tamanho do vetor: " + v.length 
								+ "\n { " + v[0] +","+ v[1] +"," + v[2] + "}"
								+"\n Tempo Decorrido: " + df.format(tempo) + "ms";
						JOptionPane.showMessageDialog(null, msg);
					}
					
				}
			}
		});
		mnOrdenacao.add(mntmBubble);
		
		JMenuItem mntmInsertion = new JMenuItem("Insertion Sort");
		mntmInsertion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] menu = {"Ordenar Cadastros","Ordenar Vetor Aleatório"};
				int opt = JOptionPane.showOptionDialog(null, "Qual tipo de vetor deseja ordenar?","Insertion",JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,menu,menu[0]);
				if(opt == 0) {
					String msg = "";
					Vetor vet = new Vetor(Main.CD);
					int v[] = vet.getVetor();
					JOptionPane.showMessageDialog(null, "A ordenação irá iniciar quando você clicar em ok \n isso pode levar alguns minutos");
					double ini = System.currentTimeMillis();
					ord.insertion(v);
					double tempo = System.currentTimeMillis() - ini;
					Cadastro.ordenaLista(Main.CD, v);
					msg += "Tamanho do vetor: " + v.length +"\n Tempo Decorrido: " + df.format(tempo);
					JOptionPane.showMessageDialog(null, msg);
				} else if(opt == 1) {
					String msg = "";
					int tam = Integer.parseInt(JOptionPane.showInputDialog("Insira o tamanho do vetor:"));
					int v[] = null;
					Vetor vet = new Vetor();
					v = vet.preencherVetorOrd(v, tam);
					JOptionPane.showMessageDialog(null, "A ordenação irá iniciar quando você clicar em ok \n isso pode levar alguns minutos");
					double ini = System.currentTimeMillis();
					ord.insertion(v);
					double tempo = System.currentTimeMillis() - ini;
					if(v.length > 6) {
						msg += "Tamanho do vetor: " + v.length 
						+ "\n { " + v[0] +","+ v[1] + "," + v[2]  + "," + v[3] + "," + v[4] + "..."+  v[v.length-5] + "," +  v[v.length-4] + "," + v[v.length-3] +"," +  v[v.length-2] + "," +  v[v.length-1] + "}"
						+"\n Tempo Decorrido: " + df.format(tempo) + "ms";
						JOptionPane.showMessageDialog(null, msg);
					} else if(v.length < 3)  {
						msg += "Tamanho de Vetor Insuficiente";
						JOptionPane.showMessageDialog(null, msg);
					} else {	
						msg += "Tamanho do vetor: " + v.length 
								+ "\n { " + v[0] +","+ v[1] +"," + v[2] + "}"
								+"\n Tempo Decorrido: " + df.format(tempo) + "ms";
						JOptionPane.showMessageDialog(null, msg);
					}
					
				}
			}
		});
		mnOrdenacao.add(mntmInsertion);
		
		JMenuItem mntmSelection = new JMenuItem("Selection Sort");
		mntmSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] menu = {"Ordenar Cadastros","Ordenar Vetor Aleatório"};
				int opt = JOptionPane.showOptionDialog(null, "Qual tipo de vetor deseja ordenar?","Selection",JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,menu,menu[0]);
				if(opt == 0) {
					String msg = "";
					Vetor vet = new Vetor(Main.CD);
					int v[] = vet.getVetor();
					JOptionPane.showMessageDialog(null, "A ordenação irá iniciar quando você clicar em ok \n isso pode levar alguns minutos");
					double ini = System.currentTimeMillis();
					ord.selection(v);
					double tempo = System.currentTimeMillis() - ini;
					Cadastro.ordenaLista(Main.CD, v);
					msg += "Tamanho do vetor: " + v.length +"\n Tempo Decorrido: " + df.format(tempo);
					JOptionPane.showMessageDialog(null, msg);
				} else if(opt == 1) {
					String msg = "";
					int tam = Integer.parseInt(JOptionPane.showInputDialog("Insira o tamanho do vetor:"));
					int v[] = null;
					Vetor vet = new Vetor();
					v = vet.preencherVetorOrd(v, tam);
					JOptionPane.showMessageDialog(null, "A ordenação irá iniciar quando você clicar em ok \n isso pode levar alguns minutos");
					double ini = System.currentTimeMillis();
					ord.selection(v);
					double tempo = System.currentTimeMillis() - ini;
					if(v.length > 6) {
						msg += "Tamanho do vetor: " + v.length 
						+ "\n { " + v[0] +","+ v[1] + "," + v[2]  + "," + v[3] + "," + v[4] + "..."+  v[v.length-5] + "," +  v[v.length-4] + "," + v[v.length-3] +"," +  v[v.length-2] + "," +  v[v.length-1] + "}"
						+"\n Tempo Decorrido: " + df.format(tempo) + "ms";
						JOptionPane.showMessageDialog(null, msg);
					} else if(v.length < 3)  {
						msg += "Tamanho de Vetor Insuficiente";
						JOptionPane.showMessageDialog(null, msg);
					} else {	
						msg += "Tamanho do vetor: " + v.length 
								+ "\n { " + v[0] +","+ v[1] +"," + v[2] + "}"
								+"\n Tempo Decorrido: " + df.format(tempo) + "ms";
						JOptionPane.showMessageDialog(null, msg);
					}
					
				}
			}
		});
		mnOrdenacao.add(mntmSelection);
		
		JMenuItem mntmQuick = new JMenuItem("Quick Sort");
		mntmQuick.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] menu = {"Ordenar Cadastros","Ordenar Vetor Aleatório"};
				int opt = JOptionPane.showOptionDialog(null, "Qual tipo de vetor deseja ordenar?","Quick",JOptionPane.DEFAULT_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,menu,menu[0]);
				if(opt == 0) {
					String msg = "";
					Vetor vet = new Vetor(Main.CD);
					int v[] = vet.getVetor();
					JOptionPane.showMessageDialog(null, "A ordenação irá iniciar quando você clicar em ok \n isso pode levar alguns minutos");
					double ini = System.currentTimeMillis();
					ord.quick(v);
					double tempo = System.currentTimeMillis() - ini;
					Cadastro.ordenaLista(Main.CD, v);
					msg += "Tamanho do vetor: " + v.length +"\n Tempo Decorrido: " + df.format(tempo);
					JOptionPane.showMessageDialog(null, msg);
				} else if(opt == 1) {
					String msg = "";
					int tam = Integer.parseInt(JOptionPane.showInputDialog("Insira o tamanho do vetor:"));
					int v[] = null;
					Vetor vet = new Vetor();
					v = vet.preencherVetor(v, tam);
					JOptionPane.showMessageDialog(null, "A ordenação irá iniciar quando você clicar em ok \n isso pode levar alguns minutos");
					double ini = System.currentTimeMillis();
					ord.quick(v);
					double fim = System.currentTimeMillis();
					double tempo = fim - ini;
					
					if(v.length > 6) {
						msg += "Tamanho do vetor: " + v.length 
						+ "\n { " + v[0] +","+ v[1] + "," + v[2]  + "," + v[3] + "," + v[4] + "..."+  v[v.length-5] + "," +  v[v.length-4] + "," + v[v.length-3] +"," +  v[v.length-2] + "," +  v[v.length-1] + "}"
						+"\n Tempo Decorrido: " + tempo + "ms";
						JOptionPane.showMessageDialog(null, msg);
					} else if(v.length < 3)  {
						msg += "Tamanho de Vetor Insuficiente";
						JOptionPane.showMessageDialog(null, msg);
					} else {	
						msg += "Tamanho do vetor: " + v.length 
								+ "\n { " + v[0] +","+ v[1] +"," + v[2] + "}"
								+"\n Tempo Decorrido: " + tempo + "ms";
						JOptionPane.showMessageDialog(null, msg);
					}
					
				}
			}
		});
		mnOrdenacao.add(mntmQuick);
		
		JMenu mnOpcoes = new JMenu("Op\u00E7\u00F5es");
		mnOpcoes.setForeground(Color.BLACK);
		mnOpcoes.setBackground(Color.WHITE);
		menuBar.add(mnOpcoes);
		
		JMenuItem mntmExibirCadastros = new JMenuItem("Exibir todos os Cadastros");
		mntmExibirCadastros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro.exibirCodigosCadastro(Main.CD);
			}
		});
		mnOpcoes.add(mntmExibirCadastros);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnOpcoes.add(mntmSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
				
		JPanel Hub = new JPanel();
		contentPane.add(Hub, "HUB");
		Hub.setLayout(null);
		
		JPanel Cadastramento = new JPanel();
		contentPane.add(Cadastramento, "CADASTRAMENTO");
		Cadastramento.setLayout(null);
		
		
		JButton btnNovoCadastro = new JButton("Inserir Novo Cadastro");
		btnNovoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								trocaTela("CADASTRAMENTO");
				
				
			}
		});
		
		btnNovoCadastro.setBounds(103, 71, 454, 23);
		Hub.add(btnNovoCadastro);
		
		JButton btnDeletarCadastro = new JButton("Deletar Cadastro Existente");
		btnDeletarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocaTela("DELETAR");
			}
		});
		btnDeletarCadastro.setBounds(103, 139, 454, 23);
		Hub.add(btnDeletarCadastro);
		
		JButton btnConsultarCadastro = new JButton("Consultar Cadastro");
		btnConsultarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocaTela("CONSULTAR");
			}
		});
		btnConsultarCadastro.setBounds(103, 199, 454, 23);
		Hub.add(btnConsultarCadastro);
		
		JLabel lblHub = new JLabel("Bem Vindo(a), selecione a op\u00E7\u00E3o desejada");
		lblHub.setFont(new Font("Arial", Font.BOLD, 14));
		lblHub.setHorizontalAlignment(SwingConstants.CENTER);
		lblHub.setBounds(10, 0, 654, 60);
		Hub.add(lblHub);
		
		JButton btnAtualizarCadastro = new JButton("Atualizar Cadastro Existente");
		btnAtualizarCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trocaTela("ATUALIZAR");
			}
		});
		btnAtualizarCadastro.setBounds(103, 259, 454, 23);
		Hub.add(btnAtualizarCadastro);
		
		
		
		JLabel lblCadastramento = new JLabel("Insira as informa\u00E7\u00F5es para efetura o cadastramento");
		lblCadastramento.setHorizontalAlignment(SwingConstants.LEFT);
		lblCadastramento.setFont(new Font("Arial", Font.BOLD, 14));
		lblCadastramento.setBounds(10, 0, 454, 59);
		Cadastramento.add(lblCadastramento);
		
		JLabel lblLatitude = new JLabel("Latitude");
		lblLatitude.setHorizontalAlignment(SwingConstants.CENTER);
		lblLatitude.setFont(new Font("Arial", Font.PLAIN, 14));
		lblLatitude.setBounds(10, 125, 150, 30);
		Cadastramento.add(lblLatitude);
		
		tfLatitude = new JTextField();
		tfLatitude.setBounds(170, 125, 211, 30);
		Cadastramento.add(tfLatitude);
		tfLatitude.setColumns(10);
		
		JLabel lblLongitude = new JLabel("Longitude");
		lblLongitude.setHorizontalAlignment(SwingConstants.CENTER);
		lblLongitude.setFont(new Font("Arial", Font.PLAIN, 14));
		lblLongitude.setBounds(10, 185, 150, 30);
		Cadastramento.add(lblLongitude);
		
		tfLongitude = new JTextField();
		tfLongitude.setColumns(10);
		tfLongitude.setBounds(170, 185, 211, 30);
		Cadastramento.add(tfLongitude);
		
		JLabel lblData = new JLabel("Data");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		lblData.setFont(new Font("Arial", Font.PLAIN, 14));
		lblData.setBounds(10, 245, 150, 30);
		Cadastramento.add(lblData);
		
		tfDia = new JTextField();
		tfDia.setToolTipText("dia");
		tfDia.setBounds(170, 246, 50, 30);
		Cadastramento.add(tfDia);
		tfDia.setColumns(10);
		
		JLabel lblHora = new JLabel("Hor\u00E1rio");
		lblHora.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora.setFont(new Font("Arial", Font.PLAIN, 14));
		lblHora.setBounds(10, 305, 150, 30);
		Cadastramento.add(lblHora);
		
		JLabel lblBarra1 = new JLabel("/");
		lblBarra1.setToolTipText("");
		lblBarra1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarra1.setBounds(300, 246, 33, 30);
		Cadastramento.add(lblBarra1);
		
		JLabel lblPonto = new JLabel(":");
		lblPonto.setToolTipText("");
		lblPonto.setHorizontalAlignment(SwingConstants.CENTER);
		lblPonto.setBounds(218, 306, 33, 30);
		Cadastramento.add(lblPonto);
		
		JLabel lblBarra2 = new JLabel("/");
		lblBarra2.setToolTipText("");
		lblBarra2.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarra2.setBounds(218, 246, 33, 30);
		Cadastramento.add(lblBarra2);
		
		tfMes = new JTextField();
		tfMes.setToolTipText("m\u00EAs");
		tfMes.setColumns(10);
		tfMes.setBounds(251, 246, 50, 30);
		Cadastramento.add(tfMes);
		
		tfAno = new JTextField();
		tfAno.setToolTipText("ano");
		tfAno.setColumns(10);
		tfAno.setBounds(331, 246, 50, 30);
		Cadastramento.add(tfAno);
		
		tfHora = new JTextField();
		tfHora.setToolTipText("hora");
		tfHora.setColumns(10);
		tfHora.setBounds(170, 306, 50, 30);
		Cadastramento.add(tfHora);
		
		tfMinuto = new JTextField();
		tfMinuto.setToolTipText("minuto");
		tfMinuto.setColumns(10);
		tfMinuto.setBounds(251, 306, 50, 30);
		Cadastramento.add(tfMinuto);
		
		JLabel lblPonto2 = new JLabel(":");
		lblPonto2.setToolTipText("");
		lblPonto2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPonto2.setBounds(300, 306, 33, 30);
		Cadastramento.add(lblPonto2);
		
		tfSegundos = new JTextField();
		tfSegundos.setToolTipText("segundos");
		tfSegundos.setColumns(10);
		tfSegundos.setBounds(331, 306, 50, 30);
		Cadastramento.add(tfSegundos);
		
		JLabel lblCodigo = new JLabel("C\u00F3digo de Identifica\u00E7\u00E3o");
		lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCodigo.setBounds(10, 75, 150, 30);
		Cadastramento.add(lblCodigo);
		
		tfCod = new JTextField();
		tfCod.setColumns(10);
		tfCod.setBounds(170, 75, 211, 30);
		Cadastramento.add(tfCod);
		
		JButton btnVoltar = new JButton("< Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfCod.setText("");
				tfLatitude.setText("");
				tfLongitude.setText("");
				tfDia.setText("");
				tfMes.setText("");
				tfAno.setText("");
				tfHora.setText("");
				tfMinuto.setText("");
				tfSegundos.setText("");
				lblImagem.setIcon(null);
				imagem = null;
				trocaTela("HUB");
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar.setBounds(10, 383, 150, 30);
		Cadastramento.add(btnVoltar);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(p.checaCod(Main.CD, tfCod.getText())) {
				JOptionPane.showMessageDialog(null, "Código já existente");
			} else {
				if(imagem != null && tfCod.getText() != "") {
					Cadastro cad = new Cadastro(tfCod.getText(),tfLatitude.getText(),tfLongitude.getText(),(tfDia.getText() + "/"+ tfMes.getText()+ "/" + tfAno.getText()), (tfHora.getText() + ":" + tfMinuto.getText() + ":" + tfSegundos.getText()),getImagem());
					Main.CD.add(cad);
					System.out.println(tfCod.getText() + "----" + tfLatitude.getText() + "----" + tfLongitude.getText() + "----" + (tfDia.getText() + "/"+ tfMes.getText()+ "/" + tfAno.getText()) + "----" + (tfHora.getText() + ":" + tfMinuto.getText() + ":" + tfSegundos.getText()));
					JOptionPane.showMessageDialog(null, "Cadastro Efetuado com Sucesso");
					tfCod.setText("");
					tfLatitude.setText("");
					tfLongitude.setText("");
					tfDia.setText("");
					tfMes.setText("");
					tfAno.setText("");
					tfHora.setText("");
					tfMinuto.setText("");
					tfSegundos.setText("");
					lblImagem.setIcon(null);
					imagem = null;
				} else {
					JOptionPane.showMessageDialog(null, "Insira uma imagem e/ou um código");
				}
			}
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCadastrar.setBounds(514, 388, 150, 30);
		Cadastramento.add(btnCadastrar);
		
		JPanel Imagem = new JPanel();
		Imagem.setBounds(464, 29, 200, 200);
		Cadastramento.add(Imagem);
		
		lblImagem = new JLabel("");
		Imagem.add(lblImagem);
		
		JButton btnSelecionarImagem = new JButton("Selecionar Imagem...");
		btnSelecionarImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imagem = selecionarImagem();
				abrirImagem(imagem,lblImagem);
				
				
			}
		});
		btnSelecionarImagem.setBounds(464, 240, 200, 23);
		Cadastramento.add(btnSelecionarImagem);
		
		JPanel Deletar = new JPanel();
		contentPane.add(Deletar, "DELETAR");
		Deletar.setLayout(null);
		
		JButton btnVoltar_1 = new JButton("< Voltar");
		btnVoltar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfCodDel.setText("");
				trocaTela("HUB");
			}
		});
		btnVoltar_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar_1.setBounds(10, 383, 150, 30);
		Deletar.add(btnVoltar_1);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(p.checaCod(Main.CD, tfCodDel.getText())) {
					int index = p.getIndex(Main.CD,tfCodDel.getText());
					String[] menu = {"Confirmar","Cancelar"};
					int opt = JOptionPane.showOptionDialog(null, "Código encontrado, deseja mesmo deleta-lo?","Deletar Cadastro",JOptionPane.DEFAULT_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null,menu,menu[0]);
					if(opt == 0) {
						Main.CD.remove(index);
						JOptionPane.showMessageDialog(null, "Cadastro Deletado");
						tfCodDel.setText("");
					}
					
				} else {
					JOptionPane.showMessageDialog(null, "Código não encontrado");
				}
			}
		});
		btnDeletar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDeletar.setBounds(514, 383, 150, 30);
		Deletar.add(btnDeletar);
		
		JLabel lblDeletar = new JLabel("Insira o  C\u00F3digo de Identifica\u00E7\u00E3o do Cadastro para deleta-lo");
		lblDeletar.setHorizontalAlignment(SwingConstants.LEFT);
		lblDeletar.setFont(new Font("Arial", Font.BOLD, 14));
		lblDeletar.setBounds(10, 0, 454, 59);
		Deletar.add(lblDeletar);
		
		JLabel lblCod = new JLabel("C\u00F3digo de Identifica\u00E7\u00E3o");
		lblCod.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCod.setHorizontalAlignment(SwingConstants.CENTER);
		lblCod.setBounds(10, 68, 150, 30);
		Deletar.add(lblCod);
		
		tfCodDel = new JTextField();
		tfCodDel.setText("");
		tfCodDel.setBounds(171, 69, 210, 30);
		Deletar.add(tfCodDel);
		tfCodDel.setColumns(10);
		
		JPanel Consultar = new JPanel();
		Consultar.setLayout(null);
		contentPane.add(Consultar, "CONSULTAR");
		
				
		
		JLabel lblConsul = new JLabel("Insira o  C\u00F3digo de Identifica\u00E7\u00E3o do Cadastro para consulta-lo");
		lblConsul.setHorizontalAlignment(SwingConstants.LEFT);
		lblConsul.setFont(new Font("Arial", Font.BOLD, 14));
		lblConsul.setBounds(10, 0, 454, 59);
		Consultar.add(lblConsul);
		
		JLabel lblCod_1 = new JLabel("C\u00F3digo de Identifica\u00E7\u00E3o");
		lblCod_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblCod_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCod_1.setBounds(10, 68, 150, 30);
		Consultar.add(lblCod_1);
		
		tfCodCon = new JTextField();
		tfCodCon.setText("");
		tfCodCon.setColumns(10);
		tfCodCon.setBounds(171, 69, 210, 30);
		Consultar.add(tfCodCon);
		
		JLabel lblLat1 = new JLabel("Latitude");
		lblLat1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLat1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblLat1.setBounds(10, 127, 150, 30);
		Consultar.add(lblLat1);
		
		JLabel lblLat2 = new JLabel("");
		lblLat2.setForeground(Color.BLACK);
		lblLat2.setBackground(Color.BLACK);
		lblLat2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLat2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblLat2.setBounds(171, 125, 210, 30);
		Consultar.add(lblLat2);
		
		JLabel lblLong1 = new JLabel("Longitude");
		lblLong1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLong1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblLong1.setBounds(10, 186, 150, 30);
		Consultar.add(lblLong1);
		
		JLabel lblLong2 = new JLabel("");
		lblLong2.setHorizontalAlignment(SwingConstants.CENTER);
		lblLong2.setForeground(Color.BLACK);
		lblLong2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblLong2.setBackground(Color.BLACK);
		lblLong2.setBounds(171, 184, 210, 30);
		Consultar.add(lblLong2);
		
		JLabel lblData1 = new JLabel("Data");
		lblData1.setHorizontalAlignment(SwingConstants.CENTER);
		lblData1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblData1.setBounds(10, 248, 150, 30);
		Consultar.add(lblData1);
		
		JLabel lblData2 = new JLabel("");
		lblData2.setHorizontalAlignment(SwingConstants.CENTER);
		lblData2.setForeground(Color.BLACK);
		lblData2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblData2.setBackground(Color.BLACK);
		lblData2.setBounds(171, 248, 210, 30);
		Consultar.add(lblData2);
		
		JLabel lblHora1 = new JLabel("Hor\u00E1rio");
		lblHora1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblHora1.setBounds(10, 300, 150, 30);
		Consultar.add(lblHora1);
		
		JLabel lblHora2 = new JLabel("");
		lblHora2.setHorizontalAlignment(SwingConstants.CENTER);
		lblHora2.setForeground(Color.BLACK);
		lblHora2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblHora2.setBackground(Color.BLACK);
		lblHora2.setBounds(171, 300, 210, 30);
		Consultar.add(lblHora2);
		
		
				
		JPanel Imagem_1 = new JPanel();
		Imagem_1.setBackground(Color.WHITE);
		Imagem_1.setBounds(464, 29, 200, 200);
		Consultar.add(Imagem_1);
		
		JLabel lblImagem_1 = new JLabel("");
		Imagem_1.add(lblImagem_1);
		
		
		JPanel Atualizar = new JPanel();
		contentPane.add(Atualizar, "ATUALIZAR");
		Atualizar.setLayout(null);
		
		JLabel lblCadastramentoAtt = new JLabel("Insira as informa\u00E7\u00F5es para efetura a atualiza\u00E7\u00E3o no cadastramento");
		lblCadastramentoAtt.setBounds(10, 11, 478, 17);
		lblCadastramentoAtt.setHorizontalAlignment(SwingConstants.LEFT);
		lblCadastramentoAtt.setFont(new Font("Arial", Font.BOLD, 14));
		Atualizar.add(lblCadastramentoAtt);
		
		JLabel lblCodAtt = new JLabel("C\u00F3digo de Identifica\u00E7\u00E3o");
		lblCodAtt.setFont(new Font("Arial", Font.PLAIN, 14));
		lblCodAtt.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodAtt.setBounds(10, 60, 150, 30);
		Atualizar.add(lblCodAtt);
		
		tfCodAtt = new JTextField();
		tfCodAtt.setBounds(159, 61, 211, 30);
		Atualizar.add(tfCodAtt);
		tfCodAtt.setColumns(10);
		
		JLabel lblLatAtt = new JLabel("Latitude");
		lblLatAtt.setHorizontalAlignment(SwingConstants.CENTER);
		lblLatAtt.setFont(new Font("Arial", Font.PLAIN, 14));
		lblLatAtt.setBounds(10, 123, 150, 30);
		Atualizar.add(lblLatAtt);
		
		tfLatAtt = new JTextField();
		tfLatAtt.setColumns(10);
		tfLatAtt.setBounds(159, 124, 211, 30);
		Atualizar.add(tfLatAtt);
		
		JLabel lblLongAtt = new JLabel("Longitude");
		lblLongAtt.setHorizontalAlignment(SwingConstants.CENTER);
		lblLongAtt.setFont(new Font("Arial", Font.PLAIN, 14));
		lblLongAtt.setBounds(10, 182, 150, 30);
		Atualizar.add(lblLongAtt);
		
		tfLongAtt = new JTextField();
		tfLongAtt.setColumns(10);
		tfLongAtt.setBounds(159, 182, 211, 30);
		Atualizar.add(tfLongAtt);
		
		JLabel lblDataAtt = new JLabel("Data");
		lblDataAtt.setHorizontalAlignment(SwingConstants.CENTER);
		lblDataAtt.setFont(new Font("Arial", Font.PLAIN, 14));
		lblDataAtt.setBounds(10, 246, 150, 30);
		Atualizar.add(lblDataAtt);
		
		tfDiaAtt = new JTextField();
		tfDiaAtt.setToolTipText("dia");
		tfDiaAtt.setBounds(159, 247, 50, 30);
		Atualizar.add(tfDiaAtt);
		tfDiaAtt.setColumns(10);
		
		JLabel lblBarraAtt1 = new JLabel("/");
		lblBarraAtt1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBarraAtt1.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarraAtt1.setBounds(207, 247, 33, 30);
		Atualizar.add(lblBarraAtt1);
		
		tfMesAtt = new JTextField();
		tfMesAtt.setToolTipText("m\u00EAs");
		tfMesAtt.setColumns(10);
		tfMesAtt.setBounds(239, 247, 50, 30);
		Atualizar.add(tfMesAtt);
		
		JLabel lblBarraAtt2 = new JLabel("/");
		lblBarraAtt2.setHorizontalAlignment(SwingConstants.CENTER);
		lblBarraAtt2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblBarraAtt2.setBounds(289, 246, 33, 30);
		Atualizar.add(lblBarraAtt2);
		
		tfAnoAtt = new JTextField();
		tfAnoAtt.setToolTipText("ano");
		tfAnoAtt.setColumns(10);
		tfAnoAtt.setBounds(320, 247, 50, 30);
		Atualizar.add(tfAnoAtt);
		
		JLabel lblHoraAtt = new JLabel("Hor\u00E1rio");
		lblHoraAtt.setHorizontalAlignment(SwingConstants.CENTER);
		lblHoraAtt.setFont(new Font("Arial", Font.PLAIN, 14));
		lblHoraAtt.setBounds(10, 307, 150, 30);
		Atualizar.add(lblHoraAtt);
		
		tfHoraAtt = new JTextField();
		tfHoraAtt.setToolTipText("dia");
		tfHoraAtt.setColumns(10);
		tfHoraAtt.setBounds(159, 308, 50, 30);
		Atualizar.add(tfHoraAtt);
		
		JLabel lblPontoAtt1 = new JLabel(":");
		lblPontoAtt1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPontoAtt1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPontoAtt1.setBounds(207, 307, 33, 30);
		Atualizar.add(lblPontoAtt1);
		
		tfMinutoAtt = new JTextField();
		tfMinutoAtt.setToolTipText("dia");
		tfMinutoAtt.setColumns(10);
		tfMinutoAtt.setBounds(239, 308, 50, 30);
		Atualizar.add(tfMinutoAtt);
		
		JLabel lblPontoAtt2 = new JLabel(":");
		lblPontoAtt2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPontoAtt2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblPontoAtt2.setBounds(288, 307, 33, 30);
		Atualizar.add(lblPontoAtt2);
		
		tfSegundoAtt = new JTextField();
		tfSegundoAtt.setToolTipText("ano");
		tfSegundoAtt.setColumns(10);
		tfSegundoAtt.setBounds(320, 307, 50, 30);
		Atualizar.add(tfSegundoAtt);
		
				
		
		JPanel Imagem_2 = new JPanel();
		Imagem_2.setBounds(464, 39, 200, 200);
		Atualizar.add(Imagem_2);
		
		JLabel lblImagem_2 = new JLabel("");
		Imagem_2.add(lblImagem_2);
		
		JButton btnSelecionarImagem_1 = new JButton("Selecionar Imagem...");
		btnSelecionarImagem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				imagem = selecionarImagem();
				abrirImagem(imagem,lblImagem_2);
			}
		});
		btnSelecionarImagem_1.setBounds(464, 251, 200, 23);
		Atualizar.add(btnSelecionarImagem_1);
		
		JButton btnVoltarAtt = new JButton("< Voltar");
		btnVoltarAtt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfCodAtt.setText("");
				tfLatAtt.setText("");
				tfLongAtt.setText("");
				tfDiaAtt.setText("");
				tfMesAtt.setText("");
				tfAnoAtt.setText("");
				tfHoraAtt.setText("");
				tfMinutoAtt.setText("");
				tfSegundoAtt.setText("");
				lblImagem_2.setIcon(null);
				imagem = null;
				trocaTela("HUB");
			}
		});
		btnVoltarAtt.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltarAtt.setBounds(10, 388, 150, 30);
		Atualizar.add(btnVoltarAtt);
		
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(p.checaCod(Main.CD, tfCodAtt.getText())) {
					if(imagem != null && tfCodAtt.getText() != "") {
						int index = p.getIndex(Main.CD, tfCodAtt.getText());
						Cadastro cad = new Cadastro(tfCodAtt.getText(),tfLatAtt.getText(),tfLongAtt.getText(),(tfDiaAtt.getText() + "/"+ tfMesAtt.getText()+ "/" + tfAnoAtt.getText()), (tfHoraAtt.getText() + ":" + tfMinutoAtt.getText() + ":" + tfSegundoAtt.getText()),getImagem());
						Main.CD.set(index, cad);
						tfCodAtt.setText("");
						tfLatAtt.setText("");
						tfLongAtt.setText("");
						tfDiaAtt.setText("");
						tfMesAtt.setText("");
						tfAnoAtt.setText("");
						tfHoraAtt.setText("");
						tfMinutoAtt.setText("");
						tfSegundoAtt.setText("");
						lblImagem_2.setIcon(null);
						imagem = null;
						
					} else {
						JOptionPane.showMessageDialog(null, "Insira uma imagem e/ou um código");
					}
				} else {
					JOptionPane.showMessageDialog(null,"Código não encontrado");
				}
			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnAtualizar.setBounds(514, 388, 150, 30);
		Atualizar.add(btnAtualizar);
		
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String cod = tfCodCon.getText();
				System.out.println(cod);
				if(p.checaCod(Main.CD, cod) ) {
					int index = p.getIndex(Main.CD, cod);
					System.out.println("index = " +index);
					Cadastro c = Main.CD.get(index);
					System.out.println(c.toString());
					lblLat2.setText(c.getLat());
					lblLong2.setText(c.getLon());
					lblData2.setText(c.getData());
					lblHora2.setText(c.getHora());
					abrirImagem(c.getBit(),lblImagem_1,c);
					
				}
				else {
					JOptionPane.showMessageDialog(null, "Código não encontrado");
				}
			}
		});
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setBounds(514, 383, 150, 30);
		Consultar.add(btnConsultar);
		
		JButton btnVoltar_1_1 = new JButton("< Voltar");
		btnVoltar_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tfCodCon.setText("");
				lblLat2.setText("");
				lblLong2.setText("");
				lblData2.setText("");
				lblHora2.setText("");
				lblImagem_1.setIcon(null);
				trocaTela("HUB");
			}
		});
		btnVoltar_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnVoltar_1_1.setBounds(10, 383, 150, 30);
		Consultar.add(btnVoltar_1_1);
	}
	public void trocaTela(String layout) {
		CardLayout card = (CardLayout) contentPane.getLayout();
		card.show(contentPane,layout);
	}
	
	public File selecionarImagem() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagens em JPEG e PNG","jpg","png");
		fileChooser.addChoosableFileFilter(filtro);
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
		fileChooser.showOpenDialog(this);
		
		return fileChooser.getSelectedFile();
	}
	
	public byte[] getImagem() {
		boolean isPng = false;
		
		if(imagem != null) {
			isPng = imagem.getName().endsWith("png");
			try {
				BufferedImage image = ImageIO.read(imagem);
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				int type = BufferedImage.TYPE_INT_RGB;
				
				if(isPng) {
					type = BufferedImage.BITMASK;
				}
				
				BufferedImage novaImagem = new BufferedImage(195,195,type);
				Graphics2D g = novaImagem.createGraphics();
				g.setComposite(AlphaComposite.Src);
				g.drawImage(image, 0,0,195,195,null);
				
				if(isPng) {
					ImageIO.write(novaImagem,"png",out);
				} else {
					ImageIO.write(novaImagem,"jpg",out);
				}
				
				out.flush();
				byte[] byteArray = out.toByteArray();
				out.close();
				return byteArray;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	private void abrirImagem(Object source,JLabel lb) {
		if(source instanceof File) {
			ImageIcon icon = new ImageIcon(imagem.getAbsolutePath());
			icon.setImage(icon.getImage().getScaledInstance(195, 195,100));
			lb.setIcon(icon);
		} else if(source instanceof byte[]) {
			ImageIcon icon = new ImageIcon(getImagem());
			icon.setImage(icon.getImage().getScaledInstance(195, 195,100));
			lb.setIcon(icon);
		}
		
	}
	
	private void abrirImagem(Object source,JLabel lb, Cadastro c) {
		if(source instanceof File) {
			ImageIcon icon = new ImageIcon(imagem.getAbsolutePath());
			icon.setImage(icon.getImage().getScaledInstance(195, 195,100));
			lb.setIcon(icon);
		} else if(source instanceof byte[]) {
			ImageIcon icon = new ImageIcon(c.getBit());
			icon.setImage(icon.getImage().getScaledInstance(195, 195,100));
			lb.setIcon(icon);
		}
		
	}
}
