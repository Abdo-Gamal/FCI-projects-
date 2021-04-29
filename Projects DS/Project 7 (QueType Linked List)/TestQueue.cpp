#include "QueType"
void main()
{
	QueType Q;
	int x;
	Q.Enqueue(1);
	Q.Enqueue(2);
	Q.Enqueue(3);
	Q.Enqueue(4);
	Q.Enqueue(5);
	Q.Enqueue(6);
	while(!(Q.IsEmpty)
	{
		Q.Dequeue(x);
		cout<<x;
	}
}