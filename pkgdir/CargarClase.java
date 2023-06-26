
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
		 	System.out.println("Cargando graficas");
			front = new GuiUser();
			front.showWin("Carlos", (long)1234567,(int)35);	
			System.out.println("Graficas cargadas");
			Controller controlador = new Controller( front );
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
