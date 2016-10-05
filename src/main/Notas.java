package main;

public enum Notas {
	DO("C"),
	RE("D"),
	MI("E"),
	FA("F"),
	SOL("G"),
	LA("A"),
	SI("B");
	
	private String cifradoAmericano;
	private String octava;
	
	Notas(String cifradoAmericano){
		this.cifradoAmericano = cifradoAmericano;
	}
	public String cifradoAmericano(){
		return cifradoAmericano;
	}
	public String getOctava() {
		return octava;
	}
	public void setOctava(String octava) {
		this.octava = octava;
	}
}