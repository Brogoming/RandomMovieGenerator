import java.io.*;

public class MovieList {
	
	public void ReadFile(String movies){
		try { //reading a file
			BufferedReader br = new BufferedReader(new FileReader(movies)); //path of the file we want to read
			String s;
			while((s = br.readLine()) != null) { //while each line read in the file isn’t null print out s
				System.out.println(s);
			}
			br.close();
		} catch(IOException e) {
			return;
		}

	}

}
