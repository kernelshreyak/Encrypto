//Symmetric key encryption tool in C++ using custom Polynomial-based algorithm
//Written by: Shreyak Chakraborty
//License: GNU GPLv3

#include <iostream>
#include <stdio.h>
#include <cstring>
#include <fstream>

using namespace std;

void copy(string file1,string file2)  //safely copies file contents
{
	ifstream fin;
	ofstream fout;

	fin.open(file1,ios::binary);
    fout.open(file2,ios::binary);

    char c;
    
    while(!fin.eof())
    {
    	fin.get(c);
    	if(fin.eof())
    		break;
    	fout.put(c);
    }

    fin.close();
    fout.close();
}


void encrypt(int key[],string filename)  //encrypts a file using a key and a filename
{
	ifstream f1;
	ofstream f2;

	f1.open(filename,ios::binary);
	f2.open("temp.txt",ios::binary);

	char c;
	int val,index=0;
	while(!f1.eof())
	{
		f1.get(c);
		if(f1.eof())
			break;
		val=0;

		//the encryption algorithm (developers are encouraged to change this)
		//for symmetric encryption,inverse of this should exist in decrpyt()
        for(int j=0;j<10;j++)
			val=val+key[j]*(j+2);  
		    //val=(val+key[j]*(j+2))/(index+1);
        c+=val;
		f2<<c;
		//++index;
	}

	f1.close(); f2.close();
	copy("temp.txt",filename);
	system("del temp.txt");
}



void decrypt(int key[],string filename)  //decrypts a file using a key and a filename
{
	ifstream f1;
	ofstream f2;

	f1.open(filename,ios::binary);
	f2.open("temp2.txt",ios::binary);

	char c;
	int val;
	while(!f1.eof())
	{
		f1.get(c);
		if(f1.eof())
			break;
	    val=0;
        for(int j=0;j<10;j++)
			val=val+key[j]*(j+2);    //the encryption algorithm
		c-=val;
		f2<<c;
	}

	f1.close(); f2.close();
	copy("temp2.txt",filename);
	system("del temp2.txt");
}









int main(int argc, char* argv[])
{
	int private_key[]={2,8,7,7,4,5,6,9,8,3};
	//int private_key[]={1,5,7,4,8,9,1,4,1,2};
	char kogul[10];

	if(strcmp(argv[1],"-e")==0){
		encrypt(private_key,argv[2]);
		printf("\n%s encrypted successfully...\n",argv[2]);
	}
	else if(strcmp(argv[1],"-d")==0){
		cout<<"\n\nEnter password:";
		gets(kogul);
		if(strcmp(kogul,"12345")==0)
		{
			decrypt(private_key,argv[2]);
			printf("\n%s decrypted successfully...\n",argv[2]);
		}
		else
			cout<<"Incorrect password!! Exitting...";	
	}
	else
		printf("\nInvalid parameter!!\n Correct syntax: encrypto -[e|d] <filename>");

	return 0;
}