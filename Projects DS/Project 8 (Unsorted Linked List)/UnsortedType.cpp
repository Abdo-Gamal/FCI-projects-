#include "UnsortedType.h"
#include <iostream>
UnsortedType::UnsortedType(void)
{
	length=0;
	listData=NULL;
}

int UnsortedType::LengthIs( )const 
{
	return length;
}

bool	UnsortedType::IsFull ( )  const         
{
	NodeType* temp = new NodeType;
	if(temp==NULL)
		return true;
	else
	{
		delete temp;
		return false;
	}
	
}
void   UnsortedType::InsertItem ( char  item ) 
{
	NodeType* Location=new NodeType;
	Location->info=item;
	Location->next=listData;
	listData=Location;
	length++;
}
void UnsortedType::RetrieveItem ( char&  item, bool&  found ) 
{
	NodeType* Location=listData;
	found = false;
	int i;
	for(i=0;i<length;i++)
	{
		if(Location->info==item)
		{
			found=true;
			break;
		}
		else
			Location=Location->next;
	}
}

 void UnsortedType::ResetList ( )
 {
	 currentPos=listData;
 }

 void    UnsortedType::GetNextItem ( char&  item ) 
 {
	 item=currentPos->info;
	 currentPos=currentPos->next;

 }

void  UnsortedType::MakeEmpty ( ) 
{
	NodeType* temp;
	while(listData!=NULL )
	{
		temp=listData;
		listData=listData->next;
		delete temp;

	}
	length=0;
}
//this function to insert item  inthe sorted list not unsorted.
void    UnsortedType::InsertItem2 ( char  item )
{

	NodeType* location;
	NodeType* perLocation;
	NodeType* NewNode=new NodeType;
	NewNode->info=item;
	perLocation =NULL;
	location=listData;
	while(location!=NULL)
	{
		if(location->info >= item)
		{
			break;
		}
	perLocation=location;
	location=location->next;
	}

	if(perLocation==NULL)
	{
		NewNode->next = listData;
		listData = NewNode;
	}
	else
	{
		NewNode->next = location;
		perLocation->next=NewNode;
	}
	 length++;
}
void   UnsortedType::DeleteItem ( char  item ) 
{
	NodeType* location;
	NodeType* perLocation;
	perLocation =NULL;
	location=listData;
	bool found = false;
	while(location!=NULL)
	{
		if(location->info==item)
		{
			found=true;
	   		break;
		}
	perLocation=location;
	location=location->next;
	
	}

if(found)
{
	if(perLocation==NULL)
	{
		listData = listData->next;
	}
	else
	{
		perLocation->next=location->next;
	}
	delete location;  
	length--;
 }
}

UnsortedType::~UnsortedType(void)
{
	MakeEmpty ( );
}
