#include "unsorted.h"

void     unsorted::MakeEmpty ( ) 
{
	length=0;
}

bool	       unsorted::IsFull ( )  const 
{

	return (length==MAX_ITEMS);
}

int	          unsorted::LengthIs ( )  const 
{

	return length;
}

void           unsorted::InsertItem ( char  item ) 
{
	info[length++]=item;
}

void           unsorted::DeleteItem ( char  item ) 
{
	int i;
	for(i=0;i<length;i++)
	{
		if(info[i]==item)
		{
			 for(int j=i;j<(length-1);j++)
				info[j]=info[j+1];
			 length--;
			 break;
		}
	}




}

void  unsorted::ResetList ( )
{
	currentPos=-1;
}

void  unsorted::GetNextItem ( char&  item ) 
{
	item= info[++currentPos];
}

unsorted::unsorted()
{
	length=0;
}


unsorted::~unsorted(void)
{
}
