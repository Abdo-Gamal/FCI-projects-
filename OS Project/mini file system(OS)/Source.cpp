#include<unordered_map>
#include <iostream>
#include<iomanip>
#include <cmath>
#include <algorithm>
#include <string>
#include <vector>
#include<map>
#include< stdlib.h >
#include <sstream>
using namespace std;
map<string, string>mpMyCommand;
vector<string> splittedinput;
void myCommandSetingFunc() {//to build map for matching command with its discription
	//vector for command names
	vector<string>vecCommand = {"cd","cls","dir","help","quit",
		"copy","del","md","rd","rename","type","import","export"};

	//vector for command discription
	vector<string>vecCommandDiscaption = { "Change the current default directory toIf the argument is not present, report the current directory.  If the directory does not exist an appropriate error should be reported. "
		,"Clear the screen"
		,"List the contents of directory"
		,"Provides Help information for commands."
		," text file(s) to your computer"
		,"Quit the shell."
		,"Copies one or more files to another location"
		,"Deletes one or more files"
		,"Creates a directory."
		,"Removes a directory."
		,"Renames a file."
		,"Displays the contents of a text file."
		,"import text file(s) from your computer"
		,"export text file(s) to your computer"
	};

	for (int i = 0; i < vecCommand.size(); i++) {
		mpMyCommand[vecCommand[i]] = vecCommandDiscaption[i];
	}
	

}
bool checkCommands(string cmd) {//for splitting input as commands and arguments
	splittedinput.clear();
	stringstream ss(cmd);
	string word;
	while (ss >> word) {
		splittedinput.push_back( word );
	}
	// check whether this command is correct or not

	auto it = mpMyCommand.find(splittedinput[0]);
	if (it != mpMyCommand.end()) {
		return true;
	}
	return false;
}
void funcEcxcutionquit() {
	return ;

}
void funcEcxcutionCls() {//for clearing the screen
	system("cls");
}
void funcEcxcutionHelp() {//for command help to print all command discription
	for (auto it : mpMyCommand) {
		cout << (it.first) << "\n" << (it.second) << "\n\n";
	}
}
void funcEcxcutionHelp(string commandname) {//for command help to print a certain command discription
	auto it = mpMyCommand.find(commandname);
	if (it != mpMyCommand.end()) {
		cout << it->second << "\n";
	}
	else {
		cout << "COMMAND NOT FOUND\n";
	}
}
void funcEcxcutionCd(){}
void funcEcxcutiondir() {}
void funcEcxcutionCp() {}
void funcEcxcutiondel () {}
void funcEcxcutionmd() {}
void funcEcxcutionrd() {}
void funcEcxcutionrename() {}
void funcEcxcutiontype() {}
void funcEcxcutionimport() {}
void funcEcxcutionexport() {}
void typeOfCommands() {
	string command = splittedinput[0];
	 if (command == "cls") {
		 funcEcxcutionCls();
	 }
	 else if (command == "quit") {
		 funcEcxcutionquit();
	 }
	else if (command == "help") {
		 if (splittedinput.size() == 1) {

			 funcEcxcutionHelp();
		 }
		 else {
			 funcEcxcutionHelp(splittedinput[1]);
		 }
	}
	
	 else if (command == "cd") {
		 funcEcxcutionCd();
	}
	else if (command == "dir") {
		 funcEcxcutiondir();
	}

	else if (command == "copy") {
		 funcEcxcutionCp();
	}
	else if (command == "del") {
		 funcEcxcutiondel();
	}
	else if (command == "md") {
		 funcEcxcutionmd();
	}
	else if (command == "rd") {
		 funcEcxcutionrd();
	}
	else if (command == "rename") {
		 funcEcxcutionrename();
	}
	else if (command == "type") {
		 funcEcxcutiontype();
	}

	else if (command == "import") {
		 funcEcxcutionimport();
	}

	else if (command == "export") {
		 funcEcxcutionexport();
	}

}

int main() {

	ios_base::sync_with_stdio(0); cin.tie(0); cout.tie(0);


	myCommandSetingFunc();
	
	string cmd;
	int cnt = 4;
	do {
		
		cout << "H: \>";
		getline(cin, cmd);
		if (checkCommands(cmd))typeOfCommands();
		else cout << "command not found \n";

	} while (cnt--);
	
}