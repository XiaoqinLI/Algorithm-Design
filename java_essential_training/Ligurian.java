package java_essential_training;

public class Ligurian extends Olive {

	public Ligurian() {
		super(1);
		this.name = "Ligurian";
		this.flavor = "Yummy";
		this.color = Olive.GREEN;
	}

	@Override
	public String getOrigin() {
		// TODO Auto-generated method stub
		return "Ligurian";
	}

}
