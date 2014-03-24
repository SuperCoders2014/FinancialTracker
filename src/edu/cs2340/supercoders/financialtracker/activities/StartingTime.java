package edu.cs2340.supercoders.financialtracker.activities;



import edu.cs2340.supercoders.financialtracker.R;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StartingTime extends Activity {
	public static String start;
	
	public static String getStart() {
		return start;
	}
	public static void setStart(String input) {
		start = input;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_starting_time);
		
		Button start = (Button) findViewById(R.id.nextButton1);
		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String startDate = ((EditText) findViewById(R.id.start))
						.getText().toString();
				StartingTime.setStart(startDate);
				if (StartingTime.getStart() != "MM/DD/YYYY") {
				    Intent loginIntent = new Intent(getApplicationContext(),
							EndingTime.class);
					startActivity(loginIntent);
				} else {
					Toast incLogin = Toast.makeText(getApplicationContext(),
							"Please enter a start date.",
							Toast.LENGTH_SHORT);
					incLogin.show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.starting_time, menu);
		return true;
	}

}
