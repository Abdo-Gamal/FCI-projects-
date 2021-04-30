package Mypackage;

import java.util.ArrayList;
import java.util.Scanner;



public class LibraryMangerAndOpration extends Person implements IMangerOpration{
	
	Scanner s = new Scanner(System.in);
	ArrayList<ItemLibrary> bookList = new ArrayList<ItemLibrary>();
	ArrayList<StudentAndOpration> studentList = new ArrayList<StudentAndOpration>();
	
	
////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name=name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
/////////////////////////////////////////////////////////////////////////////////
	public void addItem(int key) {
		ItemLibrary item = null;
		if(key==2) {item=new Book();}
		if(key==3) {item=new Booklet();}
		if(key==4) {item=new Magazine();}

		System.out.println(" Enter the Id of book ");
		item.setBookId(s.nextInt());
		boolean ok = chickIdItemletFound(item.bookId);
		if (ok)return;

		System.out.println(" Enter the name of book ");
		item.setBookTitle(s.next());
		System.out.println(" Enter the num_of_copies of book ");
		item.setNoCopies(s.nextInt());
		System.out.println(" Enter the name of Author");
		item.setAuthor(s.next());
		System.out.println(" Enter the state of brow ");
		item.setVaidBorw(s.nextBoolean());
		System.out.println(" Enter the state of buy");
		item.setVaildBuy(s.nextBoolean());

		
		
		if(item.isVaildBuy()) {
		System.out.println(" Enter the price of book");
		item.setBookPrice(s.next());
		}
		if(item.isVaidBorw()) {
		System.out.println(" Enter the free priod of brow of book");
		item.setFreePeirod(s.next());
		  }
		
		bookList.add(item);
		System.out.println(" size of librairy is  = "+bookList.size() );
		System.out.println(" Add  new book is done ");

		 
		}
/////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void addBook() {
		
     Book newBook = new Book();
   

		System.out.println(" Enter the Id of book ");
		newBook.setBookId(s.nextInt());
		boolean ok = chickIdItemletFound(newBook.bookId);
		if (ok)return;

		System.out.println(" Enter the name of book ");
		newBook.setBookTitle(s.next());
		System.out.println(" Enter the num_of_copies of book ");
		newBook.setNoCopies(s.nextInt());
		System.out.println(" Enter the name of Author");
		newBook.setAuthor(s.next());
		System.out.println(" Enter the state of brow ");
		newBook.setVaidBorw(s.nextBoolean());
		System.out.println(" Enter the state of buy");
		newBook.setVaildBuy(s.nextBoolean());

		
		
		if(newBook.isVaildBuy()) {
		System.out.println(" Enter the price of book");
		newBook.setBookPrice(s.next());
		}
		if(newBook.isVaidBorw()) {
		System.out.println(" Enter the free priod of brow of book");
		newBook.setFreePeirod(s.next());
		  }
		
		bookList.add(newBook);
		System.out.println(" size of librairy is  = "+bookList.size() );
		System.out.println(" Add  new book is done ");

	}
	///////////////////////////////////////////////////////////////////////////////////////////////////
