

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author max
 */

//not yet implemented
public class InvoiceProductInfo extends ProductInfo{
    private float quantity;
    
    public InvoiceProductInfo()
    {
    }
    public InvoiceProductInfo(String product, String currency, String price, String unit, float quantity)
    { 
        super(product, currency, price, unit); //calling constructor of pinfo class(base class will be productinfo)
        this.quantity = quantity;
    }
    public InvoiceProductInfo(String product, String currency, Float price, String unit, float quantity)
    { 
        super(product, currency, price, unit);
        this.quantity = quantity;
    }
    public InvoiceProductInfo (ProductInfo pinfo, float quantity) {
        super(pinfo.getProduct(),pinfo.getCurrency(),pinfo.getPrice(),pinfo.getUnit());
        this.quantity = quantity;
    }
    
public float getQuantity()
{ return quantity; }
public void setQuantity(float value)
{ this.quantity = value; }

public Float getSubtotal(){
        Float price = this.getPrice();
        Float fSubtotal = price*quantity;
        return formatFloatValue(fSubtotal);
}
public String toTabString(){ 
    String tabString = this.getProduct();
    tabString += "\t";
    tabString += this.getCurrency();
    tabString += "\t";
    tabString += this.getPrice().toString();
    tabString += "\t";
    tabString += this.getUnit();
    tabString += "\t";
    tabString += Float.toString(quantity);
    tabString += "\t";
    tabString += this.getSubtotal().toString();
    return tabString;
}
}
