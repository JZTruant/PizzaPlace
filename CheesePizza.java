package com.fox;
public class CheesePizza extends Pizza
{	
	public CheesePizza(String size)
	{
		super("Cheese");
		setSize(size);
		if(size.toLowerCase().equals("small"))
		{
			setPrice(13.99);
		}
		else if(size.toLowerCase().equals("medium"))
		{
			setPrice(16.99);
		}
		else if(size.toLowerCase().equals("large"))
		{
			setPrice(19.99);
		}
		else if(size.toLowerCase().equals("family"))
		{
			setPrice(22.99);
		}
		else if(size.toLowerCase().equals("individual"))
		{
			setPrice(9.99);
		}
	}
}