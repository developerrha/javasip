
package pkgdir;

import pkgdir.graficos.GuiMenu;
import pkgdir.control.Controller;

public class CargarClase {
	public static GuiMenu front;

	/**
	*Metodo principal de la clase		
	*/
     public static void main(String[] args) {
		try{
			front = new GuiMenu();
			front.showWin("JAVA BASICO");
			Controller controlador = new Controller( front );
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
