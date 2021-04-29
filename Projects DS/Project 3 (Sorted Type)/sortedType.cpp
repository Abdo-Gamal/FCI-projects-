#include "sortedType.h"


sortedType::sortedType(void)
{
	length=0;
}

void          sortedType::MakeEmpty ( )
{
	length=0;

}

bool	           sortedType::IsFull ( )  const
{
	return (length==MAX_ITEMS);

}

void          sortedType::RetrieveItem ( char&  item, bool&  found ) 
{
	int l,u,m;
	l=0;
	u=length-1;
	found=false;
	while(l<=u)
	{
	m=(l+u)/2;
	if(item < info[m]  )
		u=m-1;
	else if(item > info[m]  )
		l=m+1;
	else
		{
		found=true;
		break;
		}

	}

}
bool  sortedType::operator==(sortedType sortedList) const
{
	return (length == sortedList.length);

}

void  sortedType::InsertItem ( char  item )
{
	int i;
	for(i=0;i<length;i++)
		if(info[i] > item)
			break;

	for(int j=length;j>i;j--)
		info[j]=info[j-1];

	info[i]=item;
	length++;

}

void     sortedType::DeleteItem ( char  item ) 
{
	for(int i=0;i<length;i++)
		if(info[i]== item)
		{
			for(int j=i;j<(length-1);j++)
				info[j]=info[j+1];
				length--;
			break;
		}


}

void          sortedType::ResetList ( )
{
currentPos=-1;
}

void           sortedType::GetNextItem ( char&  item )
{
	currentPos++;
	item=info[currentPos];
}



int	          sortedType::LengthIs ( )  const
{
	return length;

}

sortedType::~sortedType(void)
{
}
