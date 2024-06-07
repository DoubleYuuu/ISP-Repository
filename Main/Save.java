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
		 raf.seek (recordLength); // move pointer to position in file
		int padLen = 0; // the number of blanks that needed to be added to maintain a length of 10
		int IDLen = gameinfo.getID().length(); // determine if there are more than 10 characters
		if (IDLen > 10)
			IDLen = 10;
        else
            padLen = 10 - IDLen;
		
		// other fields from game should be processed to be written down
		 /*
         * writeLong()
         * writeDouble()
         * writeInt()
         * writeChar() string-->char
         */
		
	    raf.close();
	}
	
	public static void readin() throws IOException{
		RandomAccessFile raf = new RandomAccessFile(filename,"rw");
		String newID = "";
		for (int i=0; i<10; i++)
			newID = newID + raf.readChar();
		gameinfo = new Game(newID);
		
		// other fields from game should be processed to be written down
		
		raf.close();
	}
}
