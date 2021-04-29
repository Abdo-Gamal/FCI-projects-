#pragma once
struct Node
{
	int info;
	Node *next;
};
class QueType
{
public:
	QueType();
	~QueType();
	void MakeEmpty();
	bool IsFull() const;
	bool IsEmpty() const;
	void Enqueue(int item);
	void Dequueu(int &item);
private:
	Node *qFront;
	Node *qRear;
};