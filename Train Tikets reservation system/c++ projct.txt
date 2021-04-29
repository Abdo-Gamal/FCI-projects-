#include <iostream>
using namespace std;

struct seats {
	int id_seats;
	bool resrevation;

};
struct cars {
	int id_car;
	seats number[31];

};

int main() {
	int no_aval=0;
	cars car[11];
	int choose, number_tickt;
	int number_car, c = 0;
	int id_ca, id_sea;
	for (int i = 1; i <= 10; i++) {
		for (int j = 1; j <= 30; j++) {
			car[i].id_car = i;
			car[i].number[j].id_seats = j;
			car[i].number[j].resrevation = false;

		}
	}

	cout << "The departure station is Cairo. The train stops at the arrival station (Assuit) only\n";
	cout << "           ****************Train Tickets reservation system ********************\n";
	cout << "\t" << "_______________________________________________________________________\n";
	cout << "\t" << "|1-" << "\t" << "Reserve a ticket                                              |\n";
	cout << "\t" << "|2-" << "\t" << "Cancel the reservation                                        |\n";
	cout << "\t" << "|3-" << "\t" << "Check whether a specific car has available seat or not.       |\n";
	cout << "\t" << "|4-" << "\t" << "Check whether a specific seat is available or not             |\n";
	cout << "\t" << "|5-" << "\t" << "Get the number of the available seats in a specific car       |\n";
	cout << "\t" << "|6-" << "\t" << "Show all the seats status of a specific car                   |\n";
	cout << "\t" << "|7-" << "\t" << "Exit                                                          |\n";
	cout << "\t" << "|_____________________________________________________________________|\n";
	do {
		cout << "Please enter the number from the list (from 1 to 7) :=>  ";
		cin >> choose;
		 if(choose > 7)
			cout << " you shoud entre number from 1 to 7 only  \n";
		switch (choose)
		{
		case 1:
		{
		
		  cout << "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
		  cout << "please entre the numbers of the ticket(lese or equal "<< 300 - no_aval <<") you want to Reserve :==> ";
		  cout << " number of the available seat is : " << 300 - no_aval <<"\n";
		  cin >> number_tickt;

		  while (number_tickt > 300 - no_aval) {
			  if(no_aval==300){
				  cout << "the trean become complment\n";
				  break;
			  }
			  else {
				  cout << "you shoud entre number less or equal to " << 300 - no_aval << " as this is all seats of the trean \n";
				  cin >> number_tickt;
			  }
		  }
		  
			 for (int i = 1; i <= 10; i++) {
				 for (int j = 1; j <= 30; j++) {
					 if (number_tickt == 0)break;
					 else {
						 if (car[i].number[j].resrevation == false) {
							 car[i].number[j].resrevation = true;
							 number_tickt--;
							 cout << "                  The ticket            \n";
							 cout << " the car number : " << i << "        " << "your seat number is: " << j << "\n";
							 cout << "********************************************************************\n";
							 no_aval++;
						 }
						 
							
					 }
					
				 }

			 }
			 
		  
		  
		   break;
		 }


		 case 2:
		  {
			    cout << "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
		         cout << "please entre the number of the ticket (lese or equal : 300 and all seat reservation is : "<< no_aval<< " ) you want Cancel the reservation :==>";
		         cin >> number_tickt;
				// no_aval -= number_tickt;
				 while (number_tickt > 300) {
					 cout << " all the seat is 300  you shoud entre the number of the ticket lese or equal : 300 \n ";
					 cin >> number_tickt;
				 }
		       for (int i = 0; i < number_tickt; i++) {
			          cout << " please enter the car id ==> ";
			         cin >> id_ca;

					 while (id_ca > 10) {
						 cout << " you must entre the  id_car from 1 to 10  as ==>" << id_ca << " not found \n";
				      	 cin >> id_ca;
					 }
						 

			        cout << " please enter the id  of seat in the car you choose  ==> ";
			         cin >> id_sea;
					 while (id_sea > 30) {
						 cout << " you must entre the  id_seat from 1to 30 " << id_sea << " not found \n";
						 cin >> id_sea;
					 }

			        if (car[id_ca].number[id_sea].resrevation == false)
			     	cout << "***************** this seat is already not reservation****************************\n\n\n";

			      else
			      {
				         car[id_ca].number[id_sea].resrevation = false;
						 no_aval--;

				         cout << "*****************The cacel is seccessful****************************";

				        cout << "the car :" << id_ca << "  and the seat :" << id_sea << " become available\n\n\n\n";
			      }

		       }
		     break;

		 }
		  case 3:
		{   
			     cout << "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
		        cout << " please number of car(from 1 to 10) you want check if has a available seat or not  :==>  ";
		        cin >> number_car;

				while (number_car > 10) {
					cout << "Enter number_car of car you want check is a available or not from 1 to 10 only \n";

					cin >> number_car;
				}
				 {
					for (int i = 1; i <= number_car; i++) {
						c = 0;
						cout << "enter id_car you want check if has a available seat or not :==> ";
						cin >> id_ca;
		
						while (id_ca > 10) {
							cout << "Enter car_id of car you want check is a available or not from 1 to 10 \n";
							cin >> id_ca;
						}
						{
							for (int i = 1; i <= 30; i++)
							{
								if (car[id_ca].number[i].resrevation == false)
								{
									c++;
								}
							}
							if (c > 0)
								cout << "**************the car number : " << id_ca << " available and has  : " << c << " of seat available***********\n\n\n\n";
							else
								cout << "**************the car number : " << id_ca << "  not available and has : " << c << " of seat***********\n\n\n\n";
						}
					}
				}
		    break;
		}

		case 4:

	    {   
			
			  cout << "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
		         int number_seat;
		     cout << " please enter the number(less or equal 300 ) of seats you want check on them :==> ";
		     cin >> number_seat;
			 while (number_seat > 300) {
				 cout << "Enter number_seat of car you want check is a available or not from 1 to 300 only \n";

				 cin >> number_seat;
			 }
			 for (int i = 1; i <= number_seat; i++) {
				 cout << "Enter car_id of(from 1 to 10) car you want check is a available or not: ==> ";
				 cin >> id_ca;
				 while (id_ca > 10) {
					 cout << "Enter id_ca of car you want check is a available or not from 1 to 10 only \n";

					 cin >> id_ca;
				 }
				  {
					 cout << "Enter id_seat of seat you want check is a available or not :==> ";
					 cin >> id_sea;
					 while (id_sea > 30) {
						 cout << "Enter id_ca of car you want check is a available or not from 1 to 30 only \n";

						 cin >> id_sea;
					 }

					  if (car[id_ca].number[id_sea].resrevation == false)
						 cout << "************ the seat : "<< id_sea <<" in the car : " << id_ca << " is a available********* \n\n\n";

					 else
						 cout << "*************the seat :"<< id_sea <<" in the car :" << id_ca << "  is not available****************\n\n\n";

				 }
			 }
	 	     break;
	    }
		case 5:
		{
			 cout << "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
		    cout << "Enter The number of cars( less or equal 10) that wants to check if has available seat or not :==> ";
		    cin >> number_car;
			while (number_car > 10) {
				cout << "Enter number_car of car you want check is a available or not from 1 to 10 only \n";

				cin >> number_car;
			}
			
			{
				for (int i = 1; i <= number_car; i++)
				{
					c = 0;
					cout << "Enter car_id that you wants to check if has available seat or no:==> ";
					cin >> id_ca ;
					while (id_ca > 10) {
						cout << "Enter id_ca of car you want check is a available or not from 1 to 10 only \n";

						cin >> id_ca;
					}
					for (int i = 1; i <= 30; i++)
					{
						if (car[id_ca].number[i].resrevation == false)
							c++;
					}
					if (c > 0)
						cout << " **************The number of the avaliable seats of  car " << id_ca << " = " << c << "\n\n\n\n ";
					else
						cout << "******************* The car not has any seat avaliable *************\n\n\n\n ";

				}
			}
		  break;
		}
		 case 6:
		  {
			    cout << "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";
			    cout << "Enter The number of cars(from 1 to 10 ) that wants to check:==> ";
			     cin >> number_car;
				 while (number_car > 10) {

					 cout << "Enter car_number of car you want check is a available or not from 1 to 10 \n";
					 cin >> number_car;

				 }
				 {
					 for (int i = 1; i <= number_car; i++)
					 {

						 cout << "Enter car_id(from 1 to 10 ) wants to check if  :==> ";
						 cin >> id_ca;

						 while (id_ca > 10) {

							 cout << "Enter id_ca of car you want check is a available or not from 1 to 10 \n";
							 cin >> number_car;

						 }
						
						 {
							 cout << "********************************************************************************|\n";
							 for (int i = 1; i <= 30; i++)
							 {
								 if (car[id_ca].number[i].resrevation == false)
									 cout <<"|\t the car_id   ==>  " << id_ca << "   &&   seat ==> " << i << " ==>\t is avaliable        \t|\n";
								 else {

									 cout << "|\t the car_id   ==>  " << id_ca << "   &&   seat ==> " << i << " ==>\t is not avaliable \t|\n";
								 }
							 }

							 cout << "********************************************************************************|\n";

						 }
					 }
				 }
			 break;


		  }


		}
	} while (choose != 7);


   }
