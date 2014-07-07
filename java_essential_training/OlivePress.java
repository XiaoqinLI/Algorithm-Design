package java_essential_training;

import java.util.Collection;


public class OlivePress {
	
	private int totalOil=0;
	
	public int getTotalOil() {
		return totalOil;
	}

	private void setTotalOil(int totalOil) {
		this.totalOil += totalOil;
	}

	public OlivePress() {
	}
	
	// upgrade an arraylist type to a general type: Collection interface
	// and this can accept any data tpye in Collection interface
	public void getOil(Collection<Olive> olives) {
		
		int oil = 0;
		
		for (Olive olive : olives) {
			oil += olive.crush();
		}
		
		setTotalOil(oil);

	}
}
