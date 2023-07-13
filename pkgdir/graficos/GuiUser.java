
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
	private JButton butCommand;
	private JButton butEncrypt;
	private JButton butRead;
	private JButton butDel;
	private JLabel labWrite;
	private JLabel labTasks;
	private JTextField texfWrite;
	private JPanel jtmp;
	private JTextArea areaRead;
	private JScrollPane scrollRead;
	private String title;

	/**
	*Metodo constructor de la clase		
	*/
	public GuiUser() {
	}

	/**
	*Metodo que pinta el JFrame		
	*Retorna vacio
	*/
	public void showWin(String titleG){
		try{
			this.title = titleG;
			this.setSize(550, 350);
			this.setTitle(title);
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
	private JPanel drawCboxModelo(){
		JPanel jtmpCb = new JPanel();
		try{
			jtmpCb.setLayout(new BoxLayout(jtmpCb,BoxLayout.X_AXIS));			
			labTasks = new JLabel("Tareas:  ");
			String modeloItems[]={"Archivo plano","Base de datos", "Comando", "Encriptacion"};        
    			cbModelo = new JComboBox<>(modeloItems); 
			labTasks.setLabelFor( cbModelo );
			cbModelo.setBackground(Color.WHITE);
			cbModelo.setFont(cbModelo.getFont().deriveFont(Font.BOLD | Font.ITALIC));
			cbModelo.setAlignmentX(panel.CENTER_ALIGNMENT);
			cbModelo.setPreferredSize(new Dimension(150, 30));
		     cbModelo.setMaximumSize(new Dimension(150, 30));
			cbModelo.setSelectedIndex(0);
			jtmpCb.add(labTasks);
			jtmpCb.add(cbModelo);
		}catch(Exception e){
			e.printStackTrace();
		}
		return jtmpCb;
	}

	/**
	*Metodo que pinta el JButton butEncrypt
	*Retorna JButton
	*/
	private JButton drawButtonEncrypt(){
		try{
		     URL url = GuiUser.class.getResource("../../res/encript_1.png");
		     BufferedImage img = ImageIO.read(url);
			butEncrypt = new JButton("Encriptacion",new ImageIcon(img));
			butEncrypt.setBackground(Color.WHITE);
			butEncrypt.setFont(butEncrypt.getFont().deriveFont(Font.BOLD | Font.ITALIC));
			butEncrypt.setAlignmentX(panel.CENTER_ALIGNMENT);
			butEncrypt.setVisible(false);
			butEncrypt.setFocusPainted(true);
		}catch(Exception e){
			e.printStackTrace();
		}
		return butEncrypt;
	}



	/**
	*Metodo que pinta el JButton butCommand
	*Retorna JButton
	*/
	private JButton drawButtonCommand(){
		try{
		     URL url = GuiUser.class.getResource("../../res/run_1.png");
		     BufferedImage img = ImageIO.read(url);
			butCommand = new JButton("Ejecutar",new ImageIcon(img));
			butCommand.setBackground(Color.WHITE);
			butCommand.setFont(butCommand.getFont().deriveFont(Font.BOLD | Font.ITALIC));
			butCommand.setAlignmentX(panel.CENTER_ALIGNMENT);
			butCommand.setVisible(false);
			butCommand.setFocusPainted(true);
		}catch(Exception e){
			e.printStackTrace();
		}
		return butCommand;
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
		jtmp = new JPanel();
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
			scrollRead.setPreferredSize(new Dimension(400, 160));
			scrollRead.setMaximumSize(new Dimension(400, 160));
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
			panel.add(drawButtonEncrypt());
			panel.add(Box.createVerticalStrut(5));
			panel.add(drawTextfWrite());
			panel.add(Box.createVerticalStrut(5));
			panel.add(drawButtonWrite());
			panel.add(Box.createVerticalStrut(5));
			panel.add(drawButtonCommand());
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
     * Devuelve el boton Encrypt
     * @return
     */
    public JButton getBotonEncrypt() {
        return butEncrypt;
    }

	/**
     * Devuelve el boton comando
     * @return
     */
    public JButton getBotonCommand() {
        return butCommand;
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
	
	/**
     * Devuelve el texField Panel del JtextField 
     * @return
     */
    public JPanel getJpanelTxt() {
        return jtmp;
    }


}
