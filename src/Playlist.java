import java.util.Scanner;

/*Name: Daniel Williams
 * Date: 05/31/2018
 * 
 * 
 * UML
 * 
 * Playlist 
 * 
 * -playlistArray : Songs []
 * -name : String
 * -arrayCount : int
 * -option : char
 * 
 *+Playlist()
 *+Playlist (String n)
 *
 *  ADD/REMOVE SONGS
 *+addSongs() : void
 *+removeSongs() : void
 *
 *	PRINT BY VALUE
 *+printByTitle() : void
 *+printByArtist(): void
 *+printByGenre() : void
 *+printByReleaseYear() : void
 *
 *	GET ARTIST/GENRE COUNTERS
 *+getArtistCount(String artist) : int
 *+getGenreCount(String genre) : int
 *
 *	SORT SONGS BY VALUE
 *+sortByTitle(): void
 *+sortByArtist() : void
 *+sortByGenre() : void
 *+sortByReleaseYear() : void
 * 
 * 	GET/SET PLAYLIST NAME
 *+setName( String n) : void
 *+getName(void) : String
 *
 *	PRINT CURRENT PLAYLIST
 *+printPlaylist() : void
 *
 *	ADD SONGS TO PLAYLIST
 *+addToPlaylist( Song s)
 *
 * 
 * 
 * 
 * 
 * 
 */
public class Playlist {
	Scanner keyboard = new Scanner(System.in);
	public Songs [] playlistArray = new Songs [25];
//	private Random random = new Random();
	String name;
	private int arrayCount = 0;
	private char option;
	

	////////// Constructors /////////////
	/*
	 * This constructor contains the "preloaded" songs 
	 * into the default playlist
	 */
	public Playlist() {

	name = "Default Playlist";
		
	playlistArray [arrayCount] = new Songs("Vanilla Sky", "Pell", "Indie Rap", 2014);
		arrayCount++;
	playlistArray [arrayCount] = new Songs("In The Morning", "Pell", "Indie Rap", 2015);
		arrayCount++;
	playlistArray [arrayCount] = new Songs("Intro",  "The XX", "Ambient", 2013);
		arrayCount++;
	playlistArray [arrayCount] = new Songs("Nice For What", "Drake", "HipHop", 2018);
		arrayCount++;
	playlistArray [arrayCount] = new Songs("U", "Jaden Smith", "HipHop", 2017);
		arrayCount++;
	playlistArray [arrayCount] = new Songs("Ninety", "Jaden Smith", "HipHop",2017);
		arrayCount++;
	playlistArray [arrayCount] = new Songs("Look Alive", "Drake", "HipHop", 2018);
		arrayCount++;
	playlistArray [arrayCount] = new Songs("Wait On Me", "Pell", "Indie Rap", 2014);
		arrayCount++;
	playlistArray [arrayCount] = new Songs("Room 3", "36", "Ambient", 2015);
		arrayCount++;
	playlistArray [arrayCount] = new Songs("Nova", "36", "Ambient", 2013);
		arrayCount++;
	playlistArray [arrayCount] = new Songs("Donuts", "Mogwai", "Ambient", 2018);
		arrayCount++;
	playlistArray [arrayCount] = new Songs("All Star", "Smashmouth", "Alternative", 2003);
		arrayCount++;
	}
	
	public Playlist(String n){name = n;}
	
	
				///////// GET/SET NAME ////////////////
	public void setName(String n) {name = n;}
	public String getName() {return name;}

	

