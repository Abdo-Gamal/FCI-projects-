#pragma once
struct NodeType  {
	char  info;
	NodeType* next;
};

class StackType
{
public:
	StackType(void);
	~StackType(void);
		void MakeEmpty( );
bool IsEmpty( ) const;
	bool IsFull( ) const;
void Push( char item );
void Pop( char&  item );
private:

	NodeType*  topPtr ;

};

