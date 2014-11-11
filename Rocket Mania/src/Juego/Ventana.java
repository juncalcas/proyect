package Juego;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.w3c.dom.events.MouseEvent;


//david atope

public class Ventana extends JFrame implements  MouseListener {
	JPanel w = new JPanel();
	ImageIcon ama = new ImageIcon("Imagenes/barraA.png");
	int dimension = 10;
	int y = 0;
	int x = 0;
	private JButton[][] matrizBotones;
	private Mecha[][] matrizMechas;
	public Ventana(){
		setSize(50*dimension,50*dimension);
		//w.setLayout(new GridLayout(dimension, dimension));
		w.setLayout(null);
		add(w);
		//MechaBarra b = new MechaBarra();
		//w.add(b.getBoton());
		this.matrizMechas = new Mecha[dimension][dimension];
		this.matrizBotones = new JButton[dimension][dimension];
		//this.matrizBotones = new BotonMechaBarra[dimension][dimension];
		for (int i = 0; i < this.dimension; i++){
			for (int j = 0; j < this.dimension; j++){
				//if(random == 0)
				Random r = new Random();
				int ran = r.nextInt(4) ;
				if (ran == 0) {
					MechaBarra m = new MechaBarra();
					this.matrizMechas[i][j] = m;
					this.matrizBotones[i][j] = m.getBoton();
					//this.matrizMechas[i][j] = new MechaBarra();
					//this.matrizBotones[i][j] = ((MechaBarra) matrizMechas[i][j]).getBoton();
					matrizBotones[i][j].setBounds(i*50, j*50, 50, 50);
			
				}
				else if (ran == 1) {
					//this.matrizMechas[i][j] = new MechaCruz();
					//this.matrizBotones[i][j] = matrizMechas[i][j].getBoton();
					//matrizBotones[i][j].setBounds(i*50, j*50, 50, 50);
					MechaL m = new MechaL();
					this.matrizMechas[i][j] = m;
					this.matrizBotones[i][j] = m.getBoton();
					matrizBotones[i][j].setBounds(i*50, j*50, 50, 50);
			
				}
				else if (ran == 2) {
					//this.matrizMechas[i][j] = new MechaCruz();
					//this.matrizBotones[i][j] = ((MechaCruz) matrizMechas[i][j]).getBoton();
					//matrizBotones[i][j].setBounds(i*50, j*50, 50, 50);
					MechaCruz m = new MechaCruz();
					this.matrizMechas[i][j] = m;
					this.matrizBotones[i][j] = m.getBoton();
					matrizBotones[i][j].setBounds(i*50, j*50, 50, 50);
				}
				else if (ran == 3) {
					MechaT m = new MechaT();
					this.matrizMechas[i][j] = m;
					this.matrizBotones[i][j] = m.getBoton();
					matrizBotones[i][j].setBounds(i*50, j*50, 50, 50);
				}
				
				w.add(matrizBotones[i][j]);
				matrizBotones[i][j].addMouseListener(this);
				System.out.println(ran);
				//this.matrizBotones[i][j] = new BotonMechaBarra();
				//Creamos un panel en el que metemos todos los botones que se han creado
				//le agregamos el listener a cada uno de lo botones	
				if(i==1 && j>0 && j<dimension-1){
					System.out.println("Paso 1");
					if(matrizMechas[i][j].iz()==true){
						System.out.println("Paso 2");
						matrizMechas[i][j].setConecta(true);
					}
					else{
						matrizMechas[i][j].setConecta(false);
					}
					
					//actualizar();
					
						
				}
			}
		} 
	}
	
	
	public static void main(String[] args) {
		Ventana v = new Ventana();
		v.setVisible(true);
	}
	
	public void revArriba(){
		
		for (int i = 0; i < this.dimension; i++){
			for (int j = 0; j < this.dimension; j++){
					
				if(j>0&&j<dimension-1 && i>0&&i<dimension-1){
		
						if(matrizMechas[i][j-1].down() == true && matrizMechas[i][j].up()==true ){
							
							matrizMechas[i][j].setUnidoUp(true);
							//System.out.println(matrizMechas[i][j-1].down()+"pasa bool de "+j);
						}
						
						else {
							matrizMechas[i][j].setUnidoUp(false);
							//System.out.println(matrizMechas[i][j-1].down()+"NO pasa bool de "+j);
						}
						
					}	
				}
			}
		
	}
	
public void revAbajo(){
		
		for (int i = 0; i < this.dimension; i++){
			for (int j = 0; j < this.dimension; j++){
					
				if(j>0&&j<dimension-1 && i>0&&i<dimension-1){
		
						if(matrizMechas[i][j+1].up() == true && matrizMechas[i][j].down()==true ){
							
							matrizMechas[i][j].setUnidoDown(true);
							//System.out.println(matrizMechas[i][j-1].down()+"pasa bool de "+j);
						}
						
						else {
							matrizMechas[i][j].setUnidoDown(false);
							//System.out.println(matrizMechas[i][j-1].down()+"NO pasa bool de "+j);
						}
						
					}	
				}
			}
		
	}