public void addMagazine() {
		

		Book newMagazine = new Book();


		System.out.println(" Enter the Id of book ");
		newMagazine.setBookId(s.nextInt());
		boolean ok = chickIdItemletFound(newMagazine.bookId);
		if (ok)return;

		System.out.println(" Enter the name of book ");
		newMagazine.setBookTitle(s.next());
		System.out.println(" Enter the num_of_copies of book ");
		newMagazine.setNoCopies(s.nextInt());
		System.out.println(" Enter the name of Author");
		newMagazine.setAuthor(s.next());
		System.out.println(" Enter the state of brow ");
		newMagazine.setVaidBorw(s.nextBoolean());
		System.out.println(" Enter the state of buy");
		newMagazine.setVaildBuy(s.nextBoolean());

		
		
		if(newMagazine.isVaildBuy()) {
		System.out.println(" Enter the price of book");
		newMagazine.setBookPrice(s.next());
		}
		if(newMagazine.isVaidBorw()) {
		System.out.println(" Enter the free priod of brow of book");
		newMagazine.setFreePeirod(s.next());
		  }
		
		bookList.add(newMagazine);
		System.out.println(" size of librairy is  = "+bookList.size() );
		System.out.println(" Add nerbooklet is done ");

	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////
	
public void addBooklet() {
		

		Booklet newBooklet = new Booklet();


		System.out.println(" Enter the Id of book ");
		int newId=s.nextInt();
		boolean ok = chickIdItemletFound(newId);
		if (ok)return;
		newBooklet.setBookId(newId);
		System.out.println(" Enter the name of book ");
		newBooklet.setBookTitle(s.next());
		System.out.println(" Enter the num_of_copies of book ");
		newBooklet.setNoCopies(s.nextInt());
		System.out.println(" Enter the name of Author");
		newBooklet.setAuthor(s.next());
		System.out.println(" Enter the state of brow ");
		newBooklet.setVaidBorw(s.nextBoolean());
		System.out.println(" Enter the state of buy");
		newBooklet.setVaildBuy(s.nextBoolean());

		
		
		if(newBooklet.isVaildBuy()) {
		System.out.println(" Enter the price of book");
		newBooklet.setBookPrice(s.next());
		}
		if(newBooklet.isVaidBorw()) {
		System.out.println(" Enter the free priod of brow of book");
		newBooklet.setFreePeirod(s.next());
		  }
		
		bookList.add(newBooklet);
		System.out.println(" size of librairy is  = "+bookList.size() );
		System.out.println(" Add new magazine  is done ");

	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////
	
	public boolean chickIdItemletFound(int id) {
		for (ItemLibrary b : bookList) {
			if (id == b.bookId) {
				System.out.println(" the item aready in the labrary we need onley num_of_copies  ");
				System.out.println(" Enter the num_of_copies of book ");
			Scanner s = new Scanner(System.in);
			b.noCopies += s.nextInt();

			return true;

		}

	}
		return false;


	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public void addStudent() {
		StudentAndOpration newStudent = new StudentAndOpration();

		System.out.println(" Enter the Id of  student ");
		int newId=s.nextInt();
		boolean ok = checkstudent(newId);
		if(ok)return;
		
		newStudent.id=newId;
		System.out.println(" Enter the name of student ");
		newStudent.name=s.next();
		
		studentList.add(newStudent);
		
		System.out.println(" the add is successful  ");	
		System.out.println(" num of student is   "+ studentList.size());		

	}
	//////////////
	public boolean checkstudent(int idSt) {

		for (StudentAndOpration st : studentList) {
			if (idSt == st.getId()) {
				System.out.println(" the student is ardut in system this studet cay issue or buy ");		
              // st.num_TakenBook++;
				return true;
			}

		}
		return false;

	}
/////////////////////////////////////////////////////////////////////////////////////////////////
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//@Override
	
	public void removeBook() {

		Book oldBook = new Book();
		
     System.out.println(" entr name of the book you want to remove ");
     String name=s.next();
     boolean ok=true;
	 
     for(ItemLibrary b :bookList) {
    	 if( name.equalsIgnoreCase(b.bookName)) {
    	     System.out.println(" the name found  ");

    		 bookList.remove( bookList.indexOf(b));
    	     System.out.println(" and remove done ");
              ok =false;
              break;
    	 }
    	 
     }
     if(ok) System.out.println(" the book name do not fount in libriary   ");

		

	}
	
	
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//@Override
	public void removeStudent() {
		// TODO Auto-generated method stub
		
		
		StudentAndOpration oldBook = new StudentAndOpration();
		
	     System.out.println(" entr name of the book you want to remove ");
	     String name=s.next();
	     boolean ok=true;
		 
	     for(StudentAndOpration st :studentList) {
	    	 if( name.equalsIgnoreCase(st.getName())) {
	    	     System.out.println(" the name of student  found  ");

	    		 bookList.remove( bookList.indexOf(st));
	    	     System.out.println(" and remove done ");
	              ok =false;
	              break;
	    	 }
	    	 
	     }
	     if(ok) System.out.println(" the student name do not fount in systm   ");	
		
		
		
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void modifyStudnt() {

			
			int choose = 0;
			do {
				System.out.println(" =============================================");
				System.out.println(" || Enter (1) to change name of student      ||");
				System.out.println(" || Enter (2) to change id of student        ||");
				System.out.println(" || Enter (3) to change noCopy               ||");
				System.out.println(" ==============================================");
				
				choose = s.nextInt();
				switch (choose) {

				case 1: {

					boolean ok = true;
						System.out.println(" Enter the id student ");
						int sid = s.nextInt();
						for (StudentAndOpration st : studentList) {
							if (sid == st.id) {
								System.out.println(" Enter the name you waunt chage to  ");
								studentList.get(studentList.indexOf(st)).name = s.next();
								ok = false;
							}
						}
					

					break;
				}

				case 2: {
					boolean ok = true;
					while (ok) {
						System.out.println(" Enter the id student ");
						int sid = s.nextInt();
						for (StudentAndOpration st : studentList) {
							if (sid == st.id) {
								System.out.println(" Enter the id you yount chage to  ");
								studentList.get(studentList.indexOf(st)).id = s.nextInt();
								ok = false;
								
							}
						}
					}

					break;

				}
				
				case 3: {

					boolean ok = true;
					while (ok) {
						System.out.println(" Enter the id  of student ");
						int sId = s.nextInt();
						for (StudentAndOpration st : studentList) {
							if (sId == st.id) {
								System.out.println(" Enter the no of cpoy  you yount chage to  ");
								studentList.get(studentList.indexOf(st)).num_TakenBook= s.nextInt();
								ok = false;
							}
						}
					}

					break;
				}
				default: {
					System.out.println(" please inter num less or qual 3 ");

					break;
				}

				}
			} while (choose > 3);
		}
		
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void ModifyBook() {

			
			int choose = 0;
			do {
				System.out.println(" =============================================");
				System.out.println(" || Enter (1) to change name of book         ||");
				System.out.println(" || Enter (2) to change id of book           ||");
				System.out.println(" || Enter (3) to change authort of book      ||");
				System.out.println(" || Enter (4) to change borw state           ||");
				System.out.println(" || Enter (5) to change buy state            ||");
				System.out.println(" || Enter (6) to change kind state           ||");
				System.out.println(" || Enter (7) to change noCopy state         ||");
				System.out.println(" ==============================================");
				
				choose = s.nextInt();
				switch (choose) {

				case 1: {

					boolean ok = true;
					while (ok) {
						System.out.println(" Enter the id book ");
						int bid = s.nextInt();
						for (ItemLibrary it : bookList) {
							if (bid == it.bookId) {
								System.out.println(" Enter the name you yount chage to  ");
								bookList.get( bookList.indexOf(it)).bookName=s.next();
								ok = false;
							}
						}
					}

					break;
				}

				case 2: {
					boolean ok = true;
					while (ok) {
						System.out.println(" Enter the id book ");
						int bid = s.nextInt();
						for (ItemLibrary it : bookList) {
							if (bid == it.bookId) {
								System.out.println(" Enter the id you yount chage to  ");
								bookList.get( bookList.indexOf(it)).bookId=s.nextInt();
								ok = false;
							}
						}
					}

					break;

				}
				case 3: {

					boolean ok = true;
					while (ok) {
						System.out.println(" Enter the auth  of book ");
						int bId = s.nextInt();
						for (ItemLibrary it : bookList) {
							if (bId == it.bookId) {
								System.out.println(" Enter the auther you yount chage to  ");
								bookList.get( bookList.indexOf(it)).author =s.next();
								ok = false;
							}
						}
					}

					break;
				}
				case 4: {

					boolean ok = true;
					while (ok) {
						System.out.println(" Enter the auth  of book ");
						int bId = s.nextInt();
						for (ItemLibrary it : bookList) {
							if (bId == it.bookId) {
								System.out.println(" Enter the borw state you yount chage to  ");
								bookList.get( bookList.indexOf(it)).vaidBorw=s.nextBoolean();
								ok = false;
							}
						}
					}
					break;

				}
				case 5: {

					boolean ok = true;
					while (ok) {
						System.out.println(" Enter the auth  of book ");
						int bId = s.nextInt();
						for (ItemLibrary it : bookList) {
							if (bId == it.bookId) {
								System.out.println(" Enter the buiment state you yount chage to  ");
								bookList.get( bookList.indexOf(it)).vaildBuy=s.nextBoolean();
								ok = false;
							}
						}
					}
					break;
				}

				case 6: {

					boolean ok = true;
					while (ok) {
						System.out.println(" Enter the auth  of book ");
						int bId = s.nextInt();
						for (ItemLibrary it : bookList) {
							if (bId == it.bookId) {
								System.out.println(" Enter the Kind  you yount chage to  ");
								bookList.get( bookList.indexOf(it)).KindOfItem=s.next();
								ok = false;
							}
						}
					}

					break;
				}
				case 7: {

					boolean ok = true;
					while (ok) {
						System.out.println(" Enter the auth  of book ");
						int bId = s.nextInt();
						for (ItemLibrary it: bookList) {
							if (bId == it.bookId) {
								System.out.println(" Enter the noof cpoy  you yount chage to  ");
								bookList.get( bookList.indexOf(it)).noCopies=s.nextInt();
								ok = false;
							}
						}
					}

					break;
				}
				default: {
					System.out.println(" please enter num less or qual 6 ");

					break;
				}

				}
			} while (choose > 7);
		}

		
		
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void SearchByNameOfBook() {

		
			System.out.println(" Enter the  book  name ");
			String bName = s.next();
			for (ItemLibrary it: bookList) {
				if (it.bookName.equalsIgnoreCase(bName)) {
					System.out.println(" the book is found  ");
					System.out.println("");
					
					System.out.println(" ==============================================================================================================================================================================================================================================================");

						
						System.out.println(
								
								            " || the name of book is : "+it.bookName+" *** "+
						                	"    the id of book is : "+it.bookId+"***"+
						                	"    the author of book is :"+it.author+"***"+
						                	"    the  borw state of book is : "+it.vaidBorw+" *** "+
						                	"    the  buy state of book is : "+it.vaildBuy+" *** "+
						                	"    the  buy state of book is : "+it.KindOfItem+" *** "+
						                	"    the noCopy of book is : "+it.noCopies+" *** ||"
						               	);

						
					}
					System.out.println(" ==============================================================================================================================================================================================================================================================");


				}

			}

		

	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void SearchByNameOfStudent() {


		System.out.println(" Enter the  book  name ");
		String bName = s.next();
		for (StudentAndOpration st: studentList) {
			if (st.getName().equalsIgnoreCase(bName)) {
				System.out.println(" the student is found  ");


				System.out.println(" ===========================================================================================================");
					
					System.out.println(
							
							            " || the name of student is : "+st.name+" *** "+
					                	"    the id of student is : "+st.id+"***"+
					                	"    the noCopy of student is : "+st.num_TakenBook+" ||"

					               	);

					
				}
				System.out.println(" =======================================================================================================================");

				
			}

		}
		
		
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void viewAllbook() {
		
		System.out.println(" the labery item ");

			System.out.println(" ==============================================================================================================================================================================================================================================================");

			for(ItemLibrary b:bookList) {
				
				System.out.println(
						
						            " || the name of book is : "+b.bookName+" *** "+
				                	"    the id of book is : "+b.bookId+"***"+
				                	"    the author of book is :"+b.author+"***"+
				                	"    the  borw state of book is : "+b.vaidBorw+" *** "+
				                	"    the  buy state of book is : "+b.vaildBuy+" *** "+
				                	"    the  Kind    of book is : "+b.KindOfItem+" *** "+
				                	"    the noCopy of book is : "+b.noCopies+" *** ||"
				               	);

				
			}
			System.out.println(" ==============================================================================================================================================================================================================================================================");

		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void viewAllStudent() {
		System.out.println(" ==============================================================================================");

		for (StudentAndOpration st: studentList) {
			
			System.out.println(
					
					            " || the name of student is : "+st.name+" *** "+
			                	"    the id of student is : "+st.id+"***"+
			                	"    the noCopy of student is : "+st.num_TakenBook+" "

			               	);

			
			 for(int i=0;i<st.num_TakenBook;i++) {
					System.out.println(" nameBookTaken nom "+" "+i+" "+st.nameBookTaken[i]+" ");
					System.out.println(" nameBookTaken nom "+" "+i+" "+st.idBookTeaken[i]+" ||");
				 
		       }
		}
		System.out.println(" ====================================================================================================");
}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}
