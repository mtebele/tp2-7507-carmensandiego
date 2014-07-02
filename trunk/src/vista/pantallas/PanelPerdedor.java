package vista.pantallas;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import vista.botonesGenericos.BotonMenuPrincipal;
import vista.botonesGenericos.BotonSalirJuego;

import javax.swing.JLabel;
import javax.swing.SpringLayout;

import vista.panelesGenericos.PanelConFondo;

public class PanelPerdedor extends PanelConFondo {

	private static final long serialVersionUID = -8392658315975218132L;
	private static final String IMGPATH = "images/";
	static final String FONDO = IMGPATH + "perdedor.png";
	private BotonMenuPrincipal botonSaltarInicio = new BotonMenuPrincipal();
	private BotonSalirJuego btnSalirJuego = new BotonSalirJuego();
	private JLabel mensajePerdiste = new JLabel("NO HAS PODIDO ATRAPAR AL LADRON");

	public PanelPerdedor() {
		super(FONDO);
		SpringLayout springLayout = new SpringLayout();
		springLayout.putConstraint(SpringLayout.SOUTH, botonSaltarInicio, -60, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, botonSaltarInicio, -450, SpringLayout.EAST, this);
		setLayout(springLayout);
		this.add(botonSaltarInicio);
		springLayout.putConstraint(SpringLayout.SOUTH, btnSalirJuego, -60, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, btnSalirJuego, -250, SpringLayout.EAST, this);
		this.add(btnSalirJuego);
		springLayout.putConstraint(SpringLayout.SOUTH, mensajePerdiste, -400, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, mensajePerdiste, -100, SpringLayout.EAST, this);
		mensajePerdiste.setFont(new Font("Trebuchet MS", Font.BOLD, 32));
		mensajePerdiste.setForeground(Color.WHITE);
		this.add(mensajePerdiste);

	}
	
	public void addVolverAPanelInicialListener(ActionListener l) {
		botonSaltarInicio.addActionListener(l);
	}

	public void addSalirJuegoListener(ActionListener l) {
		btnSalirJuego.addActionListener(l);
	}
	
}