#include "TreeType.h"
#include <iostream>

using namespace std;
void main()
{
TreeType t1;
char c;
bool f;
t1.InsertItem('J');
t1.InsertItem('E');
t1.InsertItem('F');
t1.InsertItem('T');
t1.InsertItem('A');
c='C';

t1.RetrieveItem(c,f);

}