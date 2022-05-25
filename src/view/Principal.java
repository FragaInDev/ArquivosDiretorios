package view;

import controller.ArquivosController;
import controller.IArquivosController;

public class Principal {

	public static void main(String[] args) {
		
		IArquivosController arqCont = new ArquivosController();
		String path = "C:\\TEMP";
		String nome = "generic_food.csv";
		
		try {
			arqCont.readFile(path, nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
