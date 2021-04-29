#include "UnsortedType.h"
#include<iostream>
using namespace std;




void main() { 
	list<double>l1;
	l1.insertitem(2.2);
	l1.insertitem(4.4);
	l1.insertitem(3.3);
	cout<<"the element of list after insert are:";
	l1.display();
	cout<<"\n-------------------------------------------------------------\n"; 
cout<<"after fun head :"<<l1.head(l1); 
cout<<"\n-------------------------------------------------------------\n";  
cout<<"length of list is:"<<l1.lengthis(); 
cout<<"\n-------------------------------------------------------------\n";  
cout<<"after use fun isthere 2.3 :"<<l1.isthere(2.3)<<endl; 
cout<<"after use fun isthere 4.4 :"<<l1.isthere(4.4); 
cout<<"\n-------------------------------------------------------------\n";  
if(l1.isfull())    //cout<<"list after isfull: "<<l1.isfull(); 
cout<<"the list is full\n"; 
else   cout<<"the list is not full\n";
cout<<"-------------------------------------------------------------\n";  
bool f;
l1.retriveitem(3.3,f); 
cout<<"retrive 3.3 is:"<<f<<"   "; 
l1.retriveitem(2,f);
cout<<"retrive 2 is:"<<f;
cout<<"\n-------------------------------------------------------------\n";  
cout<<"function after ascending sort is: "; 
l1.sort(); 
l1.display(); 
cout<<"\n-------------------------------------------------------------\n";  
cout<<"after split in 3.3 the element are :\n"; 
list<double> t;
list<double> t2;
l1.split(t,t2,3.3);
cout<<"first list :"; 
t.display(); 
cout<<"\nsecond list" ; 
t2.display(); 
cout<<"\n-------------------------------------------------------------\n";  
cout<<"function after copyto is: ";
list<double> t1;
l1.copyto(t1); 
t1.display();
cout<<"\n-------------------------------------------------------------\n";  
cout<<"l1 before use fun tail"<<endl;
l1.display();
cout<<endl<<"after use fun tail"<<endl;
l1.tail(t1);
t1.display(); 
cout<<"\n-------------------------------------------------------------\n";  
l1.deleteitem(2.2); 
cout<<"the element after delete 2.2 are: "; 
l1.display(); 
cout<<"\n-------------------------------------------------------------\n";  
l1.makeempty();
cout<<"the list after makeempty is:"<<l1.lengthis(); 
cout<<"\n-------------------------------------------------------------\n";
int n;
cin>>n;

} 