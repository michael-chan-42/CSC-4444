package csc4444.mike.dreamlink.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import csc4444.mike.dreamlink.R;
import csc4444.mike.dreamlink.adapters.DreamAdapter;

/**
 * Created by Mike on 10/1/15.
 */
public class DreamLog extends ActionBarActivity {

    @Bind(R.id.toolbar) Toolbar mainToolbar;

    //private ParseQueryAdapter<ParseObject> mainAdapter;
    private DreamAdapter dreamAdapter;
    private ListView listView;
    private String userName = "captaincrunch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dream_view);
        ButterKnife.bind(this);

        setSupportActionBar(mainToolbar);
        getSupportActionBar().setTitle("Your Dream Entries");

        dreamAdapter = new DreamAdapter(this, userName);
        //dreamFragment = new DreamFragment();
        //dreamFragment.setArguments(???);

        listView = (ListView) findViewById(R.id.dream_list);
        listView.setAdapter(dreamAdapter); //nothing shows when using this?
        dreamAdapter.loadObjects();

        //Get a instance off the app to pull the global username we are storing for this app user
        //DreamLink dreamLink = DreamLink.getInstance();

        //ParseQuery to pull all this user's dreams using the global username we pulled up there ^
        //ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("DREAM");
        //parseQuery.whereEqualTo("USER", userName);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //String item = parent.getItemAtPosition(position).toString();
                //Toast.makeText(DreamLog.this, "CLICK: "+item, Toast.LENGTH_SHORT).show();
                //below change RecordDream.class to whatever Dream Interpretation class that is made
                Intent intent = new Intent(DreamLog.this, RecordDream.class);
                startActivity(intent);
            }
        });
    }
}
