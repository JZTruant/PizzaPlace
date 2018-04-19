package com.fox;
public class BruschettaPizza extends Pizza
{
	public BruschettaPizza(String size)
	{
		super("Bruschetta");
		setSize(size);
		if(size.toLowerCase().equals("individual"))
		{
			setPrice(13.99);
		}
		else if(size.toLowerCase().equals("small"))
		{
			setPrice(18.99);
		}
		else if(size.toLowerCase().equals("medium"))
		{
			setPrice(22.99);
		}
		else if(size.toLowerCase().equals("large"))
		{
			setPrice(25.99);
		}
		else if(size.toLowerCase().equals("family"))
		{
			setPrice(29.99);
		}
	}
}