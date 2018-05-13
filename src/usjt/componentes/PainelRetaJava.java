package usjt.componentes;

import java.awt.Graphics;
import javax.swing.JPanel;

public class PainelRetaJava extends JPanel {

	double x1, y1, x2, y2;
	boolean desenhar;
	
	public PainelRetaJava(){
		this.x1=50 ;
		this.y1=50;
		this.x2=50 ;
		this.y2=50;
		this.desenhar = false;
	}
	
	public void setDesenhar(boolean desenhar) {
		this.desenhar = desenhar;
	}
	
	public void reta(double x1, double y1, double x2, double y2){
		this.x1=x1 ;
		this.y1=y1;
		this.x2=x2 ;
		this.y2=y2;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawLine(50, 50, 250, 50);
		g.drawLine(50, 250, 250, 250);
		g.drawLine(50, 50,50, 250);
		g.drawLine(250,50,250,250);
		for(int i = 50; i < 251; i++) {
			g.drawOval(i, 150, 1, 1);
			g.drawOval(150, i, 1, 1);
			i += 2;
		}
		
		g.drawLine((int)x1+150,150-(int)y1,(int)x2+150,150-(int)y2);
		
	}
	
	
}
