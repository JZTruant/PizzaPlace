package com.fox;
public class PepperoniPizza extends Pizza
{	
	public PepperoniPizza(String size)
	{
		super("Pepperoni");
		setSize(size);
		if(size.toLowerCase().equals("individual"))
		{
			setPrice(11.79);
		}
		else if(size.toLowerCase().equals("small"))
		{
			setPrice(15.99);
		}
		else if(size.toLowerCase().equals("medium"))
		{
			setPrice(19.19);
		}
		else if(size.toLowerCase().equals("large"))
		{
			setPrice(22.39);
		}
		else if(size.toLowerCase().equals("family"))
		{
			setPrice(25.59);
		}
	}
}