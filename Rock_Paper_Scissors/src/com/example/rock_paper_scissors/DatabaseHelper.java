package com.example.rock_paper_scissors;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

public class DatabaseHelper {
	
	
	private SQLiteDatabase database;

	public DatabaseHelper(SQLiteDatabase db) {
		database = db;
	}
	
	public Boolean createTable(SQLiteDatabase db){
		
		   db.beginTransaction();
			try {
			//perform your database operations here ...
				
				db.execSQL("create table users (" 
						+ "username text PRIMARY KEY, " 
						+ "wins integer, "
						+ "losses integer, "
						+ "sex text, "
						+ "age text ); " );
				

				db.setTransactionSuccessful(); //commit your changes
			}
			catch (SQLiteException e) {
			//report problem 
				Log.e("eee", "Error ---" + e);
				return false;
			}
			finally {
				
				db.endTransaction();
			}
			return true;
	}
	
	public Boolean AddPlayer(String username, String age, String sex){
		   database.beginTransaction();
			try {
			//perform your database operations here ...
				
				database.execSQL( "insert into users(username, wins, losses, sex, age) values ('"+username+"' , 0 , 0 ,'"+sex+"',  '"+age+"');" );

				

				database.setTransactionSuccessful(); //commit your changes
			}
			catch (SQLiteException e) {
			//report problem 
				Log.e("eee", "Error ---" + e);
				return false;
			}
			finally {
				
				database.endTransaction();
				
			}
		
		return true;
	
		
	}
	public Boolean incWin(String UserName, int CurrentWins){
		   database.beginTransaction();
					try {
					//perform your database operations here ...
						ContentValues values = new ContentValues();
						values.put("wins", CurrentWins);
						
						database.update("users", values	,  "username = '" + UserName + "'", null);
						database.setTransactionSuccessful(); //commit your changes
					}
					catch (SQLiteException e) {
					//report problem 
						Log.e("eee32", "Error ---" + e);
						return false;
					}
					finally {
						
						database.endTransaction();
						
					}
					return true;
					
	}
	
	public Boolean incLosses(String UserName, int CurrentLosses){
		   database.beginTransaction();
					try {
					//perform your database operations here ...
						ContentValues values = new ContentValues();
						values.put("losses", CurrentLosses);
						
						database.update("users", values	,  "username = '" + UserName + "'", null);
						database.setTransactionSuccessful(); //commit your changes
					}
					catch (SQLiteException e) {
					//report problem 
						Log.e("eee32", "Error ---" + e);
						return false;
					}
					finally {
						
						database.endTransaction();
						
					}
					return true;
					
	}
	
	public Integer getWins(String UserName){
		   database.beginTransaction();
					try {
					//perform your database operations here ...
						
						 Cursor c = database.rawQuery("SELECT wins FROM users WHERE username =  '"+UserName+"'", null);
						 c.moveToNext();
						 Integer winNum = c.getInt(c.getColumnIndex("wins"));
						 winNum++;
						 
						database.setTransactionSuccessful(); //commit your changes
						return winNum;
					}
					catch (SQLiteException e) {
					//report problem 
						Log.e("eee32", "Error ---" + e);
						
					}
					finally {
						
						database.endTransaction();
						
					}
					return null;
	}
	public Integer getLosses(String UserName){
		   database.beginTransaction();
					try {
					//perform your database operations here ...
						
						 Cursor c = database.rawQuery("SELECT losses FROM users WHERE username =  '"+UserName+"'", null);
						 c.moveToNext();
						 Integer lossNum = c.getInt(c.getColumnIndex("losses"));
						 lossNum++;
						 
						database.setTransactionSuccessful(); //commit your changes
						return lossNum;
					}
					catch (SQLiteException e) {
					//report problem 
						Log.e("eee32", "Error ---" + e);
						
					}
					finally {
						
						database.endTransaction();
						
					}
					return null;
	} 
	
}
