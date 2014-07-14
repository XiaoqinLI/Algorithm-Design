package java_advanced_training;

public enum OliveName {
	// each identifier is associated with a string
	KALAMATA("Kalamata"), LIGURIO("Ligurio"), PICHOLINE("Picholine"), GOLDEN("Golden");
	
	// the string is passed into this private field.
	private String nameAsString;
	
	// must be private in Enum
	private OliveName(String nameAsString){
		this.nameAsString = nameAsString;
	}
	
	@Override
	public String toString(){
		return this.nameAsString;
	}
}
