package pkgdir.graficos;

import javax.swing.*;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.Font;
import java.awt.Dimension;
import javax.imageio.ImageIO;
import java.net.URL;


/**
  * Hereda de la clase JFrame
**/
public class GuiMenu extends JFrame{

	public String title;
	private JPanel panel;
	private JPanel panelDB;
	private JMenuBar menuBar;
	private JMenu menuTasks;
	private JMenu menuSet;
	private JMenuItem itemTxtFile;
	private JMenuItem itemDataBas;
	private JMenuItem itemExit;
	private JMenuItem itemCommand;
	private JMenuItem itemEncrypt;
	private JButton butRead;
	private JTextArea areaRead;
	private JScrollPane scrollRead;
	

	/**
	*Metodo constructor de la clase		
	*/
	public GuiMenu() {
	}

	/**
	*Metodo que pinta el JFrame		
	*Retorna vacio
	*/
	public void showWin(String titleG){
		try{
			this.title = titleG;
			this.setSize(850, 550);
			this.setTitle(title);
			this.setLocationRelativeTo(null);
			this.setResizable(true);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.getContentPane().add(drawPanel());
			this.setJMenuBar( drawMenuBar() );
			this.setVisible(true);
			drawPanDB();
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	private JMenuBar drawMenuBar(){
		menuBar = new JMenuBar();
		menuBar.setBackground( new Color( 146, 168, 73, 50) );
		menuTasks = new JMenu("Tareas");
		menuSet = new JMenu("Configuracion");
		menuBar.add(menuTasks);
		menuBar.add(menuSet);
		itemTxtFile = new JMenuItem( "Archivo plano" );
		menuTasks.add( itemTxtFile );
		itemDataBas = new JMenuItem( "Base de datos" );
		menuTasks.add( itemDataBas );
		itemCommand = new JMenuItem( "Comandos" );
		menuTasks.add( itemCommand );
		itemEncrypt = new JMenuItem( "Encriptacion" );
		menuTasks.add( itemEncrypt );
		menuTasks.addSeparator();
		itemExit = new JMenuItem( "Salir" );
		menuTasks.add( itemExit );
		return menuBar;
	}

	/**
	*Metodo que pinta el JButton butRead
	*Retorna JButton
	*/
	private JButton drawButtonRead(){
		try{
		     URL url = GuiMenu.class.getResource("../../res/read_bl.png");
		     BufferedImage img = ImageIO.read(url);
			butRead = new JButton("Leer",new ImageIcon(img));
			butRead.setBackground( new Color( 168, 168, 73, 50 ) );
			butRead.setFont(butRead.getFont().deriveFont(Font.BOLD | Font.ITALIC));
			butRead.setAlignmentX(panel.CENTER_ALIGNMENT);
			butRead.setFocusPainted(true);
		}catch(Exception e){
			e.printStackTrace();
		}
		return butRead;
	}
	/**
	*Metodo que pinta el JTextArea dentro de un JScrollPane
	*Retorna JScrollPane
	*/
	private JScrollPane drawAreaRead(){
		try{
			areaRead = new JTextArea();
			areaRead.setEditable(false);
			areaRead.setBackground( new Color( 168, 168, 73, 30 ) );
			scrollRead = new JScrollPane(areaRead);
			areaRead.setFont(new Font("Serif", Font.PLAIN, 14));
			scrollRead.setPreferredSize(new Dimension(550, 160));
			scrollRead.setMaximumSize(new Dimension(550, 160));
			scrollRead.getViewport().setOpaque(false);
			scrollRead.setOpaque(false);
		}catch(Exception e){
			e.printStackTrace();
		}
		return scrollRead;
	}

	/**
	*Metodo que pinta el JPanel de DB
	*Retorna JPanel
	*/

	private JPanel drawPanDB(){
		try{
			panelDB = new JPanel();
		     panelDB.setLayout(new BoxLayout(panelDB,BoxLayout.Y_AXIS));
			panelDB.setBackground( new Color( 146, 168, 73 , 30 ) );
			panelDB.setPreferredSize(new Dimension(750, 450));
		     panelDB.setMaximumSize(new Dimension(750, 450));
			panelDB.add(Box.createVerticalStrut(10));
			panelDB.add( drawButtonRead() );
			panelDB.add(Box.createVerticalStrut(10));
			panelDB.add(drawAreaRead());
		}catch(Exception e){
			e.printStackTrace();
		}
		return panelDB;
	}

	/**
	*Metodo que pinta el JPanel
	*Retorna JPanel
	*/

	private JPanel drawPanel(){
		try{
			panel = new JPanel();
		     panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
			panel.setBackground( Color.decode("#80805E") );
			panel.add(Box.createVerticalStrut(30));
			//panel.add( drawPanDB() );
		}catch(Exception e){
			e.printStackTrace();
		}
		return panel;
	}

	/**
     * Devuelve el Item salir
     * @return
     */
    public JMenuItem getItemExit() {
        return itemExit;
    }
	/**
     * Devuelve el Item Archivo plano
     * @return
     */
    public JMenuItem getItemDB() {
        return itemDataBas;
    }
	/**
     * Devuelve el main JPanel
     * @return
     */
    public JPanel getMainJPanel() {
        return panel;
    }

	/**
     * Devuelve el DB JPanel
     * @return
     */
    public JPanel getDBJPanel() {
        return panelDB;
    }

	/**
     * Devuelve el boton leer
     * @return
     */
    public JButton getBotonRead() {
        return butRead;
    }

	/**
     * Devuelve el textarea read
     * @return
     */
    public JTextArea gettextAreaRead() {
        return areaRead;
    }





}
