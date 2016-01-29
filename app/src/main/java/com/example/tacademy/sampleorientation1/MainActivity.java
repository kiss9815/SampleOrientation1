package com.example.tacademy.sampleorientation1;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.Surface;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView messageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        messageView = (TextView)findViewById(R.id.text_message);
        Button btn = (Button)findViewById(R.id.btn_change);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                messageView.setText("change text");
            }
        });

        Configuration config = getResources().getConfiguration();
        if(config.orientation ==Configuration.ORIENTATION_PORTRAIT ){  //onConfigurationChanged 를 설정하면 처음 액티비티가 실행될때만 onCreate 가 실행됨
            Toast.makeText(this, "onCreate.... Portrait", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(this, "onCreate.... Landscape", Toast.LENGTH_SHORT).show();
        }


        String[] rotateMessage = {"0", "90" , "180" , "270"};
        Display display = getWindowManager().getDefaultDisplay();    // display도 오리엔테이션 변경을 알 수 있다. 모든 방향에 대한 회전을 알 수 있음
        int rotate = display.getRotation();
        switch (rotate){
            case Surface.ROTATION_0:
            case Surface.ROTATION_90:
            case Surface.ROTATION_180:
            case Surface.ROTATION_270:
                Toast.makeText(this, "rotate : " + rotateMessage[rotate] , Toast.LENGTH_SHORT).show();
                break;
        }

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) { // 오리엔테이션이 변경되어도 액티비티가 다시 실행되지 않도록 메니페스트에서 설정을 하면
                                                                        // orientation이 변경될시 이 메소드가 호출됨
        super.onConfigurationChanged(newConfig);
        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "onConfigurationChanged.... Portrait", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "onConfigurationChanged.... Landscape", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
