package usjt.componentes;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PainelCirculoJava  extends JPanel{
	double raio;

	public PainelCirculoJava(){
		this.raio=0 ;
	}

	public void circulo(double raio){
		this.raio=raio;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		double x, y;
		
		g.drawLine(50, 50, 250, 50);
		g.drawLine(50, 250, 250, 250);
		g.drawLine(50, 50,50, 250);
		g.drawLine(250,50,250,250);
		for(int i = 50; i < 251; i++) {
			g.drawOval(i, 150, 1, 1);
			g.drawOval(150, i, 1, 1);
			i += 2;
		}
		
		g.drawOval(150 - (int)raio, 150 - (int)raio, (int)raio * 2, (int)raio * 2);
		
	}
}
