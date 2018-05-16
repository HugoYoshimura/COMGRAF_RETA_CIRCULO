package usjt.componentes;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class QuadroPrincipal extends JFrame {

	JTextField x1 = new JTextField();
	JTextField y1 = new JTextField();
	JTextField x2 = new JTextField();
	JTextField y2 = new JTextField();
	JTextField r = new JTextField();
	
	JButton botaoR;
	JButton botaoC;
	
	JPanel pr = new JPanel(new BorderLayout());
	JPanel pc = new JPanel(new BorderLayout());
	
	PainelRetaAlgoritmo pra = new PainelRetaAlgoritmo();
	PainelRetaJava prj = new PainelRetaJava();
	PainelCirculoAlgoritmo pca = new PainelCirculoAlgoritmo();
	PainelCirculoJava pcj = new PainelCirculoJava();

	/**
	 * Componente de interface grafica com usuario.
	 * Esta classe gera uma janela com paineis para cada exemplo de 'plot'.
	 * 		para retas: DDA, drawLine (java)
	 * 		para circulos: SENeCOS, drawOval (java)
	 * */
	public QuadroPrincipal(){
		 this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		 
		 this.add(new JLabel("Atenção:    Usar valores no intervalo [0, 200]"),
				 			 BorderLayout.NORTH);

		 pr.setLayout(new BorderLayout());
		 pc.setLayout(new BorderLayout());
		 
		 pr.add(new JLabel("RETA", SwingConstants.CENTER), BorderLayout.NORTH);
		 pr.add(camposReta(), BorderLayout.SOUTH);
		 pc.add(new JLabel("CÍRCULO", SwingConstants.CENTER), BorderLayout.NORTH);
		 pc.add(camposCirculo(), BorderLayout.SOUTH);
		 
		 Dimension minimumDrawSize = new Dimension(300, 600);
		 
		 pra.add(new JLabel("Reta DDA", SwingConstants.CENTER), BorderLayout.NORTH);
		 prj.add(new JLabel("Reta Java", SwingConstants.CENTER), BorderLayout.NORTH);
		 
		 JSplitPane splitRetaPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pra, prj);
		 splitRetaPane.setDividerLocation(300);
		 pra.setMinimumSize(minimumDrawSize);
		 prj.setMinimumSize(minimumDrawSize);
		 
		 pr.add(splitRetaPane, BorderLayout.CENTER);
		 
		 pca.add(new JLabel("Círculo Sen/Cos", SwingConstants.CENTER), BorderLayout.NORTH);
		 pcj.add(new JLabel("Círculo Java", SwingConstants.CENTER), BorderLayout.NORTH);
		 
		 JSplitPane splitCirculoPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pca, pcj);
		 splitCirculoPane.setDividerLocation(300);
		 pca.setMinimumSize(minimumDrawSize);
		 pcj.setMinimumSize(minimumDrawSize);
		 
		 pc.add(splitCirculoPane, BorderLayout.CENTER);
		 
		 JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pr, pc);
		 splitPane.setDividerLocation(600);
		 Dimension minimumSize = new Dimension(700, 600);
		 pr.setMinimumSize(minimumSize);
		 pc.setMinimumSize(minimumSize);
		 
		 this.add(splitPane, BorderLayout.CENTER);
		 this.setSize( 1260, 450 );
		 this.setVisible( true );
	}
	
	/**
	 * cria campos para o painel e atribui evento ao botao para desenhar
	 * a reta
	 * campos do painel:
	 * 		labels para: x1, y1, x2, y2
	 * 		entrada para: x1, y1, x2, y2
	 * 		botao "reta" com evento para desenhar a reta no quadro
	 * */
	public JComponent camposReta(){
		JPanel campos = new JPanel(new BorderLayout(5, 5));
		botaoR = new JButton("reta");
		botaoR.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == botaoR) {
					pra.setDesenhar(true);
					pra.reta(Double.parseDouble(x1.getText()), 
							 Double.parseDouble(y1.getText()),
							 Double.parseDouble(x2.getText()),
							 Double.parseDouble(y2.getText()));
					pra.repaint();
					
					prj.setDesenhar(true);
					prj.reta(Double.parseDouble(x1.getText()), 
							 Double.parseDouble(y1.getText()),
							 Double.parseDouble(x2.getText()),
							 Double.parseDouble(y2.getText()));
					prj.repaint();
				}
			}
		});
		
		campos.add(entradaReta(), BorderLayout.CENTER);
		campos.add(botaoR, BorderLayout.SOUTH);
		return campos;
	}
	
	
	/**
	 * cria campos para o painel e atribui evento ao botao para desenhar
	 * o circulo
	 * campos do painel:
	 * 		labels para: raio
	 * 		entrada para: raio
	 * 		botao "circulo" com evento para desenhar o circulo no quadro
	 * */
	public JComponent camposCirculo(){
		JPanel campos = new JPanel(new BorderLayout(5, 5));
		botaoC = new JButton("circulo");
		botaoC.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (e.getSource() == botaoC) {
					pca.circulo(Double.parseDouble(r.getText()));
					pca.repaint();
					
					pcj.circulo(Double.parseDouble(r.getText()));
					pcj.repaint();
				}
			}
		});
		
		campos.add(entradaCirculo(), BorderLayout.CENTER);
		campos.add(botaoC, BorderLayout.SOUTH);
		return campos;
	}
	
	public JComponent entradaReta(){
		JPanel entrada = new JPanel(new GridLayout(2, 4));
		entrada.add(new JLabel("x1", SwingConstants.CENTER));
		entrada.add(x1);
		entrada.add(new JLabel("y1", SwingConstants.CENTER));
		entrada.add(y1);
		entrada.add(new JLabel("x2", SwingConstants.CENTER));
		entrada.add(x2);
		entrada.add(new JLabel("y2", SwingConstants.CENTER));
		entrada.add(y2);
		return entrada;
	}
	
	public JComponent entradaCirculo(){
		JPanel entrada = new JPanel(new GridLayout(2, 4));
		entrada.add(new JLabel("raio", SwingConstants.CENTER));
		entrada.add(r);
		return entrada;
	}
}
