
import java.util.Scanner;



/*
 * Name: Daniel Williams
 * Date: 05/31/18
 * 
 * UML
 * 
 * -allSongs[] : array
 * -allPlaylists[] : array
 * -playlistCount : int
 * -option : char
 * -name : String
 * 
 * +MyPod()
 * 
 * +mainMenu(): void
 * +viewAllSongs() : void
 * +viewPlaylists() : void
 * +createPlaylist() : void
 * 
 * 
 */

public class MyPod {
	Scanner keyboard = new Scanner(System.in);
	Playlist allSongs = new Playlist(); //TODO ----> move song functions to playlist class
	Playlist [] allPlaylists = new Playlist [5];
	private int playlistCount = 0;
	private char option;
	String name;
	
	public MyPod() {
		
		name = "New Playlist";
		
		allPlaylists[playlistCount] = new Playlist();
		playlistCount++;
	}
	
	//////////// MAIN MENU ///////////
	public void mainMenu() throws Exception 
	{ 
		char option = 'x'; //user option
		
//						///// MAIN MENU ///////////
		System.out.println("Welcome to MyPod");
		System.out.println("V – View All Songs\r\n" + 
				"A – Add Song\r\n" + 
				"R – Remove Song\r\n" + 
				"P – View Playlists\r\n" + 
				"C – Create New Playlist\r\n" + 
				"X – Exit\n");
						////// MENU SWITCH ////
			option = keyboard.nextLine().toUpperCase().charAt(0); /// get user option
			
		switch (option) 
        {
            case 'V': this.viewAllSongs();
            		  this.mainMenu();
                     break;
            case 'A':  allSongs.addSongs(); 
            		   this.mainMenu();
                     break;
            case 'R':  allSongs.removeSongs();
            		   this.mainMenu();
                     break;
            case 'P':  this.viewPlaylists();
            	 	   this.mainMenu();
                     break;
            case 'C':  this.createPlaylist();
            		   this.mainMenu();
                     break;
            case 'X':  mainMenu();
                     break;
          
            default: System.out.println("Invalid option. Try again.");
                     this.mainMenu();
                     break;                     
        }
	}	
	
	////////// VIEW ALL SONGS MENU ////////////////////
	public void viewAllSongs() throws Exception
	{
		//////////// VIEW ALL SONGS MENU SWITCH //////////////////
		char choice = 'x';
		System.out.println("How would you like to view your songs?");
		System.out.println("\"T – Sort by Title\n" + 
				"\"A – Sort by Artist (count per artist displayed)\n" + 
				"\"G – Sort by Genre (count per genre displayed)\n" + 
				"\"R – Sort by Release Year\n" +  
				"\"X – Exit\n");
		try
		{
		choice = keyboard.nextLine().toUpperCase().charAt(0);
		} catch (Exception e)
		{
			e.getMessage();
			return;
		}
		
		switch (choice) 
        {
            case 'T': allSongs.sortByTitle();
            		  allSongs.printByTitle();
            		  this.mainMenu();
                     break;
            case 'A':  allSongs.sortByArtist(); 
            		   allSongs.printByArtist();
            		   this.mainMenu();/// add songs
                     break;
            case 'G':  allSongs.sortByGenre();
            		   allSongs.printByGenre();
            		   this.mainMenu();
                     break;
            case 'R':  allSongs.sortByReleaseYear();
            		   allSongs.printByReleaseYear();
            	 	   this.mainMenu();
                     break;
            case 'X':  mainMenu();
                     break;
          
            default: System.out.println("Invalid option");
                     break;
        }
	}
	

	
	
	//////// VIEW PLAYLISTS //////////
	public void viewPlaylists()
	{
		if (playlistCount == 0)
		{						
			System.out.println("You have no playlists");
			System.out.println();
		}
		else
		{
			for (int i =0; i< playlistCount; ++i)
			{
				allPlaylists[i].printPlaylists();
			}
		}
	}
	
	
	//////////// CREATE PLAYLIST ///////////
	public void createPlaylist() throws Exception
	{
		String name = "Empty"; ///user choice for second menu
		
		try 
		{
		System.out.println("Enter 'C' to create a new playlist (Q for Main Menu): " );
		option = keyboard.nextLine().toUpperCase().charAt(0);  
		} catch (Exception e)
		{
			e.getMessage();
			e.printStackTrace();
		}
		System.out.println("Enter a name for your playlist: ");///// naming the playlist ///////////
		name = keyboard.nextLine();
					
		if ( option == 'C' && playlistCount < allPlaylists.length)
		{		
			allPlaylists[playlistCount] = new Playlist(name);
					
			while (option =='C') 
			{ 
				try 
				{
					allPlaylists[playlistCount].addToPlaylist(new Songs());
				} catch (Exception e) 
				{
					e.getMessage();
					e.printStackTrace();
				}	
				System.out.println("Enter 'C' to add another song (Q for Main Menu): " );
				option = keyboard.nextLine().toUpperCase().charAt(0);
				// clears buffer in scanner
				keyboard.reset();
			}			
			playlistCount++;
		}	
	}
	
	
	public static void main(String[] args) throws Exception 
	{ 		
		MyPod myPod = new MyPod();
		
		myPod.mainMenu();
	}	
}
