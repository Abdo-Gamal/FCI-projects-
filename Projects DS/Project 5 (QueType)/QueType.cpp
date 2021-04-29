#include "QueType.h"


QueType::QueType(void)
{
	maxQue=201;
	front = maxQue-1;
	rear =maxQue-1;
	items = new char[maxQue];
}

QueType::QueType( int max )
{
	maxQue=max+1;
	front = maxQue-1;
	rear =maxQue-1;
	items = new char[maxQue];

}
 void QueType::Enqueue( char item )
 {
	rear= (rear+1)%maxQue;
	items[rear]=item;
 }

 void QueType::Dequeue( char&  item )
 {
	 front= (front+1)%maxQue;
	 item=items[front];
 }

bool QueType::IsEmpty( ) const
{
return (front==rear);
}

 bool QueType::IsFull( ) const
 {
	 return ((rear+1)%maxQue)==front;
 }

  void QueType::MakeEmpty()
  {
	front = maxQue-1;
	rear =maxQue-1;
  }
QueType::~QueType(void)
{
delete [] items;
}
