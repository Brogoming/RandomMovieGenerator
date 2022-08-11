
public class Main {

	public static void main(String[] args) {
		MovieList movieList = new MovieList();
		String horror = "C:\\Users\\kotag\\git\\RMG1\\RandomMovieGenerator\\src\\horrorMovies.txt";

		movieList.ReadFile(horror);
		movieList.RandomMovie();
	}

}
