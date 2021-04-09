package resources;
import java.util.List; 

	public class Base {
	    
	    public void listToElement(List abc) {
	        String s=abc.toString();
	        String result=s.substring(2,s.length()-2);
	        String arr[]=result.split(",");
	        for(int i=0;i<6;i++) {
	            System.out.println(arr[i]);
	        }
	    }
	}
	 


