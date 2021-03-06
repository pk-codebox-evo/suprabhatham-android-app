package ceg.avtechlabs.sbm;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import ceg.avtechlabs.sbm.tracker.MixPanelUtil;


public class Lyrics extends ActionBarActivity {

   public final static String FILE_NAME="file";
    MixPanelUtil mixPanelUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyrics_options);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.actionBarColor)));
        setTitle("Choose Language");

        mixPanelUtil = MixPanelUtil.getInstance(this);
        //mixPanelUtil.trackEvent("Lyrics");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_lyrics, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showTamilLyrics(View v)
    {
        mixPanelUtil.trackEvent("Tamil Lyrics");
        Intent intent = new Intent(this,ViewLyrics.class);
        intent.putExtra(FILE_NAME,"tamil.txt");
        startActivity(intent);
    }

    public void showEnglishLyrics(View v)
    {
        mixPanelUtil.trackEvent("English Lyrics");
        Intent intent = new Intent(this,ViewLyrics.class);
        intent.putExtra(FILE_NAME,"english.txt");
        startActivity(intent);
    }

    public void showTeluguLyrics(View v)
    {
        mixPanelUtil.trackEvent("Telugu Lyrics");
        Intent intent = new Intent(this,ViewLyrics.class);
        intent.putExtra(FILE_NAME,"telugu.txt");
        startActivity(intent);
    }

    public void showKannadaLyrics(View v)
    {
        mixPanelUtil.trackEvent("Kannada Lyrics");
        Intent intent = new Intent(this,ViewLyrics.class);
        intent.putExtra(FILE_NAME,"kannada.txt");
        startActivity(intent);
    }
    
    public void showLyrics(String language){
       //generic function to load lyrics
    }


}

