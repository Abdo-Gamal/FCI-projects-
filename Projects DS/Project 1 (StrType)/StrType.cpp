#include "StrType.h"
using namespace std;

StrType::StrType(void)
{
}

void StrType::MakeEmpty(void)
{
	letters[0]=0;
}

void StrType::GetStringFile(bool skip, InType charsAllowed,std::ifstream& inFile)
{
	char c;
	int counter;
	switch(charsAllowed)
	{
	case ALPHA_NUM:
		inFile.get(c);
		counter=0;
		while(isalnum(c) && (counter<=MAX_CHARS) && inFile )
		{
			letters[counter++]=c;
			inFile.get(c);
		}
		letters[counter]=0;
		break;

	}

}

void StrType::PrintToScreen(bool newLine)
{
	if(newLine)
		cout<<endl;
	cout<<letters;

}

int StrType::LengthIs()
{
	int counter=0;
	while(letters[counter]!=0)
	{
		counter++;
	}
return counter;

}

void StrType::CopyString(StrType& newString)
{
	int counter=0;
	while(letters[counter]!=0)
	{
		newString.letters[counter]=letters[counter];
		counter++;
	}
	
	newString.letters[counter]=0;

}
StrType::~StrType(void)
{
}
