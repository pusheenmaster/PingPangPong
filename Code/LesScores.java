/*
 * LesScores.java
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
public class LesScores {
	private Score[] lesScores = new Score[5];
	
	public LesScores() {
		for(int i=0;i<lesScores.length;i++){
			lesScores[i]=null;
		}
	}
	
	public String toString(){
		String s="Les 5 meilleurs scores obtenus lors de cette session sont :" +"\n";
		int i=0;
		while(i<lesScores.length && lesScores[i]!=null){
			System.out.println(i);
			s=s+"  "+lesScores[i].getJoueur().getNom()+" : "+lesScores[i].getScore()+"\n";
			i++;
        }
        return s;
	}
	
	public void ajouterScore(Score s){
		Score current=lesScores[lesScores.length-1];
		if(lesScores[4]!=null && lesScores[4].getScore()<s.getScore()){
				lesScores[4]=s;
			}
		for(int i=lesScores.length-2;i>=0;i--){
			if(lesScores[i]!=null){
				if(lesScores[i].getScore()<s.getScore()){
					lesScores[i+1] = lesScores[i];
					lesScores[i]=s;
				}
			}else if(i!=0 && lesScores[i-1]!=null){
				lesScores[i]=s;
			}
		}
		if(lesScores[0]==null||lesScores[0].getScore()<s.getScore()){
			lesScores[0]=s;
		}
	}
}

