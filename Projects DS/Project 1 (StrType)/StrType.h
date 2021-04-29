#pragma once
#include <fstream>
#include <iostream>
const int MAX_CHARS = 100;
enum InType {ALPHA_NUM, ALPHA, NON_WHITE, NOT_NEW};
class StrType
{
public:
	StrType(void);
	~StrType(void);
	void MakeEmpty();
//void GetString(bool skip, InType charsAllowed);
void GetStringFile(bool skip, InType charsAllowed,std::ifstream& inFile);

void PrintToScreen(bool newLine);
//void PrintToFile(bool newLine, std::ofstream& outFile);
int LengthIs();
void CopyString(StrType& newString);
private:
char letters[MAX_CHARS+1];

};




