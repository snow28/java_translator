
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class Translator_v_2 {
    
    

    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        BufferedReader dict = new BufferedReader(new FileReader("inputWords.txt"));
        BufferedReader translateMe = new BufferedReader(new FileReader("translateMe.txt"));
        ArrayList<String> inputList = new ArrayList<String>(); // we will use this list to store all lines of our dictionary
        ArrayList<String> eng = new ArrayList<String>();//eng words from our dictionary
        ArrayList<String> pol = new ArrayList<String>();//pln words from our dictionary
        ArrayList<String> inputWords = new ArrayList<String>();
        ArrayList<String> outputWords = new ArrayList<String>();
        
        int index = 0;
        try {
            StringBuilder sb = new StringBuilder();
            String line = dict.readLine();
            while (line != null) {     
                sb.append(line);
                sb.append(System.lineSeparator());
                line = dict.readLine();
                //System.out.println(line + "index  : " + line.length() );
                inputList.add(line);
            }
        } finally {
            dict.close();
        }
        
        int mode =0;
        for(int x=0; x < inputList.size(); x++){
            if( x < 20){
                pol.add(inputList.get(x));
            }else if(x>20){
                eng.add(inputList.get(x));
            }  
        }
    
  
        
        try {
            StringBuilder sb = new StringBuilder();
            String line = translateMe.readLine();
            while (line != null) {     
                sb.append(line);
                sb.append(System.lineSeparator());
                line = translateMe.readLine();
                //System.out.println(line);
                inputWords.add(line);     
            }
        } finally {
            translateMe.close();
        }
        
        
        /*for(int x=0; x < inputWords.size()-1; x++){
            //System.out.println(inputWords.get(x) +  " v  " + inputWords.get(x).length() );
            for(int z=0; z<eng.size();z++){
                if(inputWords.get(x).length() == eng.get(z).length()){
                    System.out.println("WOW");
                }
            }
        }*/
        
        PrintWriter writer = new PrintWriter("output.txt", "UTF-8");
        for(int x=0; x < inputWords.size()-1; x++){
            //System.out.println(inputWords.get(x) +  " v  " + inputWords.get(x).length() );
            for(int z=0; z<eng.size();z++){
                if(inputWords.get(x).equals(eng.get(z))){
                    System.out.println(inputWords.get(x) +  " = " + pol.get(z));
                    writer.println(inputWords.get(x) +  " = " + pol.get(z));
                }
            }
        }
        
        writer.close();
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
       
    }
    
}
