package aula20190722;

public class Aplica��o {
	
	public static void main(String[] args) {
		Cidade maring� = new Cidade("Maring�","MGA");
		Rua avBrasil = new Rua("Avenida Brasil");
		Rua avGuedner = new Rua("Avenida Guedner");
		
		
		maring�.adicionarRua(avBrasil);
		maring�.adicionarRua(avGuedner);
		maring�.adicionarRua(new Rua("Rua Santos Dummont"));
		
		maring�.removerRua(avGuedner);
		
		
	}

}
