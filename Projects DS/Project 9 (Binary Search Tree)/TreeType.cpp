#include "TreeType.h"
#include <iostream>


TreeType::TreeType(void)
{
	root = NULL;
}

bool   TreeType::IsEmpty ( ) const
{
	return (root == NULL);
}

 bool   TreeType::IsFull ( ) const
 {

	 TreeNode* node =new TreeNode;
	 if(node==NULL)
		 return true ;
	 else
	 {
		 delete node;
		 return false;
	 }

 }

void    TreeType::InsertItem ( char  item )
 {
	 InsertItemHelper ( root,item );

  }

void    TreeType::InsertItemHelper ( TreeNode*&  ptr, char  item )
{
	if (ptr==NULL)
	{
		ptr = new TreeNode;
		ptr->left = NULL;
		ptr->right=NULL;
		ptr->info = item;

	}
	else  if ( item < ptr->info)
		InsertItemHelper ( ptr->left,  item );
	else
		InsertItemHelper ( ptr->right,  item );

}

 int       TreeType::NumberOfNodes ( ) const
  {

	  return NumberOfNodesHelper(root);

  }

 int    TreeType::NumberOfNodesHelper ( TreeNode*  ptr ) const
 {
	
	 if(ptr==NULL)
		 return 0;
	 else 
		 return  NumberOfNodesHelper(ptr->left)+NumberOfNodesHelper(ptr->right)+1;
	 
 }

 void    TreeType::RetrieveItem ( char& item,  bool& found )
 {
	 TreeNode* current = root; 
	
	 while (1)
	 {
		 if(current==NULL)  {found = false;return; }
		 else if(item > current->info)
			 current = current ->right;
	 	 else if(item < current->info)
			 current = current ->left;
		 else {found = true; return;}
	 }
 }


TreeType::~TreeType(void)
{
}
