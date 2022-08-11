import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class MovieList {
	
	ArrayList <String> movies;
	String s;
	Random random;
	
	public MovieList() {
		this.movies = new ArrayList <String>();
		this.random = new Random();
		this.s = null;
	}
	
	public void ReadFile(String movieList){
		try { //reading a file
			BufferedReader br = new BufferedReader(new FileReader(movieList)); //path of the file we want to read
			while((s = br.readLine()) != null) { //while each line read in the file isn’t null save s
				movies.add(s);
			}
			br.close();
		} catch(IOException e) {
			return;
		}
	}
	
	public void RandomMovie() {
		int index = random.nextInt(movies.size());
		
		System.out.println(movies.get(index));
	}

}
