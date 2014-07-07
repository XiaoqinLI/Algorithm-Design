package java_essential_training;

public class Kalamata extends Olive {

	public Kalamata() {
		// call the constructor of super class
		super(2);
		this.name = "Kalamata";
		this.flavor = "Grassy";
		this.color = Olive.BLACK;
	}
	
	@Override
	public int crush() {
		// TODO Auto-generated method stub
		System.out.println("Crush from subclass");
		return super.crush();
	}

	@Override
	public String getOrigin() {
		// TODO Auto-generated method stub
		return "Kalamata";
	}
	
	

}
