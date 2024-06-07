package Main;

import java.io.*;

public class Save {
	private static Game gameinfo;
	private static String filename;
	
	Save(){
		gameinfo = null;
		filename = gameinfo.getID()+"savefile";
	}
	
	Save(Game newGameinfo, String newFilename){
		gameinfo = newGameinfo;
		filename = gameinfo.getID()+"savefile";
	}
	
	public static void writedown() throws IOException{
		RandomAccessFile raf = new RandomAccessFile(filename,"rw");
		gameinfo.writeRec(raf);
	    raf.close();
	}
	
	public static int readin() throws IOException{
		RandomAccessFile raf = new RandomAccessFile(filename,"rw");
		gameinfo = new Game();
		gameinfo.readRec(raf);
		raf.close();
	}
}
