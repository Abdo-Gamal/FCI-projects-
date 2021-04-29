#include<iostream>
using namespace std;
template<class itemtype>
//we will represent about each item in list by node such 
//info is value of item 
//next is pointer to next node(next item in list) 
struct node { 
	itemtype info;
	node<itemtype>* next;
};
template<class itemtype>
class list { 
private:
	node<itemtype>* start; //start is first element in list 
	node<itemtype>* curpos; //curpos is currently node
	int len; //length of list
public:
	list() //constructor to initialize 
	{
		len=0;
		start=NULL; //NULLmeaning list is empty until put item 
	} //litters of NULL must are capital
	////////////////////////////////////////////////////// 
	int lengthis()
	{return len;}
	////////////////////
	void makeempty() 
	{
		node<itemtype>*ptr;
		while(start!=NULL)
		{ 
			ptr=start;
			start=start->next; 
			delete ptr; //delete func use to delete node 
		} 
		len=0;
	} 
	//////////////////////////////////////////////////////
	bool isfull() 
	{ 
		try 
		{
			node<itemtype>*addloc=new node<itemtype>;
			delete addloc; 
			return false;
		} //catch meaning if no more space in memory to add new node return true so rarely if return true
		catch(bad_alloc exception) 
		{
			return true;
		} //read catch(ios::bad_alloc exception) if no #include<iostream> in program
	} 
	///////////////////////////////////////////////////////////////////////////////////////////// 
	void resetlist()
	{
		curpos=NULL;
	}
	//////////////////////
	void getnextitem(itemtype&item)
	{ 
		if(curpos==NULL) 
			curpos=start; 
		else curpos=curpos->nextp; 
		item=curpos->info;
	} 
	//////////////////////////////////////// 
	void insertitem(itemtype item)
	{ 
		node<itemtype>* location=new node<itemtype>; //to create node called location node<itemtype>* location;
		location=new node<itemtype>; //to create node called location
		location->info=item; 
		location->next=start; 
		start=location;
		len++;
	} 
	//////////////////////////////////////////////////////////////////// 
	void retriveitem(itemtype item,bool&found)
	{ 
		node<itemtype>*location=start; 
		found=false;
		for(int i=0;i<len;i++)
		{
			if(location->info==item) 
			{ 
				found=true;
				break;
			}
			else
				location=location->next;
		} 
	}
	//end fun
	///////////////////////////////////////////////////// 
	void display()
	{ 
		node<itemtype>* location=start;
		for(int i=0;i<len;i++)
		{ 
			cout<<location->info<<" "; 
			location=location->next;
		} 
	} 
	//////////////////////////////////
	void deleteitem(itemtype item)
	{ 
		node<itemtype>*location=start; 
		node<itemtype>*templocation=location;
		if(location->info==item)
		{
			
			start=location->next; 
			delete location;
			len--;
			return; 
		} 
		while(location!=NULL) 
		{ 
			if(location->info==item)
			{
				templocation->next=location->next;
				delete location;
				len--;
				return;
			} 
			templocation=location; 
			location=location->next;
		} //end while
	} //end fun
	//////////////////////////////////////////////////
	//ex1 determine if this element is in list or no
	bool isthere(itemtype item)
	{ 
		node<itemtype>*location=start; 
		while(location !=NULL)
		{ 
			if(location->info==item)
				return true; 
			else 
				location=location->next; 
		} //end while
		return false; 
	}//end fun 
	///////////////////////////////////////////////////////////
	//ex3 function split divide list into two lists according key 
	void split(list&l1,list&l2,itemtype item)
	{ 
		node<itemtype>*t=start; 
		while(t!=NULL)
		{ 
			if(t->info<=item)
				l1.insertitem(t->info);
			else
				l2.insertitem(t->info);
			t=t->next; 
		} 
	} 
	//////////////////////////////////////////////////
	//ex13 func head return last item insert into list 
	itemtype head(list&l1)
	{ 
		node<itemtype>*n=start; 
		itemtype x;
		if(l1.lengthis()!=NULL)
		{
			x=n->info;
		
			} 
		return x; 
	} 
	///////////////////////////////////////////////////////////////////////
	//ex14 func tail return new list with remove last item insert into list 
	void tail(list& t) 
	{ 
		t.makeempty();
		node<itemtype>*location=start->next; 
		//node<itemtype>*copylocation=new node<itemtype>; 
		 node<itemtype>*copylocation=location;
		while(location!=NULL) 
		{ 
			;
			t.insertitem(location->info); 
			location=location->next; 
		}
		
		
	} 
	//////////////////////////////////////////////////////
	//in sheet function copy make copy from list 
	void copyto(list&t) 
	{ 
		node<itemtype>*location=start;
		node<itemtype>*copylocation=location;
		//or node<itemtype>*copylocation=new node<itemtype>; 
		while(location!=NULL)
		{ 
			copylocation->info=location->info;
			t.insertitem(copylocation->info);
			location=location->next;
		} 
	} 
	//////////////////////////////////////////////////////////
	//in sheet function make ascending sort 
	void sort() 
	{ 
		node<itemtype>*location=start;
		while(location!=NULL) //first 
      {
				node<itemtype>*nextlocation=location; //new location 
				nextlocation=nextlocation->next;
				while(nextlocation!=NULL) //scond while 
				{
					if((location->info)>(nextlocation->info))
					{ 
						itemtype temp;
						temp=location->info;
						location->info=nextlocation->info;
						nextlocation->info=temp; 
					} 
					nextlocation=nextlocation->next;
				} //end second while 
				location=location->next;
			} //end first loop 
	
	}//end function
	//////////////////////////////////////////////////////////////////////////////////////////
 };