package Mypackage;

import java.awt.ItemSelectable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class Student extends BasedCalss implements IStudentOpration {

	ArrayList<ItemLibrary> itemBrow;
	ArrayList<String> dataBookTeaken;
	private int num_TakenBook;

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	Student() {
		itemBrow = new ArrayList<ItemLibrary>();

		dataBookTeaken = new ArrayList<String>(5);
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public ArrayList<ItemLibrary> getItemBrow() {
		return itemBrow;
	}

	public void setItemBrow(ArrayList<ItemLibrary> itemBrow) {
		this.itemBrow = itemBrow;
	}

	public ArrayList<String> getDataBookTeaken() {
		return dataBookTeaken;
	}

	public void setDataBookTeaken(ArrayList<String> dataBookTeaken) {
		this.dataBookTeaken = dataBookTeaken;
	}

	public int getNum_TakenBook() {
		return num_TakenBook;
	}

	public void setNum_TakenBook(int num_TakenBook) {
		this.num_TakenBook = num_TakenBook;
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////issue////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void issueItem(LibraryAdimain ob_LibraryManger) {
		String test;
		Scanner s = new Scanner(System.in);
		int bId=0;
		boolean ok = true;
		boolean flag = true;
		while (ok) {
			System.out.println(" Enter the book id ");
			///////////////////////////
			try {
				//bId=s.nextInt();
			test = s.next();
			 bId = Helper.CheckAndConvertgToInt(test);          // to chack is num or not ant con vert to int
			if (bId == -1) {
				return;
			 }
			}
//////////////////////////////////////
//////////////////////////////////////
///////////////////////////
			catch (NullPointerException e) {
				s.next();
				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;
			}
			catch (ArithmeticException e) {
				s.next();

				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;
			}

			catch (Exception e) {
				s.next();

				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;

			}
			/////////////////////////////////////////////
			for (ItemLibrary b : ob_LibraryManger.itemsList) {                

				if (b.getId() == bId) {
					
					

					ok = false;
					System.out.println(" the book   found   ");
					if (b.getNoCopies() <= 5) {
						System.out.println(" but  you can not  brow it as we have 5 coby ontly or less   ");
						whenReturnThisItem(bId,ob_LibraryManger);                     // to calc the first copy return
						return;
					} else if (!b.isVaidBorw()) {
						System.out.println(" you can not brow is book as not vliable to brow  ");
					}

					else {
						System.out.println(" the book   can be brow  ");

						System.out.println(" enter id of student  ");
						int sId = s.nextInt();
						
						
						
						flag = checkSudedentInSystem(sId, ob_LibraryManger);
					boolean flagflag= check_this_item_take_by_this_studentBefore(   sId, bId,ob_LibraryManger);         /// check if this studten take this book or not 

						if (flag&&!flagflag) {
							check_number_book_taken_by_student(b, sId, ob_LibraryManger);
						}
						

						if (!flag)
							System.out.println(" you dont add this student so can not take book  ");

					}
					return;
				}
			}
			if (ok)
				System.out.println(" book not found if want to brak enter yes  else (no or any thing )to contine ");
			String cho = s.next();
			if (cho.equalsIgnoreCase("yes"))
				break;
		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void whenReturnThisItem(int ItemId,LibraryAdimain ob_LibraryManger) {            //to calc the first copy return
		
		int mnday=33;
		int mnmonth=33;
		int mnyear=100000000;
		int day=0,manth=0,year=0;
		int preiod=0 ;
		Scanner s=new Scanner(System.in);
		for (Student st : ob_LibraryManger.studentList) {


			for (int i = 0; i < st.dataBookTeaken.size(); i++) {

				if (st.itemBrow.get(i).getId() == ItemId) {

					
	                try {
					 day = Integer.parseInt(st.dataBookTeaken.get(i).substring(0, 2));
					 manth = Integer.parseInt(st.dataBookTeaken.get(i).substring(3, 5));
					 year = Integer.parseInt(st.dataBookTeaken.get(i).substring(6));

					 preiod = Integer.parseInt(st.itemBrow.get(i).getFreePeirod());
	              }
	              catch ( ArithmeticException e) {
	            	  s.next();
	            	  System.out.println(" invaild date   ");
		
	            	  continue;
	                   }
	                catch ( Exception e) {
		            	  System.out.println(" invaild date  ");
			
		                   }
	
					day += preiod;

					if (day > 30) {
						day -= 30;
						manth++;
					}

					if (manth > 12) {
						manth -= 12;
						year++;

					}
					
					
					if(mnyear>year) {
						
						mnyear=year;
						mnmonth=manth;
						mnday=day;
						
					}
					
					else	if(mnyear==year) {
						
						if(mnmonth>mnmonth) {
							

							mnyear=year;
							mnmonth=manth;
							mnday=day;
						}
						else if(mnmonth==mnmonth) {
							
							if(mnday>day) {
								
								mnyear=year;
								mnmonth=manth;
								mnday=day;
							}
							
						}
						
					}
					
					
					
					

				}
			}
		}
		if(mnmonth!=33) {
		System.out.println("  we can come  in  {  "+mnday+"/"+mnmonth+"/"+mnyear+"}    first copy  will be return     ");
		}
		else 		System.out.println("no copy brow from this book still to suply the librairy by item sorry ");

	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public boolean checkSudedentInSystem(int sId, LibraryAdimain ob_LibraryManger) {

		Scanner s = new Scanner(System.in);

		for (Student st : ob_LibraryManger.studentList) {
			if (st.getId() == sId) {
				

	        	System.out.println("  hay *******student in system **********");
				 return true;
			}
		}
		System.out.println(" student not in  system you shoud add him   ");
		System.out.println("if you want add him enter (yes) else (no or any thing)  ");
		String want = s.next();
		if (want.equalsIgnoreCase("yes")) {
			  Helper.Passward();
			ob_LibraryManger.addStudent();
			return true;

		}
		return false;

	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public Boolean check_this_item_take_by_this_studentBefore( int sId, int bId, LibraryAdimain ob_LibraryManger ) {
		
		
		for (Student st : ob_LibraryManger.studentList) {
			if (st.getId() == sId) {
				for(ItemLibrary it:st.itemBrow) {
              if(it.getId()==bId) {
				System.out.println(" but as You can not  take bool more than one   !!!  ولا ضيعت الكتاب يلا  والله انفخك   ");
				 return true;
                    }
				}
			}
		}
		
		 return false;
		
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void check_number_book_taken_by_student(ItemLibrary b, int sId, LibraryAdimain ob_LibraryManger) {

		Scanner s = new Scanner(System.in);

		boolean ok = true;
		for (Student st : ob_LibraryManger.getStudentList()) {
			if (st.getId() == sId) {
				ok = false;
				if (st.num_TakenBook >= 5) {
					System.out.println(" but you can not tack more than 5 book ");
					boolean flag = checkSudedenWantReturnBook(ob_LibraryManger);

				} else {

					takenData(b, st, ob_LibraryManger);
					// itemBrow.add(b);
					ob_LibraryManger.studentList.get(ob_LibraryManger.studentList.indexOf(st)).itemBrow.add(b);
					b.setNoCopies(b.getNoCopies() - 1);

					System.out.println("********************************************************");
					System.out.println(" borow  item is done                                  ||");
					System.out.println("student " + st.getName() + "                                        ||");
					System.out.println("brow book id " + b.getId() + "                                         ||");
					System.out.println(" book name " + b.getName() + "                                        ||");
					System.out.println("in data " + st.dataBookTeaken.get(st.num_TakenBook)
							+ "                                          ||");
					st.num_TakenBook++;
					System.out.println(
							"  and he take  " + st.num_TakenBook + "  item                                 ||");
					System.out.println("*******************************************************");

					return;
				}

				break;
			}

		}
		if (ok) {
			System.out.println(" student not fount in System  may be you add anther id when we ask you add student ");

		}
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void takenData(ItemLibrary booK, Student st, LibraryAdimain ob_LibraryManger) {

		Scanner s = new Scanner(System.in);
		boolean ok = false;
		String dataBorow ="";
		while (true) {
			
			try {
			System.out.println(" Enter the day(**)  of brow ");
			String dayBow = s.next();
			///////////////////////////
			////////////////////////////////                                    //chick vaild input
			boolean che = Helper.iSnum(dayBow);
			if (!che) {
				System.out.println(" you must enter num not any thing ");
				continue;
			}
			//////////////////////////////////
			//////////////////////////////
			if (dayBow.length() == 1)
				dayBow = 0 + dayBow;
			dayBow = dayBow.trim();

			System.out.println(" Enter the month (**) of brow ");
			String monthBow = s.next();
			///////////////////////////
			//////////////////////////////// //chick vaild input
			che = Helper.iSnum(monthBow);
			if (!che) {
				System.out.println(" you must enter num not any thing ");
				continue;
			}
			//////////////////////////////////
			//////////////////////////////
			if (monthBow.length() == 1)
				monthBow = 0 + monthBow;
			monthBow = monthBow.trim();
			System.out.println(" Enter the year (****) of brow ");
			String yearBrow = s.next();
			///////////////////////////
			/////////////////////////////// ///chick vaild input
			che = Helper.iSnum(yearBrow);
			if (!che) {
				System.out.println(" you must enter num not any thing ");
				continue;
			}
			//////////////////////////////////
			//////////////////////////////
			yearBrow = yearBrow.trim();
			 dataBorow = dayBow + "/" + monthBow + "/" + yearBrow;
			dataBorow = dataBorow.trim();
			ok = Helper.chickVaildTime(dayBow, monthBow, yearBrow);
			}
//////////////////////////////////////
catch (IndexOutOfBoundsException e) {
s.next();
System.out.println(" you should inter num not alpha. ");
continue;

} catch (ArithmeticException e) {
s.next();

System.out.println(" you should inter num not alpha. ");
continue;
} catch (Exception e) {
s.next();

System.out.println(" you should inter num not alpha.. ");
continue;
}
///////////////////////////////////////////
			if (ok) {
				ob_LibraryManger.studentList.get(ob_LibraryManger.studentList.indexOf(st)).dataBookTeaken
						.add(dataBorow);
				return;
			}
		}
	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public boolean checkSudedenWantReturnBook(LibraryAdimain ob_LibraryManger) {

		Scanner s = new Scanner(System.in);
		String choose;

		System.out.println(" if student want to return book entr (yes) else  (on or any thing )  ");
		choose = s.next();

		if (choose.equalsIgnoreCase("yes")) {
			  Helper.Passward();
			returnItem(ob_LibraryManger);
			return true;
		} else {
			System.out.println(" then you do not return any book you can not take book");
			return false;
		}

	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////return //////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void returnItem(LibraryAdimain ob_LibraryManger) {

		boolean flag = true;
		boolean ok = true;
		String test="";
		int bId=0;
		while (ok) {

			Scanner s = new Scanner(System.in);

			System.out.println(" Enter the book id ");
			////////////////////////////////
			////////////////////////////////    // to check id
			try {
			  test = s.next();
			 bId = Helper.CheckAndConvertgToInt(test);
			if (bId == -1) {
				System.out.println("not vaild inpute this student do not add");
				continue;
			  }
			}
			
			catch (Exception e) {
				s.next();
				System.out.println("not vaild inpute this student do not add");
				continue;

			}
			/////////////////////////////////////////////////////////
			/////////////////////////////////////////////////////////////
			System.out.println(" Enter the  Student  id  that brow  item of labriary ");

////////////////////////////////
////////////////////////////////                                                   // to check id 
			test = s.next();
			int sId = Helper.CheckAndConvertgToInt(test);
			if (sId == -1) {
				System.out.println("not vaild inpute this student do not add");
				continue;
			}
/////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////

			for (Student st : ob_LibraryManger.studentList) {

				if (sId == st.getId()) {
					flag = false;
					System.out.println(" id is  of student found in system  ");

					int index = ob_LibraryManger.studentList.indexOf(st);

					for (ItemLibrary b : ob_LibraryManger.studentList.get(index).itemBrow) {

						if (bId == b.getId()) {

							System.out.println(" id is found of book  ");
							decrease_num_book_taken_by_student(b, st, sId, ob_LibraryManger);
							ok = false;
							break;
						}

					}
					break;
				}
			}
			if (flag)
				System.out.println(" student not found if want to brak enter 1 else any  ");
			if (ok)
				System.out.println(" obs!!? this book do not brow by this student   may by you wrong entr input  ");
			if (ok) {
				System.out.println("if  you want break enter (yes) else {no or any thing athe}   ");
				String cho = s.next();
				if (cho.equalsIgnoreCase("yes"))
					break;
			}
		}
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void decrease_num_book_taken_by_student(ItemLibrary itemtaken, Student st, int sId,
			LibraryAdimain ob_LibraryManger) {

		if (st.getNum_TakenBook() <= 0) {
			System.out.println(" this studen not take ");
			return;
		}

		int cnt = 0;
		for (ItemLibrary ib : st.itemBrow) {
			if (ib.getId() == itemtaken.getId()) {
				st.itemBrow.remove(ib);
				break;
			}
			cnt++;
		}
////////////////////////////////////////////////////////////////////////
		payment(st, cnt, itemtaken);
/////////////////////////////////////////////////////////////////////////
		try {
		System.out.println("*************************************************************");
		System.out.println("|| remove item from student take item brow                  ||");
		st.dataBookTeaken.remove(st.dataBookTeaken.get(cnt));
		System.out.println("|| remove data of item return    from student               ||");
		st.num_TakenBook--;
		/////////////////////////////////////////////
		ItemLibrary changeItem;
		changeItem = itemtaken;

		if (!ob_LibraryManger.itemsList.contains(changeItem)) {                                    // to if you remove it from lite
			itemtaken.setNoCopies(0);
			ob_LibraryManger.itemsList.add(itemtaken);

		}

		changeItem.setNoCopies(changeItem.getNoCopies() + 1);
		ob_LibraryManger.itemsList.set(ob_LibraryManger.itemsList.indexOf(itemtaken), changeItem);////////////// not
																									////////////// complet
		
		System.out.println("|| item return to labrairy                                      ||");
		System.out.println("*****************************************************************");
		}catch (Exception e) {
			new Scanner(System.in);
			System.out.println("  not vaild input in array try again");
              
		}
		
		return;

	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////maney ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void payment(Student st, int cnt, ItemLibrary itemtake) {

		Scanner s = new Scanner(System.in);
		boolean ok = false;
		boolean che;
		String borwData = "";
		boolean ok2 = true;
		while (!ok || !ok2) {

			borwData = st.dataBookTeaken.get(cnt);
			System.out.println("********** the brow data of this book is*************{ " + borwData + " }");
            try {
			System.out.println(" Enter the return  day(** or *)  of brow ");
			String dayRe = s.next();
		////////////////////////////////// //chick vaild input
			che = Helper.iSnum(dayRe);
			if (!che) {
				System.out.println(" you must enter num not any thing ");
				continue;
			}
		/////////////////////////////////////////
			if (dayRe.length() == 1)
				dayRe = 0 + dayRe;
			dayRe = dayRe.trim();
	///////////////////////////////////////////
			System.out.println(" Enter the  return month (** or *) of brow ");
			String monthRe = s.next();
	/////////////////////////////// ///chick vaild input
			che = Helper.iSnum(monthRe);
			if (!che) {
				System.out.println(" you must enter num not any thing ");
				continue;
			}
			//////////////////////////////////
			if (monthRe.length() == 1)
				monthRe = 0 + monthRe;
			monthRe = monthRe.trim();
			System.out.println(" Enter the return year (****) of brow ");
			String yearRe = s.next();
			//////////////////////////////////////////                                      ///chick vaild input
			che = Helper.iSnum(yearRe);
			if (!che) {
				System.out.println(" you must enter num not any thing ");
				continue;
			}
			/////// //////////////////////////////////
			yearRe = yearRe.trim();
			String dataٌeturn = dayRe + "/" + monthRe + "/" + yearRe;
			dataٌeturn = dataٌeturn.trim();
			ok = Helper.chickVaildTime(dayRe, monthRe, yearRe);
			ok2 = Helper.chickVaildReturnTime(dayRe, monthRe, yearRe, borwData);

			if (ok2)
				System.out.println(" return time  is vaild ");
			else
				System.out.println(" return time not vaild ");
			if (ok && ok2) {

				long allDay = calcTime(dataٌeturn, borwData);
				System.out.println(" the preiod is = " + allDay);
				calcTax(allDay, itemtake);
				break;
			}
}
catch (Exception e) {
	s.next();
	System.out.println(" not vaild input!..");
continue;
}
		}

	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public long calcTime(String dataٌeturn, String oldTime) {
		Scanner s=new Scanner(System.in);
		long endDate=0, statrDate=0;
try {
		 statrDate = Integer.parseInt(oldTime.substring(0, 2)) + (30 * Integer.parseInt(oldTime.substring(3, 5)))
				+ (30 * 12 * Integer.parseInt(oldTime.substring(6)));
	//	System.out.println("  start " + statrDate);

		 endDate = Integer.parseInt(dataٌeturn.substring(0, 2))
				+ (30 * Integer.parseInt(dataٌeturn.substring(3, 5)))
				+ (30 * 12 * Integer.parseInt(dataٌeturn.substring(6)));
		
}

//////////////////////////////////////
catch (IndexOutOfBoundsException e) {
s.next();
System.out.println(" you should enter num not alpha. ");

} catch (ArithmeticException e) {
s.next();

System.out.println(" you should inter num not alpha. ");

} catch (Exception e) {
s.next();

System.out.println(" you should inter num not alpha.. ");

}
///////////////////////////////////////////
		long numOfAlDay = endDate - statrDate;
		return numOfAlDay;

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void calcTax(long days, ItemLibrary ob) {

		ob.calcTax(days);

	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
///////////////////////////////////////////////////////////buy item ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		

	public void buyItem(LibraryAdimain ob_LibraryManger) {
		String test;
		Scanner s = new Scanner(System.in);
		int bid=0;
		boolean ok = true;
		while (ok) {
			System.out.println(" entre the book id ");
			////////////////////////
			////////////////////////

		try {
			test = s.next();
		
			 bid = Helper.CheckAndConvertgToInt(test);
			if (bid == -1) {
				return;
			}
			}
///////////////////////////////////////////////
catch (IndexOutOfBoundsException e) {
	s.next();
System.out.println(" you should inter num not alpha. ");
continue;
} catch (ArithmeticException e) {
	s.next();

System.out.println(" you should inter num not alpha. ");
continue;
} catch (Exception e) {
	s.next();

System.out.println(" you should inter num not alpha.. ");
continue;
}
//////////////////////////////////////////////
			///////////////////////////

			for (ItemLibrary b : ob_LibraryManger.itemsList) {
				if (bid == b.getId()) {

					if (b.getNoCopies() > 5 && b.isVaidBorw()) {

						System.out.println(" the price is " + b.getItemPrice());
						System.out.println(
								" if you have this mony and wwant to by this enter yes  else(no or any thing) ");
						String cho = s.next();
						if (cho.equalsIgnoreCase("yes")) {
							System.out.println(" the process of buing done  succesuly");
							b.setNoCopies(b.getNoCopies() - 1);
						} else if (cho.equalsIgnoreCase("no")) {
							System.out.println(" you do not buy it ");
						} else
							System.out.println(" wrong choose  you do not buy it  ");
					}

					else if (!b.isVaidBorw())
						System.out.println(" not allow to buy it book");
					else if (b.getNoCopies() <= 5)
						System.out.println(" you cant take this book as we have only 5 copy or lees from them ");

					ok = false;
				}

			}
			if (ok) {
				System.out.println(" book do not found   ");
				ok = false;
			}

		}

	}


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	
	
}