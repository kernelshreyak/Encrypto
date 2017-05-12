Encrypto is a simple file encryption tool using a highly customizable polynomial based encryption algorithm
,the key for which is implemented via an integer array. Currently only symmetric-key encryption is supported.

Encrypto supports almost all common file formats(that I have tested) and theoretically any file that allows read/write. If you find any problems, feel free to contact me (shreyak.rekshda@gmail.com)

Usage (command line):- 1.compile the C++ source file or directly use Java(JAR),Windows or Linux executable.
		       2.from the CLI, run encrypto -[e|d] <filename>  (for C++ and Windows/Linux executable)  
			   OR   java -jar encrypto.jar -[e|d] <filename> (for JAR file)
		       
		       3. '-e' option encrypts the file and '-d' option decrypts it
		       4. Currently, decryption is password protected (default password is 12345)


Note:-Keep a backup of the file before encrypting to be safe from any potential data loss.

IMPORTANT:- When using this in a production environment,change the key[] array for encryption/decryption (at the minimum)
            AND/OR modify the encrypt() and decryt() functions to include custom code (recommended).
	    



--------------------------------------------------------------------------------------------------------
RELEASE NOTES v1.1:
1. Added GUI for Windows.
2. Added support for browsing file to encrypt/decrypt


--------------------------------------------------------------------------------------------------------
RELEASE NOTES v1.0:
1. Added C++ and Java versions with command-line support (next release will include GUI for Windows)
