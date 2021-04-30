package Mypackage;

import java.util.Scanner;



public class THE_INTERFACE {
	
	
	
	public static void main(String[] args) {
	
		
		
		LibraryMangerAndOpration ob_LibraryMangerAndOpration=new LibraryMangerAndOpration();
        ShowAdminTable ob_ShowAdminTable=new ShowAdminTable();
        ShowAdminTable ob_ShowStudentTable=new ShowAdminTable();
        
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Scanner s=new Scanner(System.in);
		   int choose_Admain_or_Student;
		    boolean   contine_in_opration=true;
		do {
			
			System.out.println(" if you want to go to Admin opration enter (1)  else enter (2) ");
             choose_Admain_or_Student=s.nextInt();
             
             
			if(choose_Admain_or_Student==1) {
				
				boolean con_in_Admain;
				
				do {
					
				 con_in_Admain=false;
				 ob_ShowAdminTable.showTableOfAdmain();
				int choose_from_admin_opration=s.nextInt();
			
			/////////////////////////////////////////////	
				if(choose_from_admin_opration==1) {
					
					ob_LibraryMangerAndOpration.addStudent();
			       System.out.println(" if you want contine in Admine enter (1) ");
                   if(s.nextInt()==1)con_in_Admain=true;
				}
		///////////////////////////////////////////
				if(choose_from_admin_opration==2||choose_from_admin_opration==3||choose_from_admin_opration==4) {
					System.out.println(" ********** ");
					ob_LibraryMangerAndOpration.addItem(choose_from_admin_opration);
					 System.out.println(" if you want contine in Admine enter (1) ");
                     if(s.nextInt()==1)con_in_Admain=true;
				}
          
         ///////////////////////////////////////////////////

                else if(choose_from_admin_opration==5) {
                	ob_LibraryMangerAndOpration.removeBook();
        
                	 System.out.println(" if you want contine in Admine enter (1) ");
                     if(s.nextInt()==1)con_in_Admain=true;
				}
			////////////////////////////////////
                 else if(choose_from_admin_opration==6) {
                	 ob_LibraryMangerAndOpration.removeStudent();
                	 System.out.println(" if you want contine in Admine enter (1) ");
                     if(s.nextInt()==1)con_in_Admain=true;
				}
             //////////////////////////
                 else if(choose_from_admin_opration==7) {
                	ob_LibraryMangerAndOpration.viewAllStudent();
                	 System.out.println(" if you want contine in Admine enter (1) ");
                     if(s.nextInt()==1)con_in_Admain=true;
 				}
             /////////////////////////////////
                 else if(choose_from_admin_opration==8) {
                	 ob_LibraryMangerAndOpration.viewAllbook();
                	 System.out.println(" if you want contine in Admine enter (1) ");
                     if(s.nextInt()==1)con_in_Admain=true;
 				}
              /////////////////////////////////////////////
                 else if(choose_from_admin_opration==9) {
                	 ob_LibraryMangerAndOpration.ModifyBook();;
                	 System.out.println(" if you want contine in Admine enter (1) ");
                     if(s.nextInt()==1)con_in_Admain=true;
 				}
              /////////////////////////////
                 else if(choose_from_admin_opration==10) {
                	 ob_LibraryMangerAndOpration.modifyStudnt();;
                	 System.out.println(" if you want contine in Admine enter (1) ");
                     if(s.nextInt()==1)con_in_Admain=true;
 				}
              
             //////////////////////////////////
                 else if(choose_from_admin_opration==11) {
                	 contine_in_opration=false;
                	 con_in_Admain=false;
                	// System.out.println(" if you want contine in Admine enter (1) ");
                    // if(s.nextInt()==1)con_in_Admain=true;
 				}
				
				}while(con_in_Admain);
				
				
				

				
			}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
               
               
		
		}while(   (choose_Admain_or_Student!=1&&choose_Admain_or_Student!=2)||contine_in_opration );
		
		
		
	
  }

}
