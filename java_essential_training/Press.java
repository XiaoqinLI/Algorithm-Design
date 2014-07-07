package java_essential_training;

import java.util.Collection;

public interface Press {
	// they must be public
	public void getOil(Collection<Olive> olives);
	public int getTotalOil();
	public void setTotalOil(int totalOil);
}
