package com.gfg.string;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
import java.net.*;


class Req{
    int page;
    int per_page;
    int total;
    int total_pages;
    List<Movie> data;
    
    public int getPage() {
        return page;
    }
    public void setPage(int year) {
        page = year;
    }
    public int getperPage() {
        return per_page;
    }
    public void setPerPage(int page) {
        per_page = page;
    }
    
    public int gettotal() {
        return total;
    }
    public void settotal(int tot) {
        total = tot;
    }
    public int gettotalPages() {
        return total_pages;
    }
    public void setTotalPage(int page) {
        total_pages = page;
    }
    public List<Movie> getData() {
        return data;
    }
    public void setData(List<Movie> page) {
        data = page;
    }
}

class Movie{
    String Title;
    int Year; 
    String imdbID;
    
    public String getTitle() {
        return Title;
    }
    public int getYear() {
        return Year;
    }
    public String getImdbID() {
        return imdbID;
    }
    public void setTitle(String title) {
        Title = title;
    }
    public void setYear(int year) {
        Year = year;
    }
    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }
}

class Solution {
    /*
     * Complete the function below.
     * Base url: https://jsonmock.hackerrank.com/api/movies/search/?Title=
     */

    static String[] getMovieTitles(String substr) {
        
        List<Movie> listMovie = getMovieList(substr);
        List<String> movieNameList = new ArrayList();
        for(Movie s: listMovie){
            movieNameList.add(s.getTitle());
        }
        Collections.sort(movieNameList);
        String[] arr = new String[movieNameList.size()];
        for(int i=0; i<movieNameList.size(); i++){
            arr[i] = movieNameList.get(i);
        }
        return arr;
    }
    
    static List<Movie> getMovieList(String substr){
        try{
            URL obj = new URL("https://jsonmock.hackerrank.com/api/movies/search/?Title=");
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println(response.toString());
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args) throws IOException{
        Scanner in = new Scanner(System.in);
        
        String _substr="spider";
        
        
        String[] res = getMovieTitles(_substr);
        
    }
}