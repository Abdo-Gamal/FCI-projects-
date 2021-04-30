package Mypackage;

public  abstract class ItemLibrary {
	

	 String bookName, author,bookPrice,freePeirod,KindOfItem;
	 boolean vaidBorw,vaildBuy;
	 int bookId, noCopies;
	//protected double tax;
	public abstract String getBookName() ;
	public abstract void setBookTitle(String bookTitle); 
	public abstract String getAuthor() ;
	public abstract void setAuthor(String author); 
	
	public abstract String getBookPrice(); 
	public abstract void setBookPrice(String bookPrice); 
	public abstract String getFreePeirod(); 
	public abstract void setFreePeirod(String freePeirod);
	public abstract boolean isVaidBorw(); 
	public abstract void setVaidBorw(boolean vaidBorw); 
	
	public abstract boolean isVaildBuy();
	public abstract void setVaildBuy(boolean vaildBuy); 
	public abstract int getBookId(); 
	public abstract void setBookId(int bookId);
	
	public  abstract int getNoCopies(); 
	public abstract void setNoCopies(int noCopies) ;
	
	
		
	
}
