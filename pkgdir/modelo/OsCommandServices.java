package pkgdir.modelo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;

public class OsCommandServices{
	
	private Process p_ts;

	/**
     * Constructor sin parametros
     * @see empty
     */
	public OsCommandServices(){
		super();
	}
	
	public String exeCommand( String command ){ 
		String stmt = "";
		System.out.println("Inicia exe command: "+command);
		try{
			String[] cmd_ts = command.split(" ") ;
			ProcessBuilder pb = new ProcessBuilder( cmd_ts );
			Process process = pb.start();
			BufferedReader reader = new BufferedReader( new InputStreamReader(process.getInputStream()));
			String line;
			while ( (line = reader.readLine()) != null ) {
				stmt += line+"\n";
			}
			System.out.println( "stmt= "+stmt );
			reader.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
		return stmt;
	}
	








}
