package Juego;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class MechaBarra extends Mecha {
	BotonMechaBarra b = new BotonMechaBarra();
	boolean conectaDer;
	boolean conectaIzq;
	
	public MechaBarra(){
		conectaDer = false;
		conectaIzq = false;
		
		izquierda = true;
		derecha = true;
		arriba = false;
		abajo = false;
		
		uIzquierda = false;
		uDerecha = false;
		uArriba = false;
		uAbajo = false;
		
		conectado = false;
		revisado = false;
		anulado = false;
		
		usado = false;
	}
	
	public void vuelta (){
		
		if(derecha == true){
			izquierda = false;
			derecha = false;
			arriba = true;
			abajo = true;
		}
		
		else if(arriba == true){
			izquierda = true;
			derecha = true;
			arriba = false;
			abajo = false;
		}
		//System.out.println(izquierda);
	}
	
	public boolean iz(){
		return izquierda;
	}
	
	public JButton getBoton(){
		return b;
	}
	
	public void giro(){
		b.gira();
	}
	
	@Override
	public void setConectaDer(boolean b) {
		this.conectaDer = b;
		if(conectaDer == true){
			this.b.cambioAmarillo();
			if(conectaIzq==true){
				this.b.cambioNaranja();
				conectado = true;
			}
		}
		else if (conectaIzq == false){
			this.b.cambioGris();
		}
	}

	@Override
	public boolean getConectaDer() {
		
		return this.conectaDer;
	}
	
	public void setConectaIzq(boolean b) {
		this.conectaIzq = b;
		
		if(conectaIzq == true){
			//System.out.println("pasa!!");
			this.b.cambioRojo();
			if(conectaDer==true){
				this.b.cambioNaranja();
				conectado = true;
			}
		}
		else if (conectaDer == false){
			this.b.cambioGris();
		}
					
	}
	
	@Override
	public boolean getConectaIzq() {

		return this.conectaIzq;
	}
	
	@Override
	public boolean der() {
		// TODO Auto-generated method stub
		return this.derecha;
	}

	@Override
	public boolean up() {
		// TODO Auto-generated method stub
		return this.arriba;
	}

	@Override
	public boolean down() {
		// TODO Auto-generated method stub
		return this.abajo;
	}

	@Override
	public void setUnidoIz(boolean b) {
		this.uIzquierda = b;
		
	}

	@Override
	public void setUnidoDer(boolean b) {
		this.uDerecha = b;
		
	}

	@Override
	public void setUnidoUp(boolean b) {
		this.uArriba = b;
		
	}

	@Override
	public void setUnidoDown(boolean b) {
		this.uAbajo = b;
		
	}

	@Override
	public boolean getUnidoIz() {
		return this.uIzquierda;
	}

	@Override
	public boolean getUnidoDer() {
		return this.uDerecha;
	}

	@Override
	public boolean getUnidoUp() {
		return this.uArriba;
	}

	@Override
	public boolean getUnidoDown() {
		return this.uAbajo;
	}

	@Override
	public void anular() {
		// TODO Auto-generated method stub
		b.setVacio();
		anulado = true;
	}

	@Override
	public void moneda(int val) {
		// TODO Auto-generated method stub
		coin = val;
		b.setMoneda(coin);
		usado = true;	
	}

	@Override
	public int cogida() {
		// TODO Auto-generated method stub
		usado = false;
		b.agarrada();
		int dev = coin;
		coin = 0;
		return dev;
	}


	
}