#pragma once

struct   TreeNode  {   

    char     info;   		  // Data member
    TreeNode*  left;     // Pointer to left child 
    TreeNode*  right;   // Pointer to right child

};
class TreeType
{
public:
	TreeType(void);
	~TreeType(void);
	bool   IsEmpty ( ) const;  
    bool   IsFull ( ) const;
    int      NumberOfNodes ( ) const; 
    void   InsertItem ( char  item );	
	
    //void   DeleteItem (char  item );		    	
    void   RetrieveItem ( char& item,  bool& found ); 
    //void   PrintTree ()  const;
   
private:
		
	void   InsertItemHelper ( TreeNode*&  ptr, char  item );	
		int    NumberOfNodesHelper ( TreeNode*  ptr ) const; 
    TreeNode*  root;
};

