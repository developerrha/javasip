
package pkgdir.control;

import pkgdir.modelo.MysqlServices;
import pkgdir.graficos.GuiMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;


public class Controller implements ActionListener{

	private GuiMenu guiMenul;
	private MysqlServices msqlserv;
	private String selected;

	/**
     * Constructor sin parametros
     * @see empty
     */
    public Controller() {
        super();
    }

	/**
	* Constructor GuiMenu como parametros
	* @param GuiMenu
	*/
	public Controller(GuiMenu guiMenu) {
		super();
		this.guiMenul = guiMenu;
		agregarEventos();		
	}

	/**
     * Metodo que administra los eventos sobre los componentes
	* pertenece a la clase ActionListener
     * @param ae
     */
    @Override
	public void actionPerformed(ActionEvent ae) {
		/*
		* Evento sobre boton Leer
		*/
		if( ae.getSource() == guiMenul.getBotonRead()){
			if( selected == null ){
				return;
			}
			if( selected.equals( "Archivo plano" ) ){
			}else if( selected.equals( "Base de datos" ) ){
				msqlserv = new MysqlServices();
				guiMenul.gettextAreaRead().setText( msqlserv.getDataFromMysql() );	
			}
	   	}
		/*
		* Evento sobre item salir
		*/
		if( ae.getSource() == guiMenul.getItemExit()){
			System.exit(0);
	   	}
		/*
		* Evento sobre item Txt
		*/
		if( ae.getSource() == guiMenul.getItemTxt()){
			System.out.println("Soy Txt");
			guiMenul.getMainJPanel().removeAll();
			guiMenul.getMainJPanel().add(Box.createVerticalStrut(10));
			guiMenul.getMainJPanel().add(  guiMenul.getTxtJPanel() );	
			guiMenul.getMainJPanel().revalidate();
			guiMenul.getMainJPanel().repaint();
			selected = guiMenul.getItemTxt().getText();
	   	}
		/*
		* Evento sobre item DB
		*/
		if( ae.getSource() == guiMenul.getItemDB()){
			System.out.println("Soy BD");
			guiMenul.getMainJPanel().removeAll();
			guiMenul.getMainJPanel().add(Box.createVerticalStrut(10));
			guiMenul.getMainJPanel().add(  guiMenul.getDBJPanel() );	
			guiMenul.getMainJPanel().revalidate();
			guiMenul.getMainJPanel().repaint();
			selected = guiMenul.getItemDB().getText();
	   	}
		/*
		* Evento sobre item salir
		*/
		if( ae.getSource() == guiMenul.getItemEncr()){
			System.out.println("Soy Encry");
			guiMenul.getMainJPanel().removeAll();
			guiMenul.getMainJPanel().add(Box.createVerticalStrut(10));
			guiMenul.getMainJPanel().add(  guiMenul.getEncryptJPanel() );	
			guiMenul.getMainJPanel().revalidate();
			guiMenul.getMainJPanel().repaint();
			selected = guiMenul.getItemDB().getText();
	   	}
	}

	
	/**
     * Metodo que agrega eventos sobre los componentes de GuiMenu
     */
	private void agregarEventos(){
		guiMenul.getItemExit().addActionListener(this);
		guiMenul.getItemTxt().addActionListener(this);
		guiMenul.getItemDB().addActionListener(this);
		guiMenul.getBotonRead().addActionListener(this);
		guiMenul.getItemEncr().addActionListener(this);
	}












}
