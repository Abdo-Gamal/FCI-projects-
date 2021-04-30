package Mypackage;



enum LibraryItemType 
{ 
    Book, Magazine, Booklet; 
}


public abstract  class ItemLibrary extends BasedCalss {
	
	private LibraryItemType itemKind;
	private String  author,itemPrice,freePeirod;
	private boolean vaidBorw,vaildBuy;
	private int  noCopies;
	
	
//////////////////////////////////////////////////////////////////////////////////
	
	public void setItemKind(LibraryItemType itemKind) {
		this.itemKind = itemKind;
	}
	
	public LibraryItemType getItemKind() {
		return itemKind;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(String itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getFreePeirod() {
		return freePeirod;
	}
	public void setFreePeirod(String freePeirod) {
		this.freePeirod = freePeirod;
	}
	public boolean isVaidBorw() {
		return vaidBorw;
	}
	public void setVaidBorw(boolean vaidBorw) {
		this.vaidBorw = vaidBorw;
	}
	public boolean isVaildBuy() {
		return vaildBuy;
	}
	public void setVaildBuy(boolean vaildBuy) {
		this.vaildBuy = vaildBuy;
	}
	
	public int getNoCopies() {
		return noCopies;
	}
	public void setNoCopies(int noCopies) {
		this.noCopies = noCopies;
	}
//////////////////////////////////////////////////////////////////////////
	public abstract void showItem();
	public  abstract void calcTax(long days) ;

		
	
	
	
}
