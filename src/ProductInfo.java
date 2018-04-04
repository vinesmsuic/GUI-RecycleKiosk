
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author max
 */
public class ProductInfo {
private String product;
private String currency;
private Float price;
private String unit;

public ProductInfo() //default constuctor
	{
                this.product = null;
		this.currency = null;
                this.price = 0.0f;
                this.unit = null;
	}
	public ProductInfo(String product, String currency, String price, String unit) {
                this.product = product;
		this.currency = currency;
                this.price = Float.parseFloat(price); //Convert String into float
                this.unit = unit;
	}
	public ProductInfo(String product, String currency, Float price, String unit) {
		this.product = product;
		this.currency = currency;
		this.price = price;
		this.unit = unit;
	} //this. mean the class itself
        
public String getProduct()
{ return product; }
public void setProduct(String value)
{ this.product = value; }

public String getCurrency()
{ return currency; }
public void setCurrency(String value)
{ this.currency = value; }

public Float getPrice()
{ return formatFloatValue(price); } //formatted price information
public void setPrice(Float value)
{ this.price = value; }

public String getUnit()
{ return unit; }
public void setUnit(String value)
{ this.unit = value; }

public static ProductInfo createFromTabCSV(String line)
{
String[] fields = line.split("\t");
return new ProductInfo(fields[0],fields[1],fields[2],fields[3]); //put values into 2nd constructor

}
protected Float formatFloatValue(Float value){ //avaliable to ipi,pinfo
    NumberFormat formatter = NumberFormat.getInstance(Locale.US); //formatter in order to format the output
        formatter.setMaximumFractionDigits(2); //no more than 2 digit following d.p. 
        formatter.setMinimumFractionDigits(2); //at least 2 digit folling d.p.
        formatter.setRoundingMode(RoundingMode.HALF_UP); //define how to round
        return new Float(formatter.format(value));// 
}
}

