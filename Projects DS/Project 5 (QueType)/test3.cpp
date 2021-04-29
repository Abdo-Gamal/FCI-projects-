#include "QueType.h"
#include "StackType.h"
#include <iostream>

using namespace std;

void main()
{
 QueType  q1;
 char c='c';
 q1.Enqueue('a');
 q1.Enqueue('b');
 q1.Enqueue('c');
 q1.Dequeue(c);
 cout << c <<endl;
 cout << q1.IsEmpty()<<endl;

  q1.Dequeue(c);
 cout << c <<endl;
 cout << q1.IsEmpty()<<endl;

  q1.Dequeue(c);
 cout << c <<endl;
 cout << q1.IsEmpty()<<endl;

  q1.Dequeue(c);
 cout << c <<endl;
 cout << q1.IsEmpty()<<endl;

 StackType s;
 s.Push('d');
 s.Push('h');
 s.Pop(c);
 s.Pop(c);
 s.Pop(c);

}