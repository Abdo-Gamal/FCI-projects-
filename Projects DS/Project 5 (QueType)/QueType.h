#pragma once
class QueType
{
public:
	QueType(void);
	~QueType(void);
	QueType( int max );
	
	void Enqueue( char item );
	void Dequeue( char&  item );
   bool IsEmpty( ) const; 
   bool IsFull( ) const; 
        void MakeEmpty();


private:
	int       front;
	int	      rear;
	int	      maxQue;  		
	char*  items;
};