	public void revDer(){
	
	for (int i = 0; i < this.dimension; i++){
		for (int j = 0; j < this.dimension; j++){
				
			if(j>0&&j<dimension-1 && i>0&&i<dimension-1){
	
					if(matrizMechas[i+1][j].iz() == true && matrizMechas[i][j].der()==true ){
						
						matrizMechas[i][j].setUnidoDer(true);
						//System.out.println(matrizMechas[i][j-1].down()+"pasa bool de "+j);
					}
					
					else {
						matrizMechas[i][j].setUnidoDer(false);
						//System.out.println(matrizMechas[i][j-1].down()+"NO pasa bool de "+j);
					}
					
				}	
			}
		}
	}
	
	public void revIz(){
	
	for (int i = 0; i < this.dimension; i++){
		for (int j = 0; j < this.dimension; j++){
				
			if(j>0&&j<dimension-1 && i>0&&i<dimension-1){
	
					if(matrizMechas[i-1][j].der() == true && matrizMechas[i][j].iz()==true ){
						
						matrizMechas[i][j].setUnidoIz(true);
						//System.out.println(matrizMechas[i][j-1].down()+"pasa bool de "+j);
					}
					
					else {
						matrizMechas[i][j].setUnidoIz(false);
						//System.out.println(matrizMechas[i][j-1].down()+"NO pasa bool de "+j);
					}
					
				}	
			}
		}
	
	}
	
	
	
	public void revConecta(){
		for (int i = 0; i < this.dimension; i++){
			for (int j = 0; j < this.dimension; j++){
					
				if(j>0 &&j<dimension-1 && i>0 && i<dimension-1){
					
					if(i==1 && matrizMechas[i][j].iz()==false){
						matrizMechas[i][j].setConecta(false);
					}
					
					
						if(matrizMechas[i][j-1].getConecta() == true && matrizMechas[i][j].getUnidoUp() == true) {
							matrizMechas[i][j].setConecta(true);
						}
						
						else if(matrizMechas[i][j+1].getConecta() == true && matrizMechas[i][j].getUnidoDown() == true) {
							
							matrizMechas[i][j].setConecta(true);
						}
						
						else if(matrizMechas[i+1][j].getConecta() == true && matrizMechas[i][j].getUnidoDer() == true) {
							
							matrizMechas[i][j].setConecta(true);
						}
						
						else if(matrizMechas[i-1][j].getConecta() == true && matrizMechas[i][j].getUnidoIz() == true) {
							
							matrizMechas[i][j].setConecta(true);
						}
						
						
						else{
							if(i==1){
								if(matrizMechas[i][j].iz()==false && matrizMechas[i][j].getUnidoUp()==false){
									if(matrizMechas[i][j].getUnidoUp()==false){
										if(matrizMechas[i][j].getUnidoIz()==false){
											if(matrizMechas[i][j].getUnidoDer()==false){
												matrizMechas[i][j].setConecta(false);
											}
										}
									}
								}																
							}
							
							else{
								matrizMechas[i][j].setConecta(false);
							}
						}
					}	
				}
			}
	}
		
			
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		
		for (int i = 0; i < this.dimension; i++){
			for (int j = 0; j < this.dimension; j++){
				if(e.getSource()== matrizBotones[i][j])
				{
					
					 matrizMechas[i][j].giro();
					 matrizMechas[i][j].vuelta();
					System.out.println( matrizMechas[i][j].iz());
					w.repaint();
					//((BotonMechaBarra) matrizBotones[i][j]).gira();
					
					if(i==1 && j>0 && j<dimension-1){
						//System.out.println("Paso 1");
						if(matrizMechas[i][j].iz()==true){
						//	System.out.println("Paso 2");
							matrizMechas[i][j].setConecta(true);
						}
						else{
							matrizMechas[i][j].setConecta(false);
							
						}
							
					}
					
					revIz();
					//revDer();
					revArriba();
					revAbajo();
					revConecta();
					//System.out.println(matrizMechas[i][j].down());
					System.out.println("Empieza");
					System.out.println("iz "+matrizMechas[i][j].getUnidoIz());
					System.out.println("der "+matrizMechas[i][j].getUnidoDer());
					System.out.println("ab "+matrizMechas[i][j].getUnidoDown());
					System.out.println("ar "+matrizMechas[i][j].getUnidoUp());
					
				}
			}
		}	
	}
	
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
	}
	
}
