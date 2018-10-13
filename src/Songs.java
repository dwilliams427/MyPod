import java.util.Scanner;

/* Name: Daniel Williams
 * Date: 05/31/2018
 * 
 * 
 * 
 * UML 
 
 * 
 * Songs
 * 
 * -title : String
 * -artist : String
 * -genre: String
 * -releaseYear : int
 * 
 * +Songs()
 * +Songs(String, String, String, int)
 * 
 * 		GETTERS/SETTERS
 * +setTitle(String t): void
 * +getTitle(void) : String
 * +setArtist(String a): void
 * +getArtist(void) : String
 * +setGenre(String g): void
 * +getGenre(void) : String
 * +setReleaseYear(int r): void
 * +getreleaseYear(void) : int
 * 
 * 	PRINT VALUES
 * +printTitle() : void
 * +printArtist() : void
 * +printGenre() : void
 * +printReleaseYear() : void
 * +printSongDetails(void) : String
 * 
 *
 * 
 * 
 * 
 */
public class Songs {
	private String title, artist, genre;
	private int releaseYear;
	Scanner keyboard = new Scanner(System.in);
	int count =0;
	
	public Songs() {
		
		title = "unknown";
		artist = "unknown";
		genre = "unknown";
		releaseYear = 0;
		
	}
	public Songs(String t, String a, String g, int r)
	{
		title = t;
		artist = a;
		genre = g;
		releaseYear = r;
	}
	//////////////// GETTERS/SETTERS /////////////
	public void setTitle(String t) {title = t;}
	public String getTitle() {return title;}
	public void printTitle() 
	{ 	System.out.println(getTitle() + " by " + getArtist() + " - " + getGenre() + " (" + getreleaseYear() + ")");
		System.out.println();
	}
	public void setArtist(String a) {artist = a;}
	public String getArtist() {return artist;}
	public void printArtist() 
	{ 	System.out.print(getArtist());
//		System.out.println();
	}
	public void setGenre(String g) {genre = g;}
	public String getGenre() {return genre;}
	public void printGenre() 
	{ 	System.out.println(getGenre());
//		System.out.println();
	}
	public void setreleaseYear(int r) {releaseYear = r;}
	public int getreleaseYear() {return releaseYear;}
	public void printReleaseYear() 
	{ 	System.out.println(getreleaseYear() + " - " + getTitle() + " by " + getArtist() + " (" + getGenre() + ")");
		System.out.println();
	}
	
	
	public void populateSong() throws Exception
	{
		do 
		{
			System.out.println("Enter a song title");
			title = keyboard.nextLine();
		} while (title.length() <= 0);
		
		do 
		{
			System.out.println("Enter an artist");
			artist = keyboard.nextLine();
		} while (artist.length() <= 0);//// ORRRR while(artist.isEmpty());
		
		do 
		{
			try
			{
			System.out.println("Enter genre type");
			genre = keyboard.nextLine();
			} catch (Exception e)
			{
				e.getMessage();
				System.out.println("Genre cannot be a number");
			}
		} while (title.length() <= 0);
		
		
		
		// acquire release year
		System.out.println("Enter release year");
		releaseYear = keyboard.nextInt();
		
			
		// check release year for errors
		if (releaseYear > 2018) 
		{
			throw new Exception("Invalid year. Can't be a future year" + releaseYear);
		}
		
		if (releaseYear <= 0 ) 
		{
			throw new Exception("Invalid year. Can't be a negative integer" + releaseYear);
		}
	}
	
	
	public void printSongDetails()
	{
		System.out.println("Title: " + title + ", " + "Artist: " + artist + ", " + 
							"Genre: " + genre + " Year: " + releaseYear);
		System.out.println();
	}
}
