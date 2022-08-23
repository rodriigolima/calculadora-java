package calc.visao;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import calc.modelo.Memoria;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener {
	
	private final Color COR_CINZA_ESCURO = new Color(50, 50, 50);
	private final Color COR_CINZA_CLARO = new Color(59, 59, 59);
	private final Color COR_AZUL = new Color(76, 194, 255);

	public Teclado() {
		setBackground(new Color(32, 32, 32));
		
		
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		setLayout(layout);
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.BOTH;
		
		// Linha 1
		c.gridwidth = 3;
		adicionarBotao("CE", COR_CINZA_ESCURO, c, 0, 0);
		c.gridwidth = 1; 
		adicionarBotao("<-", COR_CINZA_ESCURO, c, 3, 0);
		
		// Linha 2
		
		adicionarBotao("1/x", COR_CINZA_ESCURO, c, 0, 1);
		adicionarBotao("x²", COR_CINZA_ESCURO, c, 1, 1);
		adicionarBotao("²√x", COR_CINZA_ESCURO, c, 2, 1);
		adicionarBotao("/", COR_CINZA_ESCURO, c, 3, 1);

		// Linha 3
		
		adicionarBotao("7", COR_CINZA_CLARO, c, 0, 2);
		adicionarBotao("8", COR_CINZA_CLARO, c, 1, 2);
		adicionarBotao("9", COR_CINZA_CLARO, c, 2, 2);
		adicionarBotao("x", COR_CINZA_ESCURO, c, 3, 2);

		// Linha 4

		adicionarBotao("4", COR_CINZA_CLARO, c, 0, 3);
		adicionarBotao("5", COR_CINZA_CLARO, c, 1, 3);
		adicionarBotao("6", COR_CINZA_CLARO, c, 2, 3);
		adicionarBotao("-", COR_CINZA_ESCURO, c, 3, 3);

		// Linha 5
		
		adicionarBotao("1", COR_CINZA_CLARO, c, 0, 4);
		adicionarBotao("2", COR_CINZA_CLARO, c, 1, 4);
		adicionarBotao("3", COR_CINZA_CLARO, c, 2, 4);
		adicionarBotao("+", COR_CINZA_ESCURO, c, 3, 4);

		// Linha 6
		
		adicionarBotao("±", COR_CINZA_CLARO, c, 0, 5);
		adicionarBotao("0", COR_CINZA_CLARO, c, 1, 5);
		adicionarBotao(",", COR_CINZA_CLARO, c, 2, 5);
		adicionarBotao("=", COR_AZUL, c, 3, 5);				
	}

	private void adicionarBotao(String texto, Color cor, GridBagConstraints c, int x, int y) {
		c.gridx = x;
		c.gridy = y;
		Botao botao = new Botao(texto, cor);
		botao.addActionListener(this);
		add(botao, c);				
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() instanceof JButton) {			
			JButton botao = (JButton) e.getSource();
			Memoria.getInstancia().processarComando(botao.getText());
		}
		
	}
}