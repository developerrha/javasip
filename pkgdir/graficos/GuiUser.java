
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
public class GuiUser extends JFrame{
	private JPanel panel;
	private JComboBox<String> cbModelo;
	private JButton butWrite;
	private JButton butRead;
	private JButton butDel;
	private JLabel labWrite;
	private JTextField texfWrite;
	private JTextArea areaRead;
	private JScrollPane scrollRead;
	private String namel;
	private Long docl;
	private int edadl;

	/**
	*Metodo constructor de la clase		
	*/
	public GuiUser() {
	}

	/**
	*Metodo que pinta el JFrame		
	*Retorna vacio
	*/
	public void showWin(String name, Long documento, int edad){
		try{
			this.namel = name;
			this.docl = documento;
			this.edadl = edad; 
			System.out.println("Pintando ventana namel= "+namel+" docl= "+docl+" edadl= "+edadl);
			this.setSize(550, 350);
			this.setTitle("HV: "+namel+" doc: "+docl+" edad: "+edadl);
			this.setLocationRelativeTo(null);
			this.setResizable(true);
			this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			this.getContentPane().add(drawPanel());
			this.setVisible(true);
		}catch(Exception e){
			e.printStackTrace();
		}

	}

	/**
	*Metodo que pinta el JComboBox cbModelo
	*Retorna JComboBox
	*/
	private JComboBox drawCboxModelo(){
		try{
			String modeloItems[]={"Archivo plano","Base de datos"};        
    			cbModelo = new JComboBox<>(modeloItems); 
			cbModelo.setBackground(Color.WHITE);
			cbModelo.setFont(cbModelo.getFont().deriveFont(Font.BOLD | Font.ITALIC));
			cbModelo.setAlignmentX(panel.CENTER_ALIGNMENT);
			cbModelo.setPreferredSize(new Dimension(150, 30));
		     cbModelo.setMaximumSize(new Dimension(150, 30));
			cbModelo.setSelectedIndex(1);
		}catch(Exception e){
			e.printStackTrace();
		}
		return cbModelo;
	}

	/**
	*Metodo que pinta el JButton butWrite
	*Retorna JButton
	*/
	private JButton drawButtonWrite(){
		try{
		     URL url = GuiUser.class.getResource("../../res/write_1.png");
		     BufferedImage img = ImageIO.read(url);
			butWrite = new JButton("Escribir",new ImageIcon(img));
			butWrite.setBackground(Color.WHITE);
			butWrite.setFont(butWrite.getFont().deriveFont(Font.BOLD | Font.ITALIC));
			butWrite.setAlignmentX(panel.CENTER_ALIGNMENT);
			butWrite.setFocusPainted(true);
		}catch(Exception e){
			e.printStackTrace();
		}
		return butWrite;
	}

	/**
	*Metodo que pinta el JButton butRead
	*Retorna JButton
	*/
	private JButton drawButtonRead(){
		try{
		     URL url = GuiUser.class.getResource("../../res/read_1.png");
		     BufferedImage img = ImageIO.read(url);
			butRead = new JButton("Leer",new ImageIcon(img));
			butRead.setBackground(Color.WHITE);
			butRead.setFont(butWrite.getFont().deriveFont(Font.BOLD | Font.ITALIC));
			butRead.setAlignmentX(panel.CENTER_ALIGNMENT);
			butRead.setFocusPainted(true);
		}catch(Exception e){
			e.printStackTrace();
		}
		return butRead;
	}

	/**
	*Metodo que pinta el JButton butDel
	*Retorna JButton
	*/
	private JButton drawButtonDel(){
		try{
		     URL url = GuiUser.class.getResource("../../res/borrar_1.png");
		     BufferedImage img = ImageIO.read(url);
			butDel = new JButton("Borrar",new ImageIcon(img));
			butDel.setBackground(Color.WHITE);
			butDel.setFont(butDel.getFont().deriveFont(Font.BOLD | Font.ITALIC));
			butDel.setAlignmentX(panel.CENTER_ALIGNMENT);
			butDel.setFocusPainted(true);
		}catch(Exception e){
			e.printStackTrace();
		}
		return butDel;
	}

	/**
	*Metodo que pinta el JTextField texffWrite Jlabel dentro de un JPanel
	*Retorna JTextField
	*/
	private JPanel drawTextfWrite(){
		JPanel jtmp = new JPanel();
		try{
		     jtmp.setLayout(new BoxLayout(jtmp,BoxLayout.X_AXIS));			
			labWrite = new JLabel("Texto:  ");
			texfWrite = new JTextField();
			labWrite.setLabelFor(texfWrite);
			texfWrite.setFont(new Font("Serif", Font.PLAIN, 16));
			texfWrite.setPreferredSize(new Dimension(350, 30));
		     texfWrite.setMaximumSize(new Dimension(350, 30));
			jtmp.add(labWrite);
			jtmp.add(texfWrite);
		}catch(Exception e){
			e.printStackTrace();
		}
		return jtmp;
	}

	/**
	*Metodo que pinta el JTextArea dentro de un JScrollPane
	*Retorna JScrollPane
	*/
	private JScrollPane drawAreaRead(){
		try{
			areaRead = new JTextArea();
			areaRead.setEditable(false);
			scrollRead = new JScrollPane(areaRead);
			areaRead.setFont(new Font("Serif", Font.PLAIN, 16));
			scrollRead.setPreferredSize(new Dimension(350, 120));
			scrollRead.setMaximumSize(new Dimension(350, 120));
		}catch(Exception e){
			e.printStackTrace();
		}
		return scrollRead;
	}

	/**
	*Metodo que pinta el JPanel
	*Retorna JPanel
	*/
	private JPanel drawPanel(){
		try{
			panel = new JPanel();
		     panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
			panel.add(Box.createVerticalStrut(10));
			panel.setBackground(Color.CYAN);
			panel.add(drawCboxModelo());
			panel.add(Box.createVerticalStrut(5));
			panel.add(drawTextfWrite());
			panel.add(Box.createVerticalStrut(5));
			panel.add(drawButtonWrite());
			panel.add(Box.createVerticalStrut(5));
			panel.add(drawButtonRead());
			panel.add(Box.createVerticalStrut(5));
			panel.add(drawAreaRead());
			panel.add(Box.createVerticalStrut(5));
			panel.add(drawButtonDel());
		}catch(Exception e){
			e.printStackTrace();
		}
		return panel;
	}	

	/**
     * Devuelve el Choice modelos
     * @return
     */
    public JComboBox getCboxModelo() {
        return cbModelo;
    }

	/**
     * Devuelve el boton escribir
     * @return
     */
    public JButton getBotonWrite() {
        return butWrite;
    }

	/**
     * Devuelve el boton leer
     * @return
     */
    public JButton getBotonRead() {
        return butRead;
    }

	/**
     * Devuelve el boton borrar
     * @return
     */
    public JButton getBotonDel() {
        return butDel;
    }

	/**
     * Devuelve el textarea read
     * @return
     */
    public JTextArea gettextAreaRead() {
        return areaRead;
    }
	
	/**
     * Devuelve el texField write
     * @return
     */
    public JTextField getTextField() {
        return texfWrite;
    }


}
