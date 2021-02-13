package com.practice.xml;

import java.util.ArrayList;
import java.util.List;

public class DVD {	
	private List<Movie> movies=new ArrayList<Movie>();	
	public DVD(){}
	public List getMovies() {
		return movies;
	}
	public void setMovies(List movies) {
		this.movies = movies;
	}	
	public String toString(){
		String movies="";
		/*for(Movie movie:movies){
			movies += movie.getName()+", ";
		}*/
		return movies; 
	}	
}
