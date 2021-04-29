#pragma once
#define MAX_ITEMS 100
class sortedType
{
public:
	sortedType(void);
	~sortedType(void);
	void          MakeEmpty ( ) ;
	bool	         IsFull ( )  const ;              
	int	         LengthIs ( )  const ;                // returns length of list
	void          RetrieveItem ( char&  item, bool&  found ) ;
	void          InsertItem ( char  item ) ; 	
	void          DeleteItem ( char  item ) ; 	
	void          ResetList ( );
	void          GetNextItem ( char&  item ) ; 
	bool operator==(sortedType sortedList) const;


private :				//  3 private data members

	int 		length ;           
	char	info[MAX_ITEMS] ;          
	int		currentPos ;

};

