package com.fox;
public class SpecialPizza extends Pizza
{	
	public SpecialPizza(String size)
	{
		super("Special");
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