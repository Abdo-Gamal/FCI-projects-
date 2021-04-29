#include "sortedType.h"
#include <iostream>
using namespace std;

void main()
{
	sortedType s;

	s.InsertItem('C');
	s.InsertItem('B');
	s.InsertItem('Z');
	bool b1;
	char c;
	c='B';
	s.RetrieveItem(c,b1);
	c='N';
	s.RetrieveItem(c,b1);
	s.DeleteItem('B');
	cout << s.LengthIs();




}