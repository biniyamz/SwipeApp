package com.example.root.swipeapp;
import android.app.Activity;
import android.os.Bundle;
import android.support.wearable.view.GridViewPager;

import com.example.root.swipeapp.JSONParser;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends Activity {
    private ArrayList<AlbumList> list= new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupData();
        setupGridViewPager();
    }

    private void setupData() {





        List<String> tracks = new ArrayList<>();
        tracks.add("My lIfe");
        tracks.add("Forver Reign");
        tracks.add("Stronger");
        AlbumList t= new AlbumList("United Album","Hilsong",R.drawable.hilsong,tracks);
        list.add(t);

        List<String> tracks2 = new ArrayList<>();
        tracks2.add("Redemtion");
        tracks2.add("Crazy BaldHead");
        tracks2.add(" Africa Unite");
        AlbumList t2= new AlbumList("RastaMan Vibration","Bob Marely",R.drawable.bobmarley,tracks2);
        list.add(t2);

        List<String> tracks3 = new ArrayList<>();
        tracks3.add("Make You Happy");
        tracks3.add("I Don't Know");
        tracks3.add("Fly");
        AlbumList t3= new AlbumList("Falling into You","Celine Dion",R.drawable.celinedion,tracks3);
        list.add(t3);
        /*

        try {




            ArrayList<AlbumList> list= new ArrayList<>();
            JSONObject jobj;
            JSONParser parser= new JSONParser();
            jobj=parser.loadJSONFromAsset("album.json",getApplicationContext());
            JSONArray jsonArray=jobj.getJSONArray("Albums");
            String Albumname;
            String  image;
            int[] images = {R.drawable.drax,R.drawable.gamora,R.drawable.groot};
            for(int i=0;i<jsonArray.length();i++){
                JSONObject obj=jsonArray.getJSONObject(i);
                Albumname= obj.getString("Albumname");
               // image= obj.getString("image");
                JSONObject songs= (JSONObject) obj.get("tracks");
                List<String> tracks = new ArrayList<String>();

                for(int j=0 ; j<songs.length(); j++){
                 tracks.add(songs.getString("track"));
                }
                //int imageLoc= Integer.parseInt(image);
                AlbumList t= new AlbumList(Albumname,images[i],tracks);
                list.add(t);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
*/


    }



    private void setupGridViewPager() {
        final GridViewPager pager = (GridViewPager) findViewById(R.id.pager);
        pager.setAdapter(new AlbumGridPagerAdapter(this, list, getFragmentManager()));
    }

    public static class AlbumList {
        private int mImageResource;
        private List<String> mQuotes;
        private String mName;
        private String artist;

        public AlbumList(String albumName,String artistName,int imageResource, List<String> songs) {
            mName = albumName;
            mImageResource = imageResource;
            mQuotes = songs;
            artist = artistName;
        }

        public String getTitle(int page) {
            // Only the first page has a title
            if (page == 0) {
                return mName;
            } else {
                return null;
            }
        }





        public String getText(int page) {
            // First has no text
            if (page == 0) {
                return artist;
            } else {
                return mQuotes.get(page - 1);
            }
        }

        public int getPageCount() {
            return mQuotes.size() + 1;
        }

        public int getImageResource() {
            return mImageResource;
        }
    }
}