package pkgdir.modelo;



public class OsCommandServices{
	
	private boolean flag = true;
	private Thread thread;

	/**
     * Constructor sin parametros
     * @see empty
     */
	public OsCommandServices(){
		super();
	}
	
	public void exeCommand(){
		try{
			System.out.println("Inicia el bucle..");
			thread = new Thread(){			
				public void run(){				
					try{
						int n = 0;
						while( flag ){
							System.out.println(n);
							n++;
							Thread.sleep(3000); 
						}
					}catch(Exception e){
						e.printStackTrace();
					}	
				
				}
			};
			thread.start();
			System.out.println("Termino el bucle..");
		}catch( Exception e){
			e.printStackTrace();
		}
	}
	
	public void setFlag( boolean flagG ){
		this.flag = flagG;
	}	
	
	public boolean getFlag(){
		return flag;
	}








}
