import java.io.Serializable;

public class Film implements Serializable {
	private int nomer;
	private String name;
	private String year;
	private String[] ganr;
	
	public Film() {}
	
	
	
	public Film(int n,String na, String y,String[] g)
	{
		nomer = n;
		name = na;
		year = y;
		ganr = g;		
	}
	
	public void print()
	{	
		System.out.print(nomer + " " + name + " " + year + " ");
		for (int i =0;i<ganr.length;i++) System.out.print(ganr[i] + " "); 
		System.out.println();
	}
	
	public int getNomer()
	{
		return nomer;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getYear()
	{
		return year;
	}
	
	public String[] getGanr()
	{
		return ganr;
	}
	
	public void setYear(String year)
	{
		this.year = year;
	}
	

}
