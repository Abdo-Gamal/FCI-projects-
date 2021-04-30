package Mypackage;

import java.nio.charset.MalformedInputException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.management.MalformedObjectNameException;
import javax.swing.plaf.BorderUIResource.MatteBorderUIResource;
import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;

public class LibraryAdimain implements IMangerOpration {

	Scanner s;
	ArrayList<ItemLibrary> itemsList;
	ArrayList<Student> studentList;

	LibraryAdimain() {
		s = new Scanner(System.in);
		itemsList = new ArrayList<ItemLibrary>();
		studentList = new ArrayList<Student>();
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////

	public ArrayList<ItemLibrary> getItemsList() { // return itemsList
		return itemsList;
	}

	public void setItemsList(ArrayList<ItemLibrary> itemsList) {
		this.itemsList = itemsList;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void addItem(int key) {
		int newId = 0;
		String test;
		ItemLibrary item = null;
		int loop;
		System.out.println(" Enter num of item  you want enter ");
		///////////////////
		test = s.next();
		loop = Helper.CheckAndConvertgToInt(test);
		if (loop == -1) {

			return;
		}
		///////////////////////
		for (int i = 0; i < loop; i++) {

			if (key == 2) {
				item = new Book();
			}
			if (key == 3) {
				item = new Booklet();
			}
			
			if (key == 4) {
				item = new Magazine();
			}

			System.out.println(" Enter the Id of item " + (itemsList.size() + 1));
			////////////
			try {
				newId=s.nextInt();
				//test = s.next();
				//newId = Helper.CheckAndConvertgToInt(test);
				//if (newId == -1) {
					decrease_num_of_kind_of_item(item); // decrease no of ind of item
					//////////////////////////////////////
				//	System.out.println(" not vaild input this item do not add");
					//continue;
				//}
				//////////////////////////////////////
			} catch (IndexOutOfBoundsException e) {
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
			/////////////////////
			boolean ok = chickIdItemletFound(newId);
			if (ok)
				continue;
			item.setId(newId);

			s.nextLine();
			System.out.println(" Enter the name of item " + (itemsList.size() + 1));
			String nB = s.nextLine();
			nB = nB.trim(); // to delete space
			/////////////////////////////////////////
			if (!Helper.iSword(nB)) {

				decrease_num_of_kind_of_item(item); // decrease no of ind of item

				//////////////////////////////////////
				System.out.println("this is not name we allow by (space ,#,alpha,_) and this item do not add");
				continue;
			}
			////////////////////////////////////////
			item.setName(nB);
			System.out.println(" Enter the num_of_copies of item " + (itemsList.size() + 1));
			///////////////////////
			test = s.next();
			int noCo = Helper.CheckAndConvertgToInt(test);
			if (noCo == -1) {
				decrease_num_of_kind_of_item(item); // decrease no of ind of item
				System.out.println("this is not number and this item do not add");
				continue;
			}

			////////////////////////////////
			item.setNoCopies(noCo);
			s.nextLine();
			System.out.println(" Enter the name of Author " + (itemsList.size() + 1));
			String nA = s.nextLine();
			nA = nA.trim();                           // to delete space
			//////////////////////////////////////////////
			if (!Helper.iSword(nA)) {

				decrease_num_of_kind_of_item(item); // decrease no of ind of item
				System.out.println("this is not name we allow by (space ,#,alpha,_) and this item do not add");
				continue;
			}
			////////////////////////////////////////
			item.setAuthor(nA);

			itemsList.add(item);
			System.out.println(" Add  new item is done ");
			System.out.println(" size of librairy is  = " + itemsList.size());
			System.out.println(" number  of book is  = " + Book.getNoBook());
			System.out.println(" number  of booklet is  = " + Booklet.getNoBooklet());
			System.out.println(" number  of magazine is  = " + Magazine.getNoMagazine());
			// bEx=false;
		}

	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void decrease_num_of_kind_of_item(ItemLibrary item) {
		// decrease no of ind of item

		///////////////////////////////////////
		if (item instanceof Book)
			Book.setNoBook(Book.getNoBook() - 1);
		else if (item instanceof Booklet)
			Booklet.setNoBooklet(Booklet.getNoBooklet() - 1);
		else if (item instanceof Magazine)
			Magazine.setNoMagazine(Magazine.getNoMagazine() - 1);

//////////////////////////////////////

	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public boolean chickIdItemletFound(int id) {
		String test;
		for (ItemLibrary b : itemsList) {
			if (id == b.getId()) {
				decrease_num_of_kind_of_item(b); // to decreas number of kind ==>(noKind)
				System.out.println(" the item aready in the labrary we need onley num_of_copies  ");
				System.out.println(
						" Enter the num_of_copies of item this copy wiil be in kind(type)of the old item ok?you should know ");
				///////////////////////////////////
				test = s.next();
				int no = Helper.CheckAndConvertgToInt(test);
				if (no == -1) {
					System.out.println("not vaild inpute this student do not add");
					continue;
				}
				//////////////////////////////
				b.setNoCopies(no + b.getNoCopies());
				return true;

			}

		}
		return false;

	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public void addStudent() {

		String test;
		System.out.println(" Enter num of sudent you want enter ");
		int loop = 0;
		try {

			loop = s.nextInt();
		}

		catch (ArithmeticException e) {
			s.next();
			System.out.println(" you should inter num not alpha. ");
                    
		} catch (IndexOutOfBoundsException e) {
			s.next();
			System.out.println(" you should inter num not alpha.! ");

		} catch (NullPointerException e) {
			s.next();
			System.out.println(" you should inter num not alpha.. ");

		}

		catch (Exception e) {
			s.next();
			System.out.println(" you should inter num not alpha... ");

		}
		////////////////////////////////

		for (int i = 0; i < loop; i++) {

			Student newStudent = new Student();

			System.out.println(" Enter the Id of  student " + (studentList.size() + 1));
			////////////////////////////////
			int newId = 0;
			////////////////////////////////
			try {
				test = s.next();
				newId = Helper.CheckAndConvertgToInt(test);
				if (newId == -1) {
					System.out.println("not vaild inpute this student do not add");
					continue;
				}
			}
			//////////////////////////////////////////////////////////////////////////
			catch (NullPointerException e) {
				s.next();
				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;
			} catch (ArithmeticException e) {
				s.next();

				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;
			}

			catch (Exception e) {
				s.next();

				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;

			}
			///////////////////////////////////////////
			boolean ok = checkstudent(newId);
			if (ok)
				continue;

			newStudent.setId(newId);
			s.nextLine();
			System.out.println(" Enter the name of student " + (studentList.size() + 1));
			String nS = s.nextLine();
			nS = nS.trim(); // to delete space
			/////////////////////////////////////////
			if (!Helper.iSword(nS)) {
				System.out.println("this is not name we allow by (space ,#,alpha,_) and this item do not add");
				continue;
			}
			////////////////////////////////////////
			newStudent.setName(nS);

			studentList.add(newStudent);

			System.out.println(" the add is successful  ");
			System.out.println(" num of student is   " + studentList.size());

		}
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public boolean checkstudent(int idSt) {

		for (Student st : studentList) {
			if (idSt == st.getId()) {
				System.out.println(" the student is alredy in system this studet can issue or buy ");
				return true;
			}
		}
		return false;

	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// @Override
	// ===>comblite
	public void removeBook() {
		String test;
		Book oldBook = new Book();
		int bId = 0;
		System.out.println(" entr id of the book you want to remove ");
		try {
			//////////////////
			test = s.next();
			bId = Helper.CheckAndConvertgToInt(test); // to chack is num or not ant con vert to int
			if (bId == -1) {
				return;
			}
		}
/////////////////////////////////////////
		catch (ArithmeticException e) {
			s.next();
			System.out.println(" you should inter num not alpha. ");

		} catch (IndexOutOfBoundsException e) {
			s.next();
			System.out.println(" you should inter num not alpha.! ");

		} catch (NullPointerException e) {
			s.next();
			System.out.println(" you should inter num not alpha.. ");

		}
////////////////////////////////////////

		boolean ok = true;

		for (ItemLibrary b : itemsList) {

			/////////////////////////////////////// // decrease no of ind of item
			decrease_num_of_kind_of_item(b);
			//////////////////////////////////////

			if (bId == b.getId()) {
				System.out.println(" the item found  ");

				itemsList.remove(itemsList.indexOf(b));
				System.out.println(" and remove done ");
				System.out.println(" and the size of labrain become " + itemsList.size());

				ok = false;
				break;
			}

		}
		if (ok)
			System.out.println(" the book name do not fount in libriary   ");

	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// @Override
	public void removeStudent() {
		String test = "";
		System.out.println(" entr id of the student you want to remove ");

		//////////////////
		test = s.next();
		int sId = Helper.CheckAndConvertgToInt(test); // to chack is num or not ant con vert to int
		if (sId == -1) {
			return;
		}
		/////////////////////
		boolean ok = true;

		for (Student st : studentList) {
			if (sId == st.getId()) {

				System.out.println(" the  student  found  ");
				int num_brow = st.itemBrow.size();

				if (num_brow > 0) {
					System.out.println(" the student brow  " + num_brow + "item");
					System.out.println(" all brow item will be lost  ");
					/////////////////
					System.out.println(
							" if you want stop enter yes else no (if you enter any thing ather (yes or no) sorry we delete  )");
					String cho = s.next();
					if (cho.equalsIgnoreCase("yes")) {
						System.out.println(" we dont remove this student  ");
						return;
					}
				}
				/////////////////////////
				studentList.remove(studentList.indexOf(st));
				System.out.println(" and remove done ");
				System.out.println(" and the size of Student become " + studentList.size());

			}
		}
		if (ok)
			System.out.println(" the student name do not fount in systm or you do not enter vaild choose   ");

	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////modyfiy student ///////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	// @Override
	public void modifyStudnt(LibraryAdimain ob_LibraryManger) {

		int choose = 0;
		String test;
		do {

			Helper.showTableOfModifyStudent();
			////////////////////////////////
			test = s.next();
			choose = Helper.CheckAndConvertgToInt(test); // to chack is num or not ant con vert to int
			if (choose == -1) {
				continue;
			}
			///////////////////////////////////
			switch (choose) {

			case 1: {

				modfiyNameOfStudent();
				break;
			}

			case 2: {
				modfiyIdOfStudent();
				break;

			}

			case 3: {
				modfiyNumberOfCobyOfStudent(ob_LibraryManger);
				break;
			}
			default: {
				System.out.println(" please inter num less or qual 3 ");
				break;
			}

			}
		} while (choose > 3);
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void modfiyNameOfStudent() {

		String test;
		int sid = 0;
		boolean ok = true;
		while (ok) {

			System.out.println(" Enter the id student ");

			///////////////////////
			try {
				test = s.next();
				sid = Helper.CheckAndConvertgToInt(test); // to chack is num or not ant con vert to int
				if (sid == -1) {
					continue;
				}
			}
//////////////////////////////////////////////////////////////////////////
			catch (NullPointerException e) {
				s.next();
				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;
			} catch (ArithmeticException e) {
				s.next();

				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;
			}

			catch (Exception e) {
				s.next();

				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;

			}
///////////////////////////////////////////
			s.nextLine(); // to take imptyline
			Student st = checksStudentFound(sid);
			if (st != null) {
				System.out.println(" Enter the name you waunt chage to  ");

				/////////////////////////////////////////
				String iN = s.nextLine();
				if (!Helper.iSword(iN)) {
					System.out.println("this is not name we allow by (space ,#,alpha,_) and this item do not add");
					continue;
				}
				////////////////////////////////////////
				studentList.get(studentList.indexOf(st)).setName(iN);
				System.out.println(" done  ");
				ok = false;

			}

			if (ok) {
				System.out.println(" if you want to break enter yes else (no or any thing ) ");
				if (s.next().equalsIgnoreCase("yes"))
					break;
			}
		}

	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void modfiyIdOfStudent() {

		String test;
		boolean ok = true;
		boolean flag = true;
		test = "";
		int sid = 0;

		while (ok) {
			System.out.println(" Enter the id student ");
			///////////////////////

			try {
				test = s.next();
				sid = Helper.CheckAndConvertgToInt(test); // to chack is num or not ant con vert to int
				if (sid == -1) {
					return;
				}
			}

//////////////////////////////////////////////////////////////////////////
			catch (NullPointerException e) {
				s.next();
				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;
			} catch (ArithmeticException e) {
				s.next();

				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;
			}

			catch (Exception e) {
				s.next();

				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;

			}
///////////////////////////////////////////
			Student st = checksStudentFound(sid);
			if (st != null) {
				System.out.println(" Enter the id you yount chage to  ");
				///////////////////////
				int sId = 0;
				try {
					test = s.next();
					sId = Helper.CheckAndConvertgToInt(test); // to chack is num or not ant con vert to int
					if (sId == -1) {
						continue;
					}
				}
				/////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
				catch (NullPointerException e) {
					s.next();
					System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
					continue;
				} catch (ArithmeticException e) {
					s.next();

					System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
					continue;
				}

				catch (Exception e) {
					s.next();

					System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
					continue;

				}
///////////////////////////////////////////
				////////////////////////////////////////

				/////////////////////////////
				flag = checkstudent(sId);
				if (flag)
					System.out.println(" and you can not change to try aganain  ");

				if (!flag) {
					studentList.get(studentList.indexOf(st)).setId(sId);
					System.out.println(" done  ");

					ok = false;
				}
			}
			if (flag) {
				System.out.println(" if you want to break enter yes else no or any thing ");
				if (s.next().equalsIgnoreCase("yes"))
					break;
			}
		}
	}

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void modfiyNumberOfCobyOfStudent(LibraryAdimain ob_LibraryManger) { // not comblite still ==>comblite

		String test = "";
		boolean ok = true;
		int numTakenitem = -1;
		int sId = 0;
		while (ok) {

			System.out.println(" Enter the id  of student ");
			//////////////////////////////////////////////////////////////

			////////////////////////
			try {
				test = s.next();
				sId = Helper.CheckAndConvertgToInt(test); // to chack is num or not ant con vert to int
				if (sId == -1) {
					continue;
				}

			}
//////////////////////////////////////////////////////////////////////////
			catch (NullPointerException e) {
				s.next();
				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;
			} catch (ArithmeticException e) {
				s.next();

				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;
			}

			catch (Exception e) {
				s.next();

				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;

			}
///////////////////////////////////////////
			///////////////////////////////////////////////////////////////
			Student st = checksStudentFound(sId);
			if (st != null) {

				System.out.println(" Enter the num of student item   you yount chage to  ");

				///////////////////////
				try {
					test = s.next();
					numTakenitem = Helper.CheckAndConvertgToInt(test); // to chack is num or not ant con vert to int
					if (numTakenitem == -1) {
						continue;
					}
				} catch (NullPointerException e) {
					s.next();
					System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");

				} catch (ArithmeticException e) {
					s.next();

					System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");

				}

				catch (Exception e) {
					s.next();

					System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");

				}
				////////////////////////////////////////////////////////////////////
				if (numTakenitem >= 0 && numTakenitem <= 5) {

					System.out.println("you sould  enter the data of this issuement  first  and we now go to do  ");
					for (int i = 0; i < numTakenitem; i++) {
						st.issueItem(ob_LibraryManger);
					}

					System.out.println(" finsh and if you can not enter data change not be   ");
					ok = false;
					break;

				}

				else
					System.out.println(" num of takent  should be leess or equal 5");
			}

			if ((numTakenitem < 0 || numTakenitem <= 5)) {
				System.out.println(" if you want to break enter yes else any thing  ");
				if (s.next().equalsIgnoreCase("yes"))
					break;

			}
		}

	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////modyfiy item/////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public void ModifyItem() {

		String test = "";
		int choose = 0;
		do {
			Helper.showTableOfModifyItem();
			try {
				////////////////////////////////
				test = s.next();
				choose = Helper.CheckAndConvertgToInt(test); // to chack is num or not ant con vert to int
				if (choose == -1) {
					continue;
				}
			}
			///////////////////////////////////
//////////////////////////////////////////////////////////////////////////
			catch (NullPointerException e) {
				s.next();
				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;
			} catch (ArithmeticException e) {
				s.next();

				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;
			}

			catch (Exception e) {
				s.next();

				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;

			}
///////////////////////////////////////////

			switch (choose) {

			case 1: {
				changeItemName();

				break;
			}

			case 2: {

				changeItemId();
				break;

			}
			case 3: {
				changeItemAuther();
				break;
			}

			case 4: {
				changeItemBrowState();

				break;
			}
			case 5: {
				changeItemStateBuement();

				break;

			}

			case 6: {
				changeItemKind();
				break;
			}

			case 7: {

				changeItemNumberOfCopy();
				break;
			}
			default: {
				System.out.println(" please enter num less or qual 6 ");

				break;
			}

			}
		} while (choose > 7);
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void changeItemName() {
		String test;
		boolean ok = true;
		int bid = 0;
		while (ok) {
			System.out.println(" Enter the id item ");
			try {
				//////////////////////////////// //to check correct number or not
				test = s.next();
				bid = Helper.CheckAndConvertgToInt(test); // to chack is num or not ant con vert to int
				if (bid == -1) {
					continue;
				}
			}
//////////////////////////////////////////////////////////////////////////
			catch (NullPointerException e) {
				s.next();
				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;
			} catch (ArithmeticException e) {
				s.next();

				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;
			}

			catch (Exception e) {
				s.next();

				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;

			}
///////////////////////////////////////////

			///////////////////////////////////
			s.nextLine(); // to take the impty line
			ItemLibrary it = checksitemFound(bid);

			if (it != null) {
				System.out.println(" Enter the name you yount chage to  ");
				///////////////////////////////////////// //to check correct name or not
				String iN = s.nextLine();
				if (!Helper.iSword(iN)) {
					System.out.println("this is not name we allow by (space ,#,alpha,_) and this item do not add");
					continue;
				}
				////////////////////////////////////////
				itemsList.get(itemsList.indexOf(it)).setName(iN);
				System.out.println(" done  ");
				ok = false;
				break;
			}

			// if(ok) {
			System.out.println(" if you want to break enter yes else no  ");
			if (s.next().equalsIgnoreCase("yes"))
				break;
			// }
		}

	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void changeItemId() {
		String test;
		boolean flag = false;
		boolean ok = true;
		while (ok) {
			int bid = 0;
			System.out.println(" Enter the id item ");
			//////////////////////////////// //to check correct number or not

			try {
				test = s.next();
				bid = Helper.CheckAndConvertgToInt(test); // to chack is num or not ant con vert to int
				if (bid == -1) {
					continue;
				}
			}
/////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////
			catch (NullPointerException e) {
				s.next();
				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;
			} catch (ArithmeticException e) {
				s.next();

				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;
			}

			catch (Exception e) {
				s.next();

				System.out.println(" obs!!! there were wrong in input can not accept  sorry ...");
				continue;

			}
///////////////////////////////////////////

////////////////////////////////////////
			///////////////////////////////////
			ItemLibrary it = checksitemFound(bid);
			if (it != null) {

				System.out.println(" Enter the id you want   chage to  ");
				//////////////////////////////// //to check correct number or not
				test = s.next();
				int newbid = Helper.CheckAndConvertgToInt(test); // to chack is num or not ant con vert to int
				if (newbid == -1) {
					continue;
				}
				///////////////////////////////////
				changeIdBookBrow(it.getId(), newbid); /////////// to change the id of book that student brow it
				flag = checksitemChangeTo(newbid);
				if (flag)
					System.out.println(" and can not change  ");
				if (!flag) {
					itemsList.get(itemsList.indexOf(it)).setId(newbid);
					System.out.println(" change done  ");
					// ok=false;
					return;
				}

			}
			// if(ok) {
			System.out.println(" if you want to break enter yes else no ");
			if (s.next().equalsIgnoreCase("yes"))
				break;
			// }
		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void changeItemAuther() {

		String test;
		boolean ok = true;
		int bId = 0;
		while (ok) {

			System.out.println(" Enter the id  of item ");
			//////////////////////////////// //to check correct number or not
			try {
				test = s.next();
				bId = Helper.CheckAndConvertgToInt(test); // to chack is num or not ant con vert to int
				if (bId == -1) {
					continue;
				}
			}
/////////////////////////////////////////
/////////////////////////////////////////
			catch (ArithmeticException e) {
				s.next();
				System.out.println(" you should inter num not alpha. ");
				continue;
			} catch (IndexOutOfBoundsException e) {
				s.next();
				System.out.println(" you should inter num not alpha.! ");
				continue;

			} catch (NullPointerException e) {
				s.next();
				System.out.println(" you should inter num not alpha.. ");
				continue;

			} catch (Exception e) {
				s.next();
				System.out.println(" you should inter num not alpha.. ");
				continue;

			}
////////////////////////////////////////

////////////////////////////////////////
			///////////////////////////////////
			s.nextLine(); // to take impty line
			ItemLibrary it = checksitemFound(bId);
			if (it != null) {

				System.out.println(" Enter the name auther you yount chage to  ");
				///////////////////////////////////////// // to check correct name or not
				String nA = s.nextLine();
				if (!Helper.iSword(nA)) {
					System.out.println("this is not name we allow by (space ,#,alpha,_) and this item do not add");
					continue;
				}
				////////////////////////////////////////
				itemsList.get(itemsList.indexOf(it)).setAuthor(nA);
				System.out.println(" done ");
				ok = false;
				break;
			}

			if (ok) {
				System.out.println(" if you want to break enter yes else no ");
				if (s.next().equalsIgnoreCase("yes"))
					break;
			}
		}

	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void changeItemBrowState() {
		String test;
		boolean ok = true;
		int bId = 0;
		while (ok) {

			System.out.println(" Enter the id  of item ");
			//////////////////////////////// //to check correct number or not
			try {
				test = s.next();
				bId = Helper.CheckAndConvertgToInt(test); // to chack is num or not ant con vert to int
				if (bId == -1) {
					continue;
				}
			}
/////////////////////////////////////////
/////////////////////////////////////////
			catch (ArithmeticException e) {
				s.next();
				System.out.println(" you should inter num not alpha. ");
				continue;
			} catch (IndexOutOfBoundsException e) {
				s.next();
				System.out.println(" you should inter num not alpha.! ");
				continue;

			} catch (NullPointerException e) {
				s.next();
				System.out.println(" you should inter num not alpha.. ");
				continue;

			} catch (Exception e) {
				s.next();
				System.out.println(" you should inter num not alpha.. ");
				continue;

			}
////////////////////////////////////////

////////////////////////////////////////
			///////////////////////////////////
			ItemLibrary it = checksitemFound(bId);
			if (it != null) {

				if (bId == it.getId()) {

					System.out.println(" Enter the brow state you yount chage to (yes)  or (no)  ");
					String state = s.next();
					if (state.equalsIgnoreCase("yse")) {
						itemsList.get(itemsList.indexOf(it)).setVaidBorw(true);
						System.out.println(" done ");

						ok = false;
					}
					if (state.equalsIgnoreCase("no")) {
						itemsList.get(itemsList.indexOf(it)).setVaidBorw(false);
						System.out.println(" done ");

						ok = false;
					}

					else {
						System.out.println(" Wrong choose  ");
					}
					break;

				}
			}

			if (ok) {
				System.out.println(" if you want to break enter yes else no ");
				if (s.next().equalsIgnoreCase("yes"))
					break;

			}
		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void changeItemStateBuement() {

		String test;
		boolean ok = true;
		int bId = 0;
		while (ok) {

			System.out.println(" Enter the id  of item ");
			////////////////////////////////// to check correct number or not
			try {
				test = s.next();
				bId = Helper.CheckAndConvertgToInt(test); // to chack is num or not ant con vert to int
				if (bId == -1) {
					continue;
				}

			}

/////////////////////////////////////////
/////////////////////////////////////////
			catch (ArithmeticException e) {
				s.next();
				System.out.println(" you should inter num not alpha. ");
				continue;
			} catch (IndexOutOfBoundsException e) {
				s.next();
				System.out.println(" you should inter num not alpha.! ");
				continue;

			} catch (NullPointerException e) {
				s.next();
				System.out.println(" you should inter num not alpha.. ");
				continue;

			} catch (Exception e) {
				s.next();
				System.out.println(" you should inter num not alpha.. ");
				continue;

			}
////////////////////////////////////////

////////////////////////////////////////
			///////////////////////////////////
			ItemLibrary it = checksitemFound(bId);

			if (it != null) {
				if (bId == it.getId()) {

					System.out.println(" Enter the buiment state you yount chage to  yes or no ");
					String state = s.next();
					if (state.equalsIgnoreCase("yse")) {

						itemsList.get(itemsList.indexOf(it)).setVaildBuy(true);
						ok = false;
						System.out.println(" done ");

					}

					if (state.equalsIgnoreCase("no")) {

						itemsList.get(itemsList.indexOf(it)).setVaildBuy(false);
						ok = false;
						System.out.println(" done ");

					}

					else {
						System.out.println("  choose wrong  ");
					}
				}
			}

			if (ok) {
				System.out.println(" if you want to break enter yes else no ");
				if (s.next().equalsIgnoreCase("yes"))
					break;
			}
		}

	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void changeItemKind() {

		String test;
		boolean ok = true;
		int bId = 0;
		while (ok) {
			System.out.println(" Enter the id  of item ");

			//////////////////////////////// //to check correct number or not
			try {
				test = s.next();
				bId = Helper.CheckAndConvertgToInt(test); // to chack is num or not ant con vert to int
				if (bId == -1) {
					continue;
				}
			}
/////////////////////////////////////////
			catch (ArithmeticException e) {
				s.next();
				System.out.println(" you should inter num not alpha. ");
				continue;
			} catch (IndexOutOfBoundsException e) {
				s.next();
				System.out.println(" you should inter num not alpha.! ");
				continue;

			} catch (NullPointerException e) {
				s.next();
				System.out.println(" you should inter num not alpha.. ");
				continue;

			} catch (Exception e) {
				s.next();
				System.out.println(" you should inter num not alpha.. ");
				continue;

			}
////////////////////////////////////////

			///////////////////////////////////
			ItemLibrary it = checksitemFound(bId);
			if (it != null) {
				System.out.println(" Enter (1)===>book** enter (2)===> booklet ** enter (3) ===> magazine  ");
				////////////////////////////////////////
				String typ = s.next();
				if (!Helper.iSnum(typ)) {
					System.out.println(" enter num not alpha  not make change ");
					continue;
				}

				decrease_num_of_kind_of_item(it); /////// to decrease number of kind
				ItemLibrary newItem = null;
				if (typ.equalsIgnoreCase("1")) {

					newItem = new Book();
					newItem.setAuthor(it.getAuthor());
					newItem.setName(it.getName());
					newItem.setId(it.getId());
					newItem.setNoCopies(it.getNoCopies());
					itemsList.remove(it);
					itemsList.add(newItem);

					System.out.println(" done ");
					ok = false;

				}

				else if (typ.equalsIgnoreCase("2")) {

					newItem = new Booklet();
					newItem.setAuthor(it.getAuthor());
					newItem.setName(it.getName());
					newItem.setNoCopies(it.getNoCopies());

					newItem.setId(it.getId());
					itemsList.remove(it);
					itemsList.add(newItem);
					System.out.println(" done ");
					ok = false;

				}

				else if (typ.equalsIgnoreCase("3")) {

					newItem = new Magazine();

					newItem.setAuthor(it.getAuthor());
					newItem.setName(it.getName());
					newItem.setId(it.getId());
					newItem.setNoCopies(it.getNoCopies());

					itemsList.remove(it);
					itemsList.add(newItem);
					System.out.println(" done ");

					ok = false;

				} else {
					System.out.println(" wrong choose   ");
				}
				//////////////////////////////////////// //to change type of book brow
				if (!ok) {
					for (Student st : studentList) {
						for (ItemLibrary ii : studentList.get(studentList.indexOf(st)).itemBrow) {
							if (ii.getId() == bId) {

								st.itemBrow.set(st.itemBrow.indexOf(ii), newItem);

							}
						}
					}
					System.out.println(" we change the all  Kind item  that  take  by any student   ");
				}
				////////////////////////////////////////

				if (ok) {
					System.out.println(" if you want to break enter yes else no ");
					if (s.next().equalsIgnoreCase("yes"))
						break;
				}
			}
		}

	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void changeItemNumberOfCopy() {
		String test;
		boolean ok = true;
		int bId = 0;
		while (ok) {
			System.out.println(" Enter the id  of item ");
			////////////////////////////////// to check correct number or not
			try {
				test = s.next();
				bId = Helper.CheckAndConvertgToInt(test); // to chack is num or not ant con vert to int
				if (bId == -1) {
					continue;
				}
			}
/////////////////////////////////////////
			catch (ArithmeticException e) {
				s.next();
				System.out.println(" you should inter num not alpha. ");
				continue;
			} catch (IndexOutOfBoundsException e) {
				s.next();
				System.out.println(" you should inter num not alpha.! ");
				continue;

			} catch (NullPointerException e) {
				s.next();
				System.out.println(" you should inter num not alpha.. ");
				continue;

			} catch (Exception e) {
				s.next();
				System.out.println(" you should inter num not alpha.. ");
				continue;

			}
////////////////////////////////////////

			///////////////////////////////////

			ItemLibrary it = checksitemFound(bId);
			if (it != null) {

				if (bId == it.getId()) {
					System.out.println(" Enter the no of cpoy  you yount chage to  ");
					//////////////////////////////
					test = s.next();
					int noOfCobay = Helper.CheckAndConvertgToInt(test); // to chack is num or not ant con vert to int
					if (bId == -1) {
						continue;
					}
					////////////////////////////
					itemsList.get(itemsList.indexOf(it)).setNoCopies(noOfCobay);
					System.out.println(" done ");
					ok = false;
					break;
				}
			}

			if (ok) {
				System.out.println(" if you want to break enter yes else (no or any thing ) ");
				if (s.next().equalsIgnoreCase("yes"))
					break;
			}
		}
	}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////helper////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void changeIdBookBrow(int idItem, int newId) {
		for (Student st : studentList) {
			for (ItemLibrary item : st.itemBrow) {
				if (item.getId() == idItem) {
					item.setId(newId);

				}
			}
		}

	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public boolean checksitemChangeTo(int idBo) {

		for (ItemLibrary ib : itemsList) {
			if (idBo == ib.getId()) {
				System.out.println(" the item is alredy in system  ");
				return true;
			}
		}
		System.out.println(" the item not  in system  ");
		return false;
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public ItemLibrary checksitemFound(int idBo) {

		for (ItemLibrary ib : itemsList) {
			if (idBo == ib.getId()) {
				System.out.println(" item  found  ");
				return ib;
			}
		}
		System.out.println(" item do not found  ");
		return null;

	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Student checksStudentFound(int idBo) {

		for (Student is : studentList) {
			if (idBo == is.getId()) {
				System.out.println(" student   found  ");
				return is;
			}
		}
		System.out.println(" student  not  found  ");

		return null;

	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////serch item///////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void SearchByNameOfItem() {

		System.out.println(" Enter the  book  name ");
		// s.nextLine();
///////////////////////////////////////// //to check correct name or not
		String bName = s.nextLine();
		if (!Helper.iSword(bName)) {
			System.out.println("this is not name we allow by (space ,#,alpha,_) and this item do not add");
			return;
		}
////////////////////////////////////////

		bName = bName.trim();
		boolean flag = true;

		System.out.println(
				" ================================================================================================================================================================================================================================================================================================================");
		System.out.println(
				"||////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////||");
		System.out.println(
				"||////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////||");
		System.out.println(
				" ===============================================================================================================================================================================================================================================================================================================");

		for (ItemLibrary it : itemsList) {
			if (it.getName().equalsIgnoreCase(bName)) {
				flag = false;
				System.out.println(" the book is found  ");
				System.out.println("");

				System.out.println(
						" ==============================================================================================================================================================================================================================================================");

				System.out.println(

						" || the name of book is : " + it.getName() + " *** " + "    the id of book is : " + it.getId()
								+ "***" + "    the author of book is :" + it.getAuthor() + "***"
								+ "    the  borw state of book is : " + it.isVaidBorw() + " *** "
								+ "    the  buy state of book is : " + it.isVaildBuy() + " *** "
								+ "    the  buy state of book is : " + it.getItemKind() + " *** "
								+ "    the noCopy of book is : " + it.getItemPrice() + " *** ||");

				System.out.println(
						" ==============================================================================================================================================================================================================================================================");
			}

		}

		if (flag)
			System.out.println(
					"          obs!!              no       item                by         this              name                                                                                                                                      !!!!!!!!!!!!!!!!!                ");
		System.out.println(
				" ================================================================================================================================================================================================================================================================================================================");
		System.out.println(
				"||////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////||");
		System.out.println(
				"||////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////||");
		System.out.println(
				" ===============================================================================================================================================================================================================================================================================================================");

	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void SearchByNameOfStudent() {

		System.out.println(" Enter the  Student  name ");
		// s.nextLine();
		/////////////////////////////////////////
		// to check correct name or not
		String sName = s.nextLine();
		if (!Helper.iSword(sName)) {
			System.out.println("this is not name we allow by (space ,alpha,_) and this item do not add");
			return;
		}

		////////////////////////////////////////
		sName = sName.trim(); ////// to delete all spacse
		boolean ok = true;

		System.out.println(
				"||===================================================================================================================================");
		System.out.println(
				"||/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////||");
		System.out.println(
				"||/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////||");
		System.out.println(
				"||===================================================================================================================================");
		System.out.println();
		System.out.println();

		for (Student st : studentList) {

			if (st.getName().equalsIgnoreCase(sName)) {
				ok = false;
				System.out.println(" the student is found  ");

				System.out.println(
						" ============================================================================================================");

				System.out.println(

						" || the name of student is : " + st.getName() + " *** " + "    the id of student is : "
								+ st.getId() + "***" + "    the num itrem of student is : " + st.getNum_TakenBook()
								+ " ||"

				);

				for (int i = 0; i < st.getItemBrow().size(); i++) {

					System.out.print("|| name item Taken  number" + "  ****  " + (i + 1) + " **** " + " "
							+ st.itemBrow.get(i).getName() + " *** ");
					System.out.print("||  kind item  number" + "  ****  " + (i + 1) + " **** " + " "
							+ st.itemBrow.get(i).getItemKind() + " *** ");
					System.out.println(" id item Taken  number " + "   **** " + (i + 1) + "  **** " + " "
							+ st.itemBrow.get(i).getId() + "                                        ||");

				}
				for (int i = 0; i < st.getDataBookTeaken().size(); i++) {
					System.out.println("||  data BookTaken number " + " **** " + (i + 1) + "****"
							+ st.dataBookTeaken.get(i) + "                                                         ||");

				}
				System.out.println(
						" =======================================================================================================================");

				System.out.println();
				System.out.println();
			}
		}
		if (ok)
			System.out.println(
					"             obs!!                      NO                   student               Found   in    this         name          ");

		System.out.println(
				"||===================================================================================================================================");
		System.out.println(
				"||/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////||");
		System.out.println(
				"||/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////||");
		System.out.println(
				"||===================================================================================================================================");

	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void viewAllItem() {
		System.out.println(
				" ====================================================================================================================================================================================================================================================================================================================================================");
		System.out.println(
				"||//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////||");
		System.out.println(
				"||/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////||");
		System.out.println(
				" ===================================================================================================================================================================================================================================================================================================================================================");

		System.out.println();
		System.out.println();
		System.out.println();
		boolean flag = true;
		for (ItemLibrary objectItemList : itemsList) {
			flag = false;
			objectItemList.showItem();

			System.out.println();
			System.out.println();
			System.out.println();
		}
		if (flag)
			System.out.println(
					"                Obs!!!                    no any       item                                                                                                                                                                                                                                           ");
		System.out.println(
				" =====================================================================================================================================================================================================================================================================================================================================");
		System.out.println(
				"||/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////||");
		System.out.println(
				"||/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////||");
		System.out.println(
				" =====================================================================================================================================================================================================================================================================================================================================");

	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public void viewAllStudent() {
		System.out.println(
				"====================================================================================================================================================");
		System.out.println(
				"||////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////||");
		System.out.println(
				"||////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////||");
		System.out.println(
				"====================================================================================================================================================");
		System.out.println();
		System.out.println();
		boolean flag = true;
		int cnt = 1;
		for (Student st : studentList) {
			flag = false;
			System.out.println("****************************************** student number  ==>{" + cnt
					+ " }  *************************************************************************************************");
			System.out.println(
					"////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");

			System.out.println(

					"|| the name of student is : " + st.getName() + "****" + "    the id of student is : " + st.getId()
							+ "****" + "    the num  of item student take  is : " + st.getNum_TakenBook() + "        ||"

			);

			for (int i = 0; i < st.getItemBrow().size(); i++) {

				System.out.print("|| name item Taken  number" + "  ===> { " + (i + 1) + " } is "
						+ st.itemBrow.get(i).getName() + " *** ");
				System.out.print("   kind item  " + "  ===>  " + "  is  " + st.itemBrow.get(i).getItemKind() + " *** ");
				System.out.println(
						" id item Taken   " + "  ===> " + "  is " + " " + st.itemBrow.get(i).getId() + "      ||");

			}
			for (int i = 0; i < st.getDataBookTeaken().size(); i++) {
				System.out.println("||  data BookTaken number " + " ===> {" + (i + 1) + "}  is "
						+ st.dataBookTeaken.get(i)
						+ "                                                                                   ||");

			}
			System.out.println(
					"////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
			System.out.println();
			System.out.println();
			System.out.println();

			cnt++;
		}
		if (flag)
			System.out.println(
					"            Obs!!!!!??                          no    any            Student                                                                     ");
		System.out.println(
				" ===================================================================================================================================================================");
		System.out.println(
				"||////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////||");
		System.out.println(
				"||////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////||");
		System.out.println(
				" ==================================================================================================================================================================");
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////habd////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////		

	public void ShowDidailsOne() {

		HashMap<String, ArrayList<String>> map1 = new HashMap<String, ArrayList<String>>();

		for (Student st : studentList) {

			if (st.itemBrow.size() > 0) {

				map1.put(st.getName(), st.dataBookTeaken);

			}

		}
		for (Student st : studentList) {
			if (st.itemBrow.size() > 0) {

				System.out.println(" student name is  " + st.getName() + " take item in  " + map1.get(st.getName()));

			}
		}
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public void WorkSpace() {
		int ItemId = 0;
		int day = 0, manth = 0, year = 0;
		int preiod = 0;
		try {
			System.out.println("enter the id of item  ");
			ItemId = s.nextInt();
		}

/////////////////////////////////////////
		catch (ArithmeticException e) {
			s.next();
			System.out.println(" you should inter num not alpha. ");

		} catch (IndexOutOfBoundsException e) {
			s.next();
			System.out.println(" you should inter num not alpha.! ");

		} catch (NullPointerException e) {
			s.next();
			System.out.println(" you should inter num not alpha.. ");

		} catch (Exception e) {
			s.next();
			System.out.println(" you should inter num not alpha.. ");

		}
////////////////////////////////////////

		System.out.println("       item id " + ItemId + " ************************************** ");
		System.out.println(
				"====================================================================================================================================================");
		System.out.println(
				"||////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////||");
		System.out.println(
				"||////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////||");
		System.out.println(
				"====================================================================================================================================================");
		System.out.println();
		System.out.println();

		boolean flag = true;

		for (Student st : studentList) {

			String Stname = st.getName();

			for (int i = 0; i < st.dataBookTeaken.size(); i++) {
				flag = false;

				if (st.itemBrow.get(i).getId() == ItemId) {

					String oldDate = st.dataBookTeaken.get(i);
					String itemName = st.itemBrow.get(i).getName();
					int itemId = st.itemBrow.get(i).getId();
					/////////////////////////////////////////////////

					try {
						///////////////////////////////////////////////////////
						day = Integer.parseInt(st.dataBookTeaken.get(i).substring(0, 2));
						manth = Integer.parseInt(st.dataBookTeaken.get(i).substring(3, 5));
						year = Integer.parseInt(st.dataBookTeaken.get(i).substring(6));

						preiod = Integer.parseInt(st.itemBrow.get(i).getFreePeirod());
					}
/////////////////////////////////////////////////
					catch (ArithmeticException e) {
						s.next();
						System.out.println(" you should inter num not alpha. ");
						continue;
					} catch (IndexOutOfBoundsException e) {
						s.next();
						System.out.println(" you should inter num not alpha.! ");
						continue;
					} catch (NullPointerException e) {
						s.next();
						System.out.println(" you should inter num not alpha.. ");
						continue;
					} catch (Exception e) {
						s.next();
						System.out.println(" you should inter num not alpha.. ");
						continue;
					}
/////////////////////////////////////////////////////
					day += preiod;

					if (day > 30) {
						day -= 30;
						manth++;
					}

					if (manth > 12) {
						manth -= 12;
						year++;

					}
					/////////////////////////////////////////////////////////////////
					String RetuDate = day + "/" + manth + "/" + year;

					////////////////////////////////////////////////// ============>1;

					System.out.println(
							"////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");

					System.out.println("||             take by studet " + Stname + " *****  " + " in date " + oldDate
							+ "                           || ");
					System.out.println("||             this item should be return in  " + RetuDate
							+ "                           ||");

					System.out.println(
							"////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
					System.out.println();
					System.out.println();

					////////////////////////////////////////////////////////////////////////////////////////////////////
					HashMap<Integer, String> map3 = new HashMap<Integer, String>();
					map3.put(itemId, RetuDate);

				}

			}

		}

		if (flag)
			System.out.println(
					"obs   !!!!!!!!!!!!   this       item     do    not    brow    by   any    student                        ");
		System.out.println(
				"====================================================================================================================================================");
		System.out.println(
				"||////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////||");
		System.out.println(
				"||////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////||");
		System.out.println(
				"====================================================================================================================================================");

	}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//========================================================================================================================================
//========================================================================================================================================
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}