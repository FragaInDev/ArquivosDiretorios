package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArquivosController implements IArquivosController{

	public ArquivosController() {
		super();
	}

	@Override
	public void readFile(String path, String nome) throws IOException {
		File arq = new File(path, nome);
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			
			while (linha != null) { //procurando EOF
				if (linha.contains("fruit")) { //pego somente as linhas de frutas
					String[] vetFruits = linha.split(","); //separo as informações de acordo com as vírgulas
					System.out.println(vetFruits[0] + "\t" + vetFruits[1]+ "\t" + vetFruits[3] + "\t");
				}
				linha = buffer.readLine();
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		}else {
			throw new IOException("Arquivo Inválido");
		}
	}
	
}
