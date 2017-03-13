/*
 * Score.java
 * 
 * Copyright 2017 Unknown <edefoort@pc107-043-11>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */
public class Score {
	private Joueur joueur;
	private int score;
	
	public Score(Joueur j, int s) {
		joueur=j;
		score=s;
	}
	
	public int getScore(){
		return score;
	}
	
	public Joueur getJoueur(){
		return joueur;
	}
}

