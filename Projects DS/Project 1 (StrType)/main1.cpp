#include <fstream>
#include "StrType.h"
#include <iostream>
using namespace std;
const int MAX_WORDS = 10;
int main()
{
	StrType word;
	ifstream inFile;
	StrType words[MAX_WORDS];
	int numWords = 0;
	inFile.open("words.txt");
	word.MakeEmpty();
	word.GetStringFile(false, ALPHA_NUM, inFile);
	while (inFile && numWords < MAX_WORDS) {
		word.CopyString(words[numWords]);
		numWords++;
		word.GetStringFile(false, ALPHA_NUM, inFile);
	}
	if (inFile)
		cout << "First " << MAX_WORDS << " words on the file: ";
	else
		cout << " Words on the file: ";
	for (int index = 0; index < numWords; index++)
		words[index].PrintToScreen(true);
	system("pause");
	return 0;
}
