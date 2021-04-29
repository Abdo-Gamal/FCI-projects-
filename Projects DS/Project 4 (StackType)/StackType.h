#pragma once
#define MAX_ITEMS 50

class StackType
{
public:
	StackType(void);
	~StackType(void);
    void MakeEmpty( );
	bool IsEmpty( ) const;
	bool IsFull( ) const;
	void Push( char newItem );
	void Pop( char&  item );

private:
	int       top;
	char  items[MAX_ITEMS];	// array of ItemType

};

