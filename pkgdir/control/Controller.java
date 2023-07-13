
package pkgdir.control;

import java.io.File;
import pkgdir.modelo.FileServices;
import pkgdir.modelo.MysqlServices;
import pkgdir.modelo.OsCommandServices;
import pkgdir.modelo.TextEncryption;
import pkgdir.graficos.GuiUser;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;


public class Controller implements ActionListener{

	private GuiUser guiUserl;
	private FileServices fileServices;
	private MysqlServices msqlserv;
	private OsCommandServices osComServ;	
	private TextEncryption textEncryption;
	private CaretListener listener;
	private String stmpg;
	private String selected;
	private Thread thread;

	/**
     * Constructor sin parametros
     * @see empty
     */
    public Controller() {
        super();
    }

	/**
	* Constructor GuiUser como parametros
	* @param GuiUser
	*/
	public Controller(GuiUser guiUser) {
		super();
		this.guiUserl = guiUser;
		agregarEventos();		
		osComServ = new OsCommandServices();
	}

	/**
     * Metodo que administra los eventos sobre los botones
	* pertenece a la clase ActionListener
     * @param ae
     */
    @Override
	public void actionPerformed(ActionEvent ae) {
		/*
		* Evento sobre boton Escribir
		*/
		if( ae.getSource() == guiUserl.getBotonWrite()){
			fileServices = new FileServices();
			String stmp = guiUserl.getTextField().getText();
			fileServices.writeFile( stmp, "historial.txt" );
			guiUserl.getTextField().setText("");
	   	}
		/*
		* Evento sobre boton Leer
		*/
		if( ae.getSource() == guiUserl.getBotonRead()){
			if( selected == null ){
				int index = guiUserl.getCboxModelo().getSelectedIndex(); 
				selected = (String)guiUserl.getCboxModelo().getItemAt( index );
				guiUserl.getBotonWrite().setVisible( true );
				guiUserl.getBotonRead().setVisible( true );
				guiUserl.getBotonDel().setVisible( true);
				guiUserl.getBotonCommand().setVisible(false);	
				guiUserl.getBotonEncrypt().setVisible(false);	
				guiUserl.getTextField().setVisible( true );	
			}
			if( selected.equals( "Archivo plano" ) ){
				fileServices = new FileServices();
				String stmp = fileServices.readFile( "historial.txt" );	
				guiUserl.gettextAreaRead().setText( stmp );
			}else{
				msqlserv = new MysqlServices();
				guiUserl.gettextAreaRead().setText( msqlserv.getDataFromMysql() );	
			}
	   	}
		/*
		* Evento sobre boton Borrar
		*/
		if( ae.getSource() == guiUserl.getBotonDel()){
			fileServices = new FileServices();
			fileServices.delText( "historial.txt", stmpg);
	   	}
		/*
		* Evento sobre boton Encriptar
		*/
		if( ae.getSource() == guiUserl.getBotonEncrypt() ){
			textEncryption = new TextEncryption();
			textEncryption.doCrypto(1, "lassorh", new File("historial.txt"), new File("historialEnc.txt"));
			File ftempE = new File( "historialEnc.txt" );
			if( ftempE.exists() )
				guiUserl.gettextAreaRead().append( "Encriptacion realizada\n" );
			else
				guiUserl.gettextAreaRead().append( "Encriptacion fallo\n" );
			textEncryption.doCrypto(2, "lassorh", new File("historialEnc.txt"), new File("historialDec.txt"));
			File ftempD = new File( "historialDec.txt" );
			if( ftempD.exists() )
				guiUserl.gettextAreaRead().append( "Desencriptacion realizada\n" );
			else
				guiUserl.gettextAreaRead().append( "Desencriptacion fallo\n" );

	   	}

		/*
		* Evento sobre boton Comando
		*/
		if( ae.getSource() == guiUserl.getBotonCommand()){
			thread = new Thread(){
		          public void run(){
		       	 	guiUserl.gettextAreaRead().setText( osComServ.exeCommand( guiUserl.getTextField().getText()  ) );
				}
			};
			thread.start();
	   	}
		/*
		* Evento sobre Lista de tares JComboBox
		*/

		if( ae.getSource() == guiUserl.getCboxModelo()){
			int index = guiUserl.getCboxModelo().getSelectedIndex(); 
			selected = (String)guiUserl.getCboxModelo().getItemAt( index );
			System.out.println("Soy un JComboBOx: "+selected);
			if( selected.equals( "Archivo plano" ) ){
				guiUserl.getBotonWrite().setVisible( true );
				guiUserl.getBotonRead().setVisible( true );
				guiUserl.getBotonDel().setVisible( true);
				guiUserl.getBotonCommand().setVisible(false);		
				guiUserl.getBotonEncrypt().setVisible(false);
				guiUserl.getJpanelTxt().setVisible( true );		
			}
			if( selected.equals( "Base de datos" ) ){
				guiUserl.getBotonWrite().setVisible( false );
				guiUserl.getBotonRead().setVisible( true );
				guiUserl.getBotonDel().setVisible( false );
				guiUserl.getBotonCommand().setVisible( false );		
				guiUserl.getJpanelTxt().setVisible( false );		
				guiUserl.getBotonEncrypt().setVisible(false);
			}
			if( selected.equals("Comando") ){
				guiUserl.getBotonWrite().setVisible(false);
				guiUserl.getBotonRead().setVisible(false);
				guiUserl.getBotonDel().setVisible(false);
				guiUserl.getBotonEncrypt().setVisible(false);
				guiUserl.getBotonCommand().setVisible(true);		
				guiUserl.getJpanelTxt().setVisible( true );		
			}
			if( selected.equals("Encriptacion") ){
				guiUserl.getBotonWrite().setVisible(false);
				guiUserl.getBotonRead().setVisible(false);
				guiUserl.getBotonDel().setVisible(false);
				guiUserl.getBotonCommand().setVisible(false);		
				guiUserl.getBotonEncrypt().setVisible(true);
				guiUserl.getJpanelTxt().setVisible( false );		
			}
	   	}

	}

	
	/**
     * Metodo que agrega eventos sobre los componentes de GuiUser
     */
	private void agregarEventos(){
		guiUserl.getCboxModelo().addActionListener(this);
		guiUserl.getBotonWrite().addActionListener(this);
		guiUserl.getBotonRead().addActionListener(this);
		guiUserl.getBotonDel().addActionListener(this);
		guiUserl.getBotonCommand().addActionListener(this);
		guiUserl.getBotonEncrypt().addActionListener(this);
		/*
		* Obtiene la seleccion delusuario soble el JComboBox para Borrar
		*/
		listener = new CaretListener() {
			public void caretUpdate(CaretEvent caretEvent) {
				stmpg = "";
				int posM = caretEvent.getMark();
				int posD = caretEvent.getDot();
				if( posD > posM){
					stmpg = (guiUserl.gettextAreaRead().getText()).substring( posM, posD );					
				}else{
					stmpg = (guiUserl.gettextAreaRead().getText()).substring( posD, posM );					
				}	
				System.out.println("stmpg: "+stmpg);	
			}
	     };
		guiUserl.gettextAreaRead().addCaretListener(listener);
	}

}
