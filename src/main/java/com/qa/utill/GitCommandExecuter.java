package com.qa.utill;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;



public class GitCommandExecuter {
	
	static String  OPRATINGSYSTEM=System.getProperty("os.name");
	
	@SuppressWarnings("deprecation")
	public static void main(String []args ) throws IOException, InterruptedException
	{
		
	    if(OPRATINGSYSTEM.contains("Linux"))
	      {
	    	File directory=new File("/home/jaspal"); 
	    	directory.mkdir();
	    	File file=new File("/home/git.sh");
	    	file.createNewFile();
	    	String command="cd /home/"+directory+" \n";
	    	command+="git init \n";
	    	command+="git add . \n";
	    	java.util.Date date= new java.util.Date();
	    	Timestamp timestamp =new Timestamp(date.getTime());
	    	command+="git commit -m\" MESSAGE COMMIT\""+timestamp.toGMTString()+"\n";

	    	command +="git remote add origin URL \n";
	    	command+="git push origin master";

	    	BufferedWriter bw =new BufferedWriter(new FileWriter(file));
	    	bw.write(command);
	    	bw.close();
	    	Process p2=Runtime.getRuntime().exec("chmod +rwx "+file.getAbsolutePath());
	    	p2.destroy();
	    	ProcessBuilder processBuilder = new ProcessBuilder("./git.sh");
	    	processBuilder.directory(directory);
	    	//sets the working directory of process to this folder
	    	Process p=processBuilder.start(); 

	    	int x=p.waitFor();

	    	if(x==0)
	    	{

	    		System.out.println("successfull");

	    	}

		     
	      }
	   if(OPRATINGSYSTEM.contains("Windows"))
		      {  
		   System.out.println("\"hello");
            File directory=new File("D:\\jaspal"); 
	    	directory.mkdir();
	    	File file=new File("D:\\git.bat");
	    	file.createNewFile();
	    	String command="cd "+directory+" \n";
	    	command+="git init \n";
	    	
	    	command+="cd .>jas.txt \n";
	    	command+="git add . \n";
	    	java.util.Date date= new java.util.Date();
	    	Timestamp timestamp =new Timestamp(date.getTime());
	    	
	    	String commitMessage="first commit"+timestamp.toGMTString();
	    	command+="git commit -m"+"\""+commitMessage+"\""+"\n";

	    	command +="git remote add origin https://jaspal29:JAS0000pal@github.com/jaspal29/shy.git \n";
	    	command+="git push origin master";

	    	BufferedWriter bw =new BufferedWriter(new FileWriter(file));
	    	bw.write(command);
	    	bw.close();
	    	
	    	Process p =Runtime.getRuntime().exec("D:\\git.bat");
	    	
		    
			   
			  
			  int pi=p.waitFor();
			  if(pi==0)
			  {
				  System.out.println("mibhyhi");
			  }
		 
		   
		 
	      }
		
		
		
	
	
	
	
	
	
	}
	
	
	
	





}