	///////////////// ADD SONGS ////////////////
	public void addSongs() throws Exception { 
		
		System.out.println("Enter 'A' to add a song (Q for Main Menu): " );
		option = keyboard.nextLine().toUpperCase().charAt(0);  
			
	while ( option == 'A')
	{
		if( arrayCount == playlistArray.length ) //// once array reaches max //////////
		{
			System.out.println("Sorry, your library is full");
		}
		else 
		{	
			playlistArray[arrayCount] = new Songs(); ///// create new song to add to array ///////////
			
			try 
			{		////// populate song objects ////////
				playlistArray[arrayCount].populateSong();
				
			} catch (Exception e) 
			{
				e.printStackTrace();
			}			
			arrayCount++;
			
			// clears buffer in scanner
			keyboard.reset();
					 			
			System.out.println("Enter 'A' to add another song (Q for Main Menu): " );
			option = keyboard.nextLine().toUpperCase().charAt(0);			
			}
		}	
    }
	
	
	
	
	////////////////// REMOVE SONGS ///////////
	public void removeSongs() throws Exception
	{
		int numChoice = 0;
		System.out.println("Enter the number of the song you want to remove. '99' to exit");
	
			for (int i =0; i <arrayCount; ++i) //// print out the songs/array, numbered /////////
			{
				System.out.println(i + " - " + playlistArray[i].getTitle()
						+ " (" + playlistArray[i].getArtist() + ")");
			}
			
				try 
				{
				numChoice = Integer.parseInt(keyboard.nextLine());
				} catch (NumberFormatException e)
				{
					System.out.println("Number Format Error");
					return;					
				}
				
					////// catch exceptions ///////////
			if (numChoice > arrayCount) 
			{
				throw new Exception ("Option cannot be greater than max number of songs");
			}
			if (numChoice < 0)
			{
				throw new Exception ("Option cannot be less than zero");
			}
			/*
				 set j to user's choice. user's choice (the index)
				is the index we wanna remove. this will loop
				 through until one less than the last index.
				 each loop copies the next index (j+1) to the right
				 and sets it to the index to the left, previous index
				arrayCount-- makes sure to accomodate the missing
				index and shortens the array
				*/
		while (numChoice != 99) {
				for (int j = numChoice; j < arrayCount-1; ++j)
				{
					playlistArray[j] = playlistArray[j +1];
				}
				arrayCount--;
		
					for (int i =0; i <arrayCount; ++i)
					{
						System.out.println(i + " - " + playlistArray[i].getTitle()
								+ " (" + playlistArray[i].getArtist() + ")");
					}
					System.out.println("Your song was deleted!");
		}
		System.out.println();		
	}
	
	
	
	
	/////////// print by artist/genre/releaseyeaar/title ///////////////////
	public void printByTitle()
	{
		for(int z = 0; z < arrayCount; z++)
		{
			playlistArray[z].printTitle();
		}
	}
	
	
	public void printByArtist()
	{
		for(int z = 0; z < arrayCount; z++)
		{	
			playlistArray[z].printArtist(); 
			System.out.print(" - ");
			int artistCount = this.getArtistCount(playlistArray[z].getArtist());/// loop and get artist
			System.out.println(artistCount);
			
			
			for (int i =z; i < z + artistCount; ++i) ///// loop and print each song for each artist
			{
				System.out.println(playlistArray[i].getTitle() + 
						" (" + playlistArray[i].getreleaseYear() + ")");
				
			}
			System.out.println();
			if (artistCount > 1)
			{
				z += artistCount -1; /// skips duplicate artist indexes
			}
		}
	}
	
	
	public void printByGenre()
	{
		for(int z = 0; z < arrayCount; z++)
		{	
			playlistArray[z].printGenre(); 
			System.out.print(" - ");
			int genreCount = this.getGenreCount(playlistArray[z].getGenre());/// loop and get genre
			System.out.println(genreCount + "songs");
			
			
			for (int i =z; i < z + genreCount; ++i) ///// loop and print each song for each genre
			{
				System.out.println(playlistArray[i].getArtist() + 
						" (" + playlistArray[i].getTitle() + ")");
				
			}
			System.out.println();
			if (genreCount > 1)
			{
				z += genreCount -1; /// skips duplicate artist indexes
			}
		}
	}
	
	
	public void printByReleaseYear()
	{
		for(int z = 0; z < arrayCount; z++)
		{
			playlistArray[z].printReleaseYear();
		}
	}	
	
	
	/////////////// GET THE ARTIST/GENRE COUNTERS //////////////////
	/*
	 * loops through array and compares each artist/genre
	 * if there is an artist/genre match, the counter increases by one
	 */
	public int getArtistCount(String artist)
	{
		int artistCount =0;
		for (int i =0; i < arrayCount; i++)
		{
			if(artist.compareTo(playlistArray[i].getArtist()) == 0)
			{				
				artistCount++;
			}
		}		
		return artistCount;
	}
	
	
	public int getGenreCount(String genre)
	{
		int genreCount =0;
		for (int i =0; i < arrayCount; i++)
		{
			if(genre.compareTo(playlistArray[i].getGenre()) == 0)
			{				
				genreCount++;
			}
		}		
		return genreCount;
	}
	
	
	
	///////////////////// SORTING METHODS //////////////
	/*
	 * loops through and sorts all songs by a certain song attribute
	 * 
	 */
	
