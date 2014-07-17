package java_intermediate_training;

public class Olive implements Comparable<Olive>{
	
	public static final long BLACK = 0x000000;
	
	public OliveName oliveName;
	public OliveColor oliveColor;
	
	public Olive() {
	}

	public Olive(OliveName oliveName) {
		this.oliveName = oliveName;
	}
	
	public Olive(OliveName oliveName, OliveColor color) {
		this(oliveName);
		this.oliveColor = color;
	}
	
	@Override
	public String toString() {
		return "oliveName: " + this.oliveName.toString() + ", color: " +  this.oliveColor.toString();
	}
	
	// the compareTo Method will return an integer value of -1, 0, or 1
	@Override
	public int compareTo(Olive o) { 
		String s1 = this.getClass().getSimpleName();
		String s2 = o.getClass().getSimpleName();
//		String s1 = this.oliveName.toString();
//		String s2 =  o.oliveName.toString();

		return s1.compareTo(s2);
	}

}
