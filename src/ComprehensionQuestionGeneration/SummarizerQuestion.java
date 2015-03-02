package ComprehensionQuestionGeneration;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;

import Configuration.Configuration;


public class SummarizerQuestion {

	public static void generateSummarizerQuestion(String inputFilePath) {
		 
		try{
			 
			Process p = Runtime.getRuntime().exec("python "+Configuration.SUMMARIZER_PYTHON_SCRIPT_PATH+" "+inputFilePath);
			try{
			FileReader inputFile = new FileReader(Configuration.SUMMARIZER_OUTPUT_FILE_PATH);
			BufferedReader bufferReader = new BufferedReader(inputFile);
			 String line;
			  while ((line = bufferReader.readLine()) != null)   {
		            System.out.println(line);
		          }
			  bufferReader.close();
			}
			
			  catch(Exception e){
		          System.out.println("Error while reading file line by line:" + e.getMessage());                      
		       }
			
			}catch(Exception e){ System.out.println("Exception:"+e);}
	}
	public static void main(String[] args) {
		generateSummarizerQuestion("/home/vishnu/workspace/QuestionGeneration/input3.txt");
	}

}
