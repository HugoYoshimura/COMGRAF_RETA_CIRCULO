package usjt.componentes;
import java.awt.Graphics;

import javax.swing.JPanel;

public class PainelCirculoAlgoritmo  extends JPanel{
	double raio;

	public PainelCirculoAlgoritmo(){
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

		for(int i = 0; i < 46; i++) {
			x = raio * Math.cos(i);
			y = raio * Math.sin(i);
			g.drawOval(( (int)x) + 150, 150 - ( (int)y), 1, 1); // ( x,  y)
			g.drawOval(( (int)y) + 150, 150 - ( (int)x), 1, 1);	// ( y,  x)
			g.drawOval(( (int)y) + 150, 150 - (-(int)x), 1, 1);	// ( y, -x)
			g.drawOval(( (int)x) + 150, 150 - (-(int)y), 1, 1);	// ( x, -y)
			g.drawOval((-(int)x) + 150, 150 - (-(int)y), 1, 1);	// (-x, -y)
			g.drawOval((-(int)y) + 150, 150 - (-(int)x), 1, 1);	// (-y, -x)
			g.drawOval((-(int)y) + 150, 150 - ( (int)x), 1, 1);	// (-y,  x)
			g.drawOval((-(int)x) + 150, 150 - ( (int)y), 1, 1);	// (-x,  y)
		}
	}
}
