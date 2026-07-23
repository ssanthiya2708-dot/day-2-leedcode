public class Main
{
	public static void main(String[] args) {
	    String s="dhaanish chennai";
	    StringBuilder sb = new StringBuilder();
	    for(char c : s.toCharArray()){
	        if( c !='a' && c!='e' && c!='i' && c!='o' && c!='u'){
	            sb.append(c);
	        }
	    }
	    System.out.println("Input: " + s);
	    System.out.println("output: " + sb.toString());
		System.out.println("Hello World");
	}
}
