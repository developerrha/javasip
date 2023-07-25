
package pkgdir;

import pkgdir.graficos.GuiMenu;
import pkgdir.graficos.GuiConfig;
import pkgdir.control.Controller;
import pkgdir.control.ControllerConfig;

public class CargarClase {
	public static GuiMenu front;
	public static GuiConfig frontConfig;

	/**
	*Metodo principal de la clase		
	*/
     public static void main(String[] args) {
		try{
			front = new GuiMenu();
			front.showWin("JAVA BASICO");
			frontConfig = new GuiConfig();
			Controller controlador = new Controller( front );
			ControllerConfig controlConf = new ControllerConfig( front, frontConfig );
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
