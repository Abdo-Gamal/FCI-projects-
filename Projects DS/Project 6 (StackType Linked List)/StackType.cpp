#include "StackType.h"
#include <iostream>

StackType::StackType(void)
{
	topPtr=NULL;
}

bool StackType::IsEmpty( ) const
{
	return topPtr==NULL;
}

void StackType::Push( char item )
{
	NodeType* node=new NodeType;
	node->info=item;
	node->next=topPtr;
	topPtr=node;

}

void StackType::Pop( char&  item )
{
	NodeType* node;
	node=topPtr;
	topPtr=topPtr->next;
	item=node->info;
	delete node;

}

void StackType::MakeEmpty( )
{
	NodeType* node;
	
	while(topPtr != NULL) 
	{
		node=topPtr;
		topPtr=topPtr->next;
		delete node;
	}

}


bool StackType::IsFull( ) const
{
	NodeType* node=new NodeType;
	if (node==NULL)	return true;
	delete node;
	return false;
}

StackType::~StackType(void)
{
	MakeEmpty( );
}
