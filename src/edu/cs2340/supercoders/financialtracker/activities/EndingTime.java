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

public class EndingTime extends Activity {

	public static String end;
	
	public static String getEnd() {
		return end;
	}
	public static void setEnd(String input) {
		end = input;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ending_time);
		
		Button start = (Button) findViewById(R.id.nextButton2);
		start.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String endDate = ((EditText) findViewById(R.id.end))
						.getText().toString();
				EndingTime.setEnd(endDate);
				try {
				    boolean beforeOrNot = isBefore(StartingTime.getStart(), EndingTime.getEnd());
				    if (beforeOrNot) {
				        Intent loginIntent = new Intent(getApplicationContext(),
							ActualSpendingReport.class);
					startActivity(loginIntent);
				    } else {
				    	Toast incLogin = Toast.makeText(getApplicationContext(),
								"The start date is after the end date. Try again.",
								Toast.LENGTH_SHORT);
						incLogin.show();
						Intent loginIntent = new Intent(getApplicationContext(),
								StartingTime.class);
						startActivity(loginIntent);
				    }
				} catch(Exception E) {
					Toast incLogin = Toast.makeText(getApplicationContext(),
							"You entered an invalid date. Try again.",
							Toast.LENGTH_SHORT);
					incLogin.show();
					Intent loginIntent = new Intent(getApplicationContext(),
							StartingTime.class);
					startActivity(loginIntent);
				}
			}
		});
	}
	//private helper method to see if the startDate is before the endDate
	private boolean isBefore(String a, String b) {
		int startDay = Integer.parseInt(a.substring(0, 2));
		int startMonth = Integer.parseInt(a.substring(3, 5));
		int startYear = Integer.parseInt(a.substring(6, 10));
		int endDay = Integer.parseInt(b.substring(0, 2));
		int endMonth = Integer.parseInt(b.substring(3, 5));
		int endYear = Integer.parseInt(b.substring(6, 10));
		
		if (endYear >= startYear) {
			if (endYear == startYear) {
				if (endMonth >= startMonth) {
					if (endMonth == startMonth) {
						if (endDay >= startDay) {
							return true;
						} else {
							return false;
						}
					} else {
						return true;
					}
				} else {
					return false;
				}
			} else {
				return true;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ending_time, menu);
		return true;
	}

}
