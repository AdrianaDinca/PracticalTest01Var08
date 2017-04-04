package ro.pub.cs.systems.eim.practicaltest01Var08;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var08SecundaryActivity extends AppCompatActivity {

    private EditText upleftEditText = null;
    private EditText uprightEditText = null;
    private EditText downleftEditText = null;
    private EditText downrightEditText = null;

    private Button sumButton = null;
    private Button prodButton = null;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch(view.getId()) {
                case R.id.sum_button:
                    setResult(RESULT_OK, null);
                    break;
                case R.id.prod_button:
                    setResult(RESULT_CANCELED, null);
                    break;
            }
            finish();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var08_secundary);

        sumButton = (Button) findViewById(R.id.sum_button);
        prodButton = (Button) findViewById(R.id.prod_button);


        upleftEditText = (EditText)findViewById(R.id.up_left_edit_text);
        uprightEditText = (EditText)findViewById(R.id.up_right_edit_text);

        downleftEditText = (EditText)findViewById(R.id.down_left_edit_text);
        downrightEditText = (EditText)findViewById(R.id.down_right_edit_text);

        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey("a")) {
            int numberOfClicks = intent.getIntExtra("a", -1);
            upleftEditText.setText(String.valueOf(numberOfClicks));
        }

        if (intent != null && intent.getExtras().containsKey("b")) {
            int numberOfClicks = intent.getIntExtra("b", -1);
            uprightEditText.setText(String.valueOf(numberOfClicks));
        }

        if (intent != null && intent.getExtras().containsKey("c")) {
            int numberOfClicks = intent.getIntExtra("c", -1);
            downleftEditText.setText(String.valueOf(numberOfClicks));
        }

        if (intent != null && intent.getExtras().containsKey("d")) {
            int numberOfClicks = intent.getIntExtra("d", -1);
            downrightEditText.setText(String.valueOf(numberOfClicks));
        }

        sumButton.setOnClickListener(buttonClickListener);
        prodButton.setOnClickListener(buttonClickListener);

        Log.d("ERR", String.valueOf(intent.getExtras().containsKey("d")));
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

}
