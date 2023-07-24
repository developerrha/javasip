package pkgdir.graficos;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.awt.Dimension;
import javax.imageio.ImageIO;
import java.net.URL;
import java.awt.Component;
import java.awt.Toolkit;


public class GuiDatabase extends JPanel{
	private JLabel labText;
	private JButton butReadDb;
	private JTextArea areaRead;
	private JScrollPane scrollRead;
	private JTable tableDb;
	private JScrollPane scrollTableDb;


	/**
	*Metodo constructor de la clase		
	*/
	public GuiDatabase() {
	}

	/**
	*Metodo que pinta el JPanel		
	*Retorna vacio
	*/
	public void showPanel(){
		try{
		     this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
			this.setBackground( new Color( 146, 168, 73 , 30 ) );
			this.setPreferredSize(new Dimension(750, 450));
		     this.setMaximumSize(new Dimension(750, 450));
			this.add(Box.createVerticalStrut(10));
			this.add( drawLabText()  );
			this.add(Box.createVerticalStrut(10));
			this.add(drawAreaRead());
			this.add(Box.createVerticalStrut(10));
			this.add( drawButtonReadDb() );
			this.add(Box.createVerticalStrut(10));
			this.add( drawTableData() );
			this.add(Box.createVerticalStrut(10));
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	*Metodo que pinta el JLabel labText
	*Retorna JLabel
	*/
	private JLabel drawLabText(){
		try{
			labText = new JLabel( "Editor de sentencias Query" );
			labText.setBackground( new Color( 168, 168, 73, 50 ) );
			labText.setFont(labText.getFont().deriveFont(Font.BOLD | Font.ITALIC));
			labText.setAlignmentX(this.CENTER_ALIGNMENT);
		}catch(Exception e){
			e.printStackTrace();
		}
		return labText;
	}
	/**
	*Metodo que pinta el JButton butReadDb
	*Retorna JButton
	*/
	private JButton drawButtonReadDb(){
		try{
		     URL url = GuiMenu.class.getResource("../../res/read_bl.png");
		     BufferedImage img = ImageIO.read(url);
			butReadDb = new JButton("Ejecutar Query",new ImageIcon(img));
			butReadDb.setBackground( new Color( 168, 168, 73, 50 ) );
			butReadDb.setFont(butReadDb.getFont().deriveFont(Font.BOLD | Font.ITALIC));
			butReadDb.setAlignmentX(this.CENTER_ALIGNMENT);
			butReadDb.setFocusPainted(true);
		}catch(Exception e){
			e.printStackTrace();
		}
		return butReadDb;
	}
	/**
	*Metodo que pinta el JTextArea dentro de un JScrollPane
	*Retorna JScrollPane
	*/
	private JScrollPane drawAreaRead(){
		JScrollPane scrollReadL = new JScrollPane();
		try{
			areaRead = new JTextArea();
			areaRead.setEditable(true);
			areaRead.setBackground( new Color( 168, 168, 73 ) );
			areaRead.requestFocus();
			scrollReadL = new JScrollPane(areaRead);
			areaRead.setFont(new Font("Serif", Font.PLAIN, 14));
			scrollReadL.setPreferredSize(new Dimension(550, 100));
			scrollReadL.setMaximumSize(new Dimension(550, 100));
			scrollReadL.getViewport().setOpaque(false);
			scrollReadL.setOpaque(false);
		}catch(Exception e){
			e.printStackTrace();
		}
		return scrollReadL;
	}
	/**
	*Metodo que pinta el JTable dentro de un JScrollPane
	*Retorna JScrollPane
	*/
	public JScrollPane drawTableData(){
		scrollTableDb = new JScrollPane();
		try{
			tableDb = new JTable( new DefaultTableModel() );
			tableDb.setBackground( new Color( 168, 168, 73 ) );
			scrollTableDb = new JScrollPane( tableDb );
			tableDb.setFont(new Font("Serif", Font.PLAIN, 14));
			scrollTableDb.setPreferredSize(new Dimension(550, 300));
			scrollTableDb.setMaximumSize(new Dimension(550, 300));
			scrollTableDb.getViewport().setOpaque(false);
			scrollTableDb.setOpaque(false);
		}catch( Exception e ){
			e.printStackTrace();
		}
		return scrollTableDb;
	}

	/**
     * Devuelve el boton leerDb
     * @return
     */
    public JButton getBotonReadDb() {
        return butReadDb;
    }
	/**
     * Devuelve el DB JPanel
     * @return
     */
    public JPanel getDBJPanel() {
        return this;
    }
	/**
	* Devuelve el textarea read
	* @return
	*/
	public JTextArea gettextAreaRead( ) {
		return areaRead;
	}
	/**
	* Devuelve la Tabla de resultados read
	* @return
	*/
	public JTable getTableRead( ) {
		return tableDb;
	}
/**
	* Devuelve ScrollPane de resultados read
	* @return
	*/
	public JScrollPane getScrollTableRead( ) {
		return scrollTableDb;
	}



}
