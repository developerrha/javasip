
package pkgdir.control;

import pkgdir.modelo.FileServices;
import pkgdir.modelo.MysqlServices;
import pkgdir.modelo.OsCommandServices;
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
		if( ae.getSource() == guiUserl.getBotonWrite()){
			fileServices = new FileServices();
			String stmp = guiUserl.getTextField().getText();
			fileServices.writeFile( stmp, "historial.txt" );
			guiUserl.getTextField().setText("");
			
			
	   	}
		if( ae.getSource() == guiUserl.getBotonRead()){
			if( selected == null ){
				int index = guiUserl.getCboxModelo().getSelectedIndex(); 
				selected = (String)guiUserl.getCboxModelo().getItemAt( index );
				guiUserl.getBotonWrite().setVisible( true );
				guiUserl.getBotonRead().setVisible( true );
				guiUserl.getBotonDel().setVisible( true);
				guiUserl.getBotonCommand().setVisible(false);		
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
		if( ae.getSource() == guiUserl.getBotonDel()){
			fileServices = new FileServices();
			fileServices.delText( "historial.txt", stmpg);
	   	}
		if( ae.getSource() == guiUserl.getBotonCommand()){
			thread = new Thread(){
		          public void run(){
		       	 	guiUserl.gettextAreaRead().setText( osComServ.exeCommand( guiUserl.getTextField().getText()  ) );
				}
			};
			thread.start();
	   	}
		if( ae.getSource() == guiUserl.getCboxModelo()){
			int index = guiUserl.getCboxModelo().getSelectedIndex(); 
			selected = (String)guiUserl.getCboxModelo().getItemAt( index );
			System.out.println("Soy un JComboBOx: "+selected);
			if( selected.equals( "Archivo plano" ) ){
				guiUserl.getBotonWrite().setVisible( true );
				guiUserl.getBotonRead().setVisible( true );
				guiUserl.getBotonDel().setVisible( true);
				guiUserl.getBotonCommand().setVisible(false);		
				guiUserl.getJpanelTxt().setVisible( true );		
			}
			if( selected.equals( "Base de datos" ) ){
				guiUserl.getBotonWrite().setVisible( false );
				guiUserl.getBotonRead().setVisible( true );
				guiUserl.getBotonDel().setVisible( false );
				guiUserl.getBotonCommand().setVisible( false );		
				guiUserl.getJpanelTxt().setVisible( false );		
			}
			if( selected.equals("Comando") ){
				guiUserl.getBotonWrite().setVisible(false);
				guiUserl.getBotonRead().setVisible(false);
				guiUserl.getBotonDel().setVisible(false);
				guiUserl.getBotonCommand().setVisible(true);		
				guiUserl.getJpanelTxt().setVisible( true );		
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
