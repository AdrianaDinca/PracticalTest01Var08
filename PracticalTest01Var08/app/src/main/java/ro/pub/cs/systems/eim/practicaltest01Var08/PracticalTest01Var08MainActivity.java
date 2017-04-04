package ro.pub.cs.systems.eim.practicaltest01Var08;

import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var08MainActivity extends AppCompatActivity {

    private final static int SECONDARY_ACTIVITY_REQUEST_CODE = 1;
    private Button setButton = null;
    private EditText upleftEditText = null;
    private EditText uprightEditText = null;
    private EditText downleftEditText = null;
    private EditText downrightEditText = null;


    private int serviceStatus = Constants.SERVICE_STOPPED;


    private ButtonClickListener buttonClickListener = new ButtonClickListener();

        private class ButtonClickListener implements View.OnClickListener {
                @Override
                public void onClick(View view) {
                    switch (view.getId()) {
                        case R.id.set_button:
                            Intent intent = new Intent(getApplicationContext(), PracticalTest01Var08SecundaryActivity.class);
                            int numberOfClicks = Integer.parseInt(upleftEditText.getText().toString());
                            intent.putExtra("a", numberOfClicks);
                            numberOfClicks = Integer.parseInt(uprightEditText.getText().toString());
                            intent.putExtra("b", numberOfClicks);
                            numberOfClicks = Integer.parseInt(downleftEditText.getText().toString());
                            intent.putExtra("c", numberOfClicks);
                            numberOfClicks = Integer.parseInt(downrightEditText.getText().toString());
                            intent.putExtra("d", numberOfClicks);

                            startActivityForResult(intent, SECONDARY_ACTIVITY_REQUEST_CODE);
                            break;
                    }
                    int a = Integer.parseInt(upleftEditText.getText().toString());
                    int b = Integer.parseInt(uprightEditText.getText().toString());

                    int c = Integer.parseInt(downleftEditText.getText().toString());
                    int d = Integer.parseInt(downrightEditText.getText().toString());

                    if (serviceStatus == Constants.SERVICE_STOPPED) {
                        Intent intent = new Intent(getApplicationContext(), PracticalTest01Var08Service.class);
                        intent.putExtra("a", a);
                        intent.putExtra("b", b);
                        getApplicationContext().startService(intent);
                        serviceStatus = Constants.SERVICE_STARTED;
                    }

            }
        }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_main);

        setButton = (Button) findViewById(R.id.set_button);
        upleftEditText = (EditText)findViewById(R.id.up_left_edit_text);
        uprightEditText = (EditText)findViewById(R.id.up_right_edit_text);

        downleftEditText = (EditText)findViewById(R.id.down_left_edit_text);
        downrightEditText = (EditText)findViewById(R.id.down_right_edit_text);

        upleftEditText.setText(String.valueOf(0));
        uprightEditText.setText(String.valueOf(0));
        downleftEditText.setText(String.valueOf(0));
        downrightEditText.setText(String.valueOf(0));


        setButton.setOnClickListener(buttonClickListener);

        if (savedInstanceState != null) {
            if (savedInstanceState.containsKey("upleftCount")) {
                upleftEditText.setText(savedInstanceState.getString("upleftCount"));
            } else {
                upleftEditText.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("uprightCount")) {
                uprightEditText.setText(savedInstanceState.getString("uprightCount"));
            } else {
                uprightEditText.setText(String.valueOf(0));
            }

            if (savedInstanceState.containsKey("downleftCount")) {
                downleftEditText.setText(savedInstanceState.getString("downleftCount"));
            } else {
                downleftEditText.setText(String.valueOf(0));
            }
            if (savedInstanceState.containsKey("downrightCount")) {
                downrightEditText.setText(savedInstanceState.getString("downrightCount"));
            } else {
                downrightEditText.setText(String.valueOf(0));
            }

        } else {
            upleftEditText.setText(String.valueOf(0));
            uprightEditText.setText(String.valueOf(0));

            downleftEditText.setText(String.valueOf(0));
            downrightEditText.setText(String.valueOf(0));

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       // getMenuInflater().inflate(R.menu.practical_test01, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
      //  if (id == R.id.action_settings) {
    //        return true;
    //    }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + resultCode, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("upleftCount", upleftEditText.getText().toString());
        outState.putString("uprightCount", uprightEditText.getText().toString());

        outState.putString("downleftCount", downleftEditText.getText().toString());
        outState.putString("downrightCount", downrightEditText.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        if (savedInstanceState.containsKey("upleftCount")) {
            upleftEditText.setText(savedInstanceState.getString("upleftCount"));
        } else {
            upleftEditText.setText(String.valueOf(0));
        }

        if (savedInstanceState.containsKey("uprightCount")) {
            uprightEditText.setText(savedInstanceState.getString("uprightCount"));
        } else {
            uprightEditText.setText(String.valueOf(0));
        }

        if (savedInstanceState.containsKey("downleftCount")) {
            downleftEditText.setText(savedInstanceState.getString("downleftCount"));
        } else {
            downleftEditText.setText(String.valueOf(0));
        }
        if (savedInstanceState.containsKey("downrightCount")) {
            downrightEditText.setText(savedInstanceState.getString("downrightCount"));
        } else {
            downrightEditText.setText(String.valueOf(0));
        }
    }

    @Override
    protected void onDestroy() {
        Intent intent = new Intent(this, PracticalTest01Var08Service.class);
        stopService(intent);
        super.onDestroy();
    }
}
