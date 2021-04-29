#include "StackType.h"


StackType::StackType(void)
{
	top=-1;
}

void StackType::MakeEmpty( )
{
	top=-1;
}

bool StackType::IsEmpty( ) const
{
	return (top==-1);
}

bool StackType::IsFull( ) const
{

	return (top==(MAX_ITEMS-1));
}

void StackType::Push( char newItem )
{
	items[++top]=newItem;
}

void StackType::Pop( char&  item )
{
	item=items[top--];
}

StackType::~StackType(void)
{
}
