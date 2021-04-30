package Mypackage;

public class StudentAndOpration extends Person {

	 String [] nameBookTaken=new String[5];
	 int [] idBookTeaken=new int[5];
	 String [] dataBookTeaken=new String[5];
	 
     int num_TakenBook;
  ////////////////////////////////////////////////////////////////////////////////////////////////////
	public StudentAndOpration() {
		name="null"; id=0;num_TakenBook=0;
	}

	public int getNum_TakenBook() {
		return num_TakenBook;
	}
	public void setNum_TakenBook(int num_TakenBook) {
		this.num_TakenBook = num_TakenBook;
	}
	@Override
	public String getName() {
		return name;
	}
	@Override
	public void setName(String name) {
       name=name;		
	}
	@Override
	public int getId() {
		return id;
	}
	@Override
	public void setId(int id) {
         id=id;		
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
	
	
	


}
