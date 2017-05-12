//Symmetric key based file encryption tool in Java using custom Polynomial-based algorithm
//Written by: Shreyak Chakraborty

import java.io.*;

public class encrypto {
	/*void generate_key(int N){
		int[] key=new int[N];

		for(int i=0;i<N;i++)
	}*/


	void encrypt(int key[],String filename) throws IOException{
			FileInputStream fin=null;
			FileOutputStream fout=null;

			try{
			fin = new FileInputStream(filename);
			fout = new FileOutputStream("temp.txt");

		 	int c,val;
         	while ((c = fin.read()) != -1) {
         		val=0;

         		//the encryption algorithm (developers are encouraged to change this)
				//for symmetric encryption,inverse of this should exist in decrpyt()
         		for(int j=0;j<10;j++)
         			val=val+key[j]*(j+20);
         		c+=val;
            	fout.write(c);
            }
        }
        finally {
         if (fin != null) {
            fin.close();
         }
         if (fout != null) {
            fout.close();
         }
     }
     try{
			fin = new FileInputStream("temp.txt");
			fout = new FileOutputStream(filename);

		 	int c,val;
         	while ((c = fin.read()) != -1)
         		fout.write(c);
        }
        finally {
         if (fin != null) {
            fin.close();
         }
         if (fout != null) {
            fout.close();
         }

         try{
         	Process p=Runtime.getRuntime().exec("cmd /c"+"del temp.txt"); 
		 	p.waitFor();
         }
         catch(InterruptedException e){}
     }

		}

	void decrypt(int key[],String filename) throws IOException{
		FileInputStream fin=null;
			FileOutputStream fout=null;

			try{
			fin = new FileInputStream(filename);
			fout = new FileOutputStream("temp.txt");

		 	int c,val;
         	while ((c = fin.read()) != -1) {
         		val=0;
         		for(int j=0;j<10;j++)
         			val=val+key[j]*(j+20);
         		c-=val;
            	fout.write(c);
            }
        }
        finally {
         if (fin != null) {
            fin.close();
         }
         if (fout != null) {
            fout.close();
         }
     }
     try{
			fin = new FileInputStream("temp.txt");
			fout = new FileOutputStream(filename);

		 	int c,val;
         	while ((c = fin.read()) != -1)
         		fout.write(c);
        }
        finally {
         if (fin != null) {
            fin.close();
         }
         if (fout != null) {
            fout.close();
         }

         try{
         	Process p=Runtime.getRuntime().exec("cmd /c"+"del temp.txt");
		 	p.waitFor();
         }
         catch(InterruptedException e){}
     }

	}









	public static void main(String args[]) throws IOException{

		//int private_key[]={1,5,7,4,8,9,1,4,1,2};
		int private_key[]={2,8,7,7,4,5,6,9,8,3};

		encrypto enc = new encrypto();

		try{
			if(args[0].equals("-e"))
				enc.encrypt(private_key,args[1]);  //encrypt file using public key
			else if(args[0].equals("-d"))
				enc.decrypt(private_key,args[1]);  //decrypt the file
		}
		finally{
			if(args[0].equals("-e"))
				System.out.println("file encrypted successfully..");
			else if(args[0].equals("-d"))
				System.out.println("file decrypted successfully..");
			else
				System.out.println("Invalid parameter!!");
		}
				
	}
}