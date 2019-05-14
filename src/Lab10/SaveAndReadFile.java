package Lab10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Lab4.Worker;




public class SaveAndReadFile {
	public static boolean savefile(ArrayList<Worker> dskh, String path) {
		
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream  oos = new ObjectOutputStream(fos);
			oos.writeObject(dskh);
			oos.close();
			fos.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static ArrayList<Worker> readfile(String path){
		ArrayList<Worker> dskh = new ArrayList<Worker>();
		try {
			FileInputStream fis = new FileInputStream(path);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Object data = ois.readObject();
			dskh = (ArrayList<Worker>) data;
			ois.close();
			fis.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dskh;
	}
}
