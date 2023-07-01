
package pkgdir;

import pkgdir.graficos.GuiUser;
import pkgdir.control.Controller;

public class CargarClase {
	public static GuiUser front;

	/**
	*Metodo principal de la clase		
	*/
     public static void main(String[] args) {
		try{
			front = new GuiUser();
			front.showWin("Carlos", (long)1234567,(int)35);	
			Controller controlador = new Controller( front );
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