	public void sortByArtist()
	{
		for( int j = 0; j < arrayCount; j++ )
		{ // Outer loop is the number of times we need to go through to sort it completely
			int minIndex = j; // Reset starting point
			String minValue = playlistArray[j].getArtist(); // And starting minimum value
		
			for( int k = j + 1; k < arrayCount; k++ )
			{ // Inner loop loops over every element left to be sorted in the playlistArray
				
				if( playlistArray[k].getArtist().compareTo(playlistArray[minIndex].getArtist()) < 0) // Flip sign to sort in descending order
				{ // If we found a new low value, save it off for now
					minValue = playlistArray[k].getArtist(); // both value for future comparison
					minIndex = k; // and index for swapping
				}
			}	
			
			 Songs temp = playlistArray[minIndex];
				playlistArray[minIndex] = playlistArray[j]; // Swap the starting point with low spot
				playlistArray[j] = temp;
		}		
	}
	
	
	public void sortByTitle() 
	{				/////////// selection sort from least to highest/////////
		for( int j = 0; j < arrayCount; j++ )
		{ // Outer loop is the number of times we need to go through to sort it completely
			int minIndex = j; // Reset starting point
			String minValue = playlistArray[j].getTitle(); // And starting minimum value
		
			for( int k = j + 1; k < arrayCount; k++ )
			{ // Inner loop loops over every element left to be sorted in the playlistArray
				
				if( playlistArray[k].getTitle().compareTo(playlistArray[minIndex].getTitle()) < 0) // Flip sign to sort in descending order
				{ // If we found a new low value, save it off for now
					minValue = playlistArray[k].getTitle(); // both value for future comparison
					minIndex = k; // and index for swapping
				}
			}	
			
			 Songs temp = playlistArray[minIndex];
				playlistArray[minIndex] = playlistArray[j]; // Swap the starting point with low spot
				playlistArray[j] = temp;
		}
		
	}
	
	
	public void sortByGenre() 
	{
		for( int j = 0; j < arrayCount; j++ )
		{ // Outer loop is the number of times we need to go through to sort it completely
			int minIndex = j; // Reset starting point
			String minValue = playlistArray[j].getGenre(); // And starting minimum value
		
			for( int k = j + 1; k < arrayCount; k++ )
			{ // Inner loop loops over every element left to be sorted in the playlistArray
				
				if( playlistArray[k].getGenre().compareTo(playlistArray[minIndex].getGenre()) < 0) // Flip sign to sort in descending order
				{ // If we found a new low value, save it off for now
					minValue = playlistArray[k].getGenre(); // both value for future comparison
					minIndex = k; // and index for swapping
				}
			}	
			
			 Songs temp = playlistArray[minIndex];
				playlistArray[minIndex] = playlistArray[j]; // Swap the starting point with low spot
				playlistArray[j] = temp;
		}
	}
	
	
	public void sortByReleaseYear() 
	{
		for( int j = 0; j < arrayCount; j++ )
		{ // Outer loop is the number of times we need to go through to sort it completely
			int minIndex = j; // Reset starting point
			Integer minValue = playlistArray[j].getreleaseYear(); // And starting minimum value
		
			for( int k = j + 1; k < arrayCount; k++ )
			{ // Inner loop loops over every element left to be sorted in the playlistArray
				
				if( playlistArray[k].getreleaseYear() < playlistArray[minIndex].getreleaseYear()) // Flip sign to sort in descending order
				{ // If we found a new low value, save it off for now
					minValue = playlistArray[k].getreleaseYear(); // both value for future comparison
					minIndex = k; // and index for swapping
				}
			}	
			
			 Songs temp = playlistArray[minIndex];
				playlistArray[minIndex] = playlistArray[j]; // Swap the starting point with low spot
				playlistArray[j] = temp;
		}
	
	}
	
	
	
	
	
	//////////// add songs to playlist ///////////////
	public void addToPlaylist (Songs s)
	{
		try 
		{
			if(arrayCount < playlistArray.length)
			{
				s.populateSong();
				playlistArray[arrayCount] = s;
			}
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
		arrayCount++;
	}
	
	
	
	public void printPlaylists()
	{
		System.out.println("Playlist Name: " + name);
		System.out.println();
		for (int i =0; i < arrayCount; ++i) 
		{
			playlistArray[i].printTitle();
		}
	}
}
