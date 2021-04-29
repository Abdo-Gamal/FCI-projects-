#include "QueType"
#include <iostream>
QueType::QueType(void)
{
	qFront = NULL;
	qRear = NULL;
}

QueType::~QueType(void)
{
	MakeEmpty();
}

void QueType::MakeEmpty()
{
	Node *tempPtr;
	while(qFront!=NULL)
	{
		tempPtr=qFront;
		qFront=qFront->next;
		delete tempPtr;
	}
	qRear=NULL;
}

bool QueType::IsFull() const
{
	try
	{
		Node* tempPtr=new Node;
		delete tempPtr;
		return false;
	}catch(bad_alloc)
	{
		return true;
	}
}

bool QueType::IsEmpty( ) const
{						
	return ( qFront == NULL )
}

void QueType::Enqueue(int item )
{
	Node*  ptr;
	ptr = new  Node;
	ptr->info = item;
	ptr->next = NULL;
	if  ( qRear == NULL )
		qFront = ptr;
	else
		qRear->next = ptr;
	qRear = ptr;
}

void QueType::Dequeue( int &item )
{	
	Node*  tempPtr;

	tempPtr = qFront;
	item = qFront->info;
	qFront = qFornt->next;
	if  ( qFront == NULL )
		qRear = NULL;
	delete  tempPtr;
}

