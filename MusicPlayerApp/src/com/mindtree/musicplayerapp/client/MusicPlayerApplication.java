package com.mindtree.musicplayerapp.client;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

import com.mindtree.musicplayerapp.entity.Playlist;
import com.mindtree.musicplayerapp.entity.Songs;
import com.mindtree.musicplayerapp.exception.service.ServiceException;
import com.mindtree.musicplayerapp.service.MusicPlayerService;
import com.mindtree.musicplayerapp.service.impl.MusicPlayerServiceImpl;

public class MusicPlayerApplication {
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		MusicPlayerService service = new MusicPlayerServiceImpl();
		do {

			System.out.println(
					"1:Add song\n2:Add Playlist\n3:GetAll songs\n4:Get Playlist name\n5:Given a playlist name sort\n6:File i/o\nExit");
			System.out.println("Enter the choice");
			int choice = scan.nextInt();
			Songs songs = new Songs();
			Playlist playlist = new Playlist();
			switch (choice) {
			case 1:
				songs = addSong();
				try {
					System.out.println(service.addSongs(songs));
				} catch (ServiceException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("Enter the songId");
				int songId = scan.nextInt();
				playlist = addPlaylist();
				try {
					System.out.println(service.addPlaylist(playlist, songId));
				} catch (ServiceException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				try {
					System.out.println(service.getAllSongs());
				} catch (ServiceException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 4:
				try {
					System.out.println(service.getAllPlaylist());
				} catch (ServiceException e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				System.out.println(service.sort());
				break;
			case 6:
				writeToFile(songs);
				break;
			}
		} while (true);
	}

	private static void writeToFile(Songs song) {
		 Reader fw = null;
		try {
			fw = new FileReader("output.txt");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
		 BufferedReader br=new BufferedReader(fw); 
		 boolean b;
		 try {
			while(b=fw.read()!=-1) {
				 System.out.println((b));
			 }
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static Playlist addPlaylist() {
		Playlist playlist = new Playlist();
		System.out.println("enter the playlist id");
		playlist.setPlaylistId(scan.nextInt());
		System.out.println("enter the playlist name");
		playlist.setPlaylistName(scan.next());
		return playlist;
	}

	private static Songs addSong() {
		Songs song = new Songs();
		System.out.println("Enter the song Id");
		song.setSongId(scan.nextInt());
		System.out.println("Enter the song name");
		song.setSongName(scan.next());
		System.out.println("Enter the rating");
		song.setRating(scan.nextDouble());
		return song;
	}

}
