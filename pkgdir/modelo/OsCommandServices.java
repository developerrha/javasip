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
	
	public String exeCommand(){ 
		String stmt = "";
		System.out.println("Inicia exe..");
		try{
			String cmd_ts = "ls";
			String param_ts = "-la";
			System.out.println("cmd_ts: "+cmd_ts+" "+param_ts);
			ProcessBuilder pb = new ProcessBuilder( cmd_ts, param_ts  );
			pb.directory(new File("."));
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
