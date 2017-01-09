package com.example.kimber.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;
import android.widget.LinearLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mLayout;
    private EditText mEditText;
    private Button mButton;
    private Button saveButton;
    private static final String KEY_DATA = "";
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mLayout = (LinearLayout) findViewById(R.id.linearLayout);
        mEditText = (EditText) findViewById(R.id.editText);
        mButton = (Button) findViewById(R.id.button);

        final SharedPreferences setting = getSharedPreferences(KEY_DATA, Context.MODE_PRIVATE);

        TextView textView = new TextView(this);
        String data = setting.getString(KEY_DATA,"");
        textView.setText(data);

        mButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mLayout.addView(createNewTextView(mEditText.getText().toString()));
                mEditText.setText("");
                setting
                        .edit()
                        .putString(KEY_DATA,mEditText.getText().toString())
                        .apply();
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /*private OnClickListener onClick() {
        return new OnClickListener() {

            @Override
            public void onClick(View v) {
                mLayout.addView(createNewTextView(mEditText.getText().toString()));
                mEditText.setText("");
                setting
                       .edit()
                        .putString(KEY_DATA,mEditText.getText().toString())
                        .apply();
            }
        };
    }*/


    public TextView createNewTextView(String text) {
        final LayoutParams lparams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(this);
        textView.setLayoutParams(lparams);
        textView.setTextSize(24);
        textView.setTextColor(0xffff0000);
        textView.setText(text);
        return textView;
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction2 = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.kimber.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction2);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction2 = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.kimber.myapplication/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction2);
        client.disconnect();
    }
}
