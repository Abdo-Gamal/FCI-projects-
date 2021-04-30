package Mypackage;

import java.util.ArrayList;
import java.util.Scanner;

public class INTERFACEOfproject {

	public static void main(String[] args) {

		LibraryAdimain ob_LibraryManger = new LibraryAdimain();
		Student ob_Student = new Student();
		Helper ob_ShowAdminTable = new Helper();
		    String test="";
                Scanner s = new Scanner(System.in);

		////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////start/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		int choose_Admain_or_Student = 0;
		boolean contine_in_opration = true;
		int choose_from_admin_opration=0;
		int choose_from_Student_opration=0;


				////////////////////////
				////////////////////////
				do {
					
					System.out.println(" if you want to go to Admin opration enter (1)  else enter (2) ");
				try {
					
				 choose_Admain_or_Student=s.nextInt();
				// test = s.next();
				//choose_Admain_or_Student = Helper.CheckAndConvertgToInt(test);
				//if (choose_Admain_or_Student == -1) {
				//	continue;
				//}
				////////////////////////
				///////////////////////////
				 }
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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////manger opration ///////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


				if (choose_Admain_or_Student == 1) {
				             Helper.Passward(); // password

					boolean con_in_Admain;

					do {
////////////////////////////////////////////////////////////////////////////////////////

						con_in_Admain = false;
						Helper.showTableOfAdmain(); /// call by class
////////////////////////////////////////////////////////////////////////////////////////						

						////////////////////////
						//////////////////////// //to void crach or to check is the num who will be
						//////////////////////// input

						////////////////////////
						try {
							
							test = s.next();
							choose_from_admin_opration = Helper.CheckAndConvertgToInt(test);
							if (choose_from_admin_opration == -1) {
								continue;
							}
							//choose_from_admin_opration=s.nextInt();
						}
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
						if (choose_from_admin_opration == 1) {

							ob_LibraryManger.addStudent();
							System.out.println(" if you want contine in Admine enter {yse} else any num or alpha  ");

							if (s.next().equalsIgnoreCase("yes"))
								con_in_Admain = true;

						}
						///////////////////////////////////////////
						if (choose_from_admin_opration == 2 || choose_from_admin_opration == 3
								|| choose_from_admin_opration == 4) {

							ob_LibraryManger.addItem(choose_from_admin_opration);
							System.out.println(" if you want contine in Admine enter {yse} else any num or alpha  ");

							if (s.next().equalsIgnoreCase("yes"))
								con_in_Admain = true;


						}

						///////////////////////////////////////////////////

						else if (choose_from_admin_opration == 5) {
							ob_LibraryManger.removeBook();

							System.out.println(" if you want contine in Admine enter {yse} else any num or alpha  ");

							if (s.next().equalsIgnoreCase("yes"))
								con_in_Admain = true;
						      break;

						}
						////////////////////////////////////
						else if (choose_from_admin_opration == 6) {
							ob_LibraryManger.removeStudent();
							System.out.println(" if you want contine in Admine enter {yse} else any num or alpha  ");
							if (s.next().equalsIgnoreCase("yes"))
								con_in_Admain = true;

						}
						//////////////////////////
						else if (choose_from_admin_opration == 7) {
							ob_LibraryManger.viewAllStudent();
							System.out.println(" if you want contine in Admine enter {yse} else any num or alpha  ");

							if (s.next().equalsIgnoreCase("yes"))
								con_in_Admain = true;

						}
						///////////////////////////////////
						else if (choose_from_admin_opration == 8) {
							ob_LibraryManger.viewAllItem();
							System.out.println(" if you want contine in Admine enter {yse} else (any num or alpha)  ");

							if (s.next().equalsIgnoreCase("yes"))
								con_in_Admain = true;
						    //  break;

						}
						/////////////////////////////////////////////
						else if (choose_from_admin_opration == 9) {
							ob_LibraryManger.ModifyItem();

							System.out.println(" if you want contine in Admine enter {yes} else any num or alpha  ");
							if (s.next().equalsIgnoreCase("yes"))
								con_in_Admain = true;
						    //  break;

						}
						/////////////////////////////
						else if (choose_from_admin_opration == 10) {
							ob_LibraryManger.modifyStudnt(ob_LibraryManger);
							System.out.println(" if you want contine in Admine enter {yse} else any num or alpha  ");

							if (s.next().equalsIgnoreCase("yes"))
								con_in_Admain = true;
						    //  break;

						}
						////////////////////////////////////////
						else if (choose_from_admin_opration == 11) {
							ob_LibraryManger.SearchByNameOfStudent();
							System.out.println(" if you want contine in Admine enter {yse} else any num or alpha  ");

							if (s.next().equalsIgnoreCase("yes"))
								con_in_Admain = true;
						     // break;

						}
						//////////////////////////////////////////////////
						else if (choose_from_admin_opration == 12) {
							ob_LibraryManger.SearchByNameOfItem();
							System.out.println(" if you want contine in Admine enter {yse} else any num or alpha  ");

							if (s.next().equalsIgnoreCase("yes"))
								con_in_Admain = true;
							     // break;
							
						}

						//////////////////////////////////
                  //////////////////////////////////////////////////
                         else if (choose_from_admin_opration == 13) {
                        	 ob_LibraryManger. WorkSpace();
	                    System.out.println(" if you want contine in Admine enter {yse} else any num or alpha  ");

	                      if (s.next().equalsIgnoreCase("yes"))
	                        	con_in_Admain = true;
					               //   break;

                             }

                           //////////////////////////////////
						 //////////////////////////////////////////////////
                         else if (choose_from_admin_opration == 14) {
                        	 
                        	 ob_LibraryManger.ShowDidailsOne();
	                    System.out.println(" if you want contine in Admine enter {yse} else any num or alpha  ");

	                      if (s.next().equalsIgnoreCase("yes"))
	                        	con_in_Admain = true;
					          //  break;

                             }

                           //////////////////////////////////

						else if (choose_from_admin_opration == 15) {
							System.out.println("  bay bay abody  I will miss you   ):   ...... me to (:   ");
							contine_in_opration = false;
							con_in_Admain = false;
							//break;
						}
						else 		System.out.println("  Wrong choose   ");


					} while (con_in_Admain || (choose_from_admin_opration > 13 || choose_from_admin_opration <= 0));

				}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////student opration ///////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

				else if (choose_Admain_or_Student == 2) {

					boolean con_in_Student;

					do {

						con_in_Student = false;
						Helper.showTableOfStudent(); //// call by class as static

						////////////////////////
						//////////////////////// //to void crach or to check is the num who will be
						//////////////////////// input

						////////////////////////
						///////////////////////////
	////////////////////////
							try {
								//test = s.next();
								//choose_from_Student_opration = Helper.CheckAndConvertgToInt(test);
								//if (choose_from_Student_opration == -1) {
								//	continue;
								//}
								choose_from_Student_opration=s.nextInt();
								
							}
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

						///////////////////////////////////////////// ////
						if (choose_from_Student_opration == 1) {
							ob_Student.issueItem(ob_LibraryManger);

							System.out.println(
									" if you want contine in Student enter {yes} else enter {no or any ather number  or alpha} ");
							if (s.next().equalsIgnoreCase("yes"))
								con_in_Student = true;
						     // break;

						}
						//////////////////////////////////////////////////////
						if (choose_from_Student_opration == 2) {
							ob_Student.returnItem(ob_LibraryManger);

							System.out.println(
									" if you want contine in Student enter {yes} else enter {no or any ather number  or alpha} ");
							if (s.next().equalsIgnoreCase("yes"))
								con_in_Student = true;
						     // break;

						}

						////////////////////////////////////////////////////////

						else if (choose_from_Student_opration == 3) {
							ob_Student.buyItem(ob_LibraryManger);
							System.out.println(
									" if you want contine in Student enter {yes} else enter {no or any ather number  or alpha} ");
							if (s.next().equalsIgnoreCase("yes"))
								con_in_Student = true;
						   //   break;

						}
						else 		System.out.println("  Wrong choose   ");


					} while (con_in_Student || (choose_from_Student_opration > 3 || choose_from_Student_opration <= 0));

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////end student opration and project bay bay java ////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

				}

		       

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//////////////////////////////////////////////////////////////end student and admin opration ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	

		} while ((choose_Admain_or_Student != 1 && choose_Admain_or_Student != 2) || contine_in_opration);
		        
		        
		
	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////////////////////////////////////////end///////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
