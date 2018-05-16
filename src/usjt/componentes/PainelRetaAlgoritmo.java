package usjt.componentes;

import java.awt.Graphics;
import javax.swing.JPanel;

public class PainelRetaAlgoritmo extends JPanel {

	// define par de variaveis para cada ponto da reta
	double x1, y1, x2, y2;
	// flag para permitir desenhar a reta
	boolean desenhar;
	
	/**
	 * Construtor padrao com valores iniciados no canto superior esquerdo
	 * do espaço dimencionado para a 'plotar' a reta.
	 * Neste a flag desenhar eh iniciada com false, para que nada seja
	 * desenhado ao instanciar este JPanel
	 * */
	public PainelRetaAlgoritmo(){
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
	
	/**
	 * Desenha um quadro (200x200) afim de exibir um plano com os eixos
	 * x e y.
	 *
	 * */
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
		
		if(desenhar) {
			drawLine(g);
		}
		
		desenhar = false;
		
	}

	/**
	 * desenha uma reta utilizando o metodo DDA.
	 * utiliza como pontos para a reta os valores atribuidos as
	 * variaveis globais (x1, y1) e (x2, y2)
	 * */
	public void drawLine(Graphics g) {
		double x, y, inic, fim, dx, dy, m, calcX, calcY;
		boolean mode = true;
		
		calcX = 0.0;
		calcY = 0.0;
		x = x1;
		y = y1;
		dx = x2 - x1;
		dy = y2 - y1;
		m = Math.abs(dy) / Math.abs(dx);
		double mAbs = dy/dx;
		
		// g.drawLine((int)x1+150, 150-(int)y1, (int)x2+150, 150-(int)y2);
		
		if(m > 1) {
			inic = y1;
			fim = y2;
			if(dy >= 0) {
				calcX = 1 / (dy / dx);
				calcY = 1;
				mode = true;
			} else {
				calcX = Math.abs(1 / (dy / dx));
				calcY = -1;
				mode = false;
			}
		} else {
			inic = x1;
			fim = x2;
			calcX = 1;
			calcY = dy/dx;
			mode = true;
		}
		double cont = inic;
		if(mode) {
			do {
				g.drawOval((int)(Math.round(x)+150), (int)(150-Math.round(y)), 1, 1);
				x += calcX;
				y += calcY;
				// System.out.println("x = " + x + "\ny = " + y);
				cont++;
			} while(cont < fim);
		} else {
			do {
				g.drawOval((int)(Math.round(x)+150), (int)(150-Math.round(y)), 1, 1);
				x += calcX;
				y += calcY;
				cont--;
				// System.out.println("x = " + x + "\ny = " + y);
			} while(cont > fim);
		}
	}
}
