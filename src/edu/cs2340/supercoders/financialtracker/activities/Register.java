package edu.cs2340.supercoders.financialtracker.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import edu.cs2340.supercoders.financialtracker.R;
import edu.cs2340.supercoders.financialtracker.model.User;

/**
 * This is the activity that's set up for Registering a new user.
 */
public class Register extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);

		/*
		 * Here I'm setting up everything needed to register a new user.
		 * 
		 * Notice the TextViews don't give strings. I first get an EditText
		 * object, which I then call it's getText() (Still not strings,) and
		 * then finally toString(). Then I check the username to make sure
		 * it is available for registration.
		 * 
		 * Below that I create a new user, add it to our data, and then
		 * display a little message that says "You may now log in" (That's
		 * what the Toast object does.) Then I call the activities finish()
		 * method to take us back to Welcome
		 */
		Button register = (Button) findViewById(R.id.register_register_button);
		register.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String userName = ((EditText) findViewById(R.id.register_userName))
						.getText().toString();
				String password = ((EditText) findViewById(R.id.register_password))
						.getText().toString();
				String firstName = ((EditText) findViewById(R.id.register_firstName))
						.getText().toString();
				String lastName = ((EditText) findViewById(R.id.register_lastName))
						.getText().toString();
				boolean available = Welcome.getData().checkAvailability(
						userName);

				if (available) {
					User newUser = new User(userName, password, firstName,
							lastName);
					Welcome.getData().addNewUser(newUser);
					Toast success = Toast.makeText(getApplicationContext(),
							"You may now log in", Toast.LENGTH_SHORT);
					success.show();
					Register.this.finish();
				} else {
					Toast incLogin = Toast.makeText(getApplicationContext(),
							"That user name is not available",
							Toast.LENGTH_SHORT);
					incLogin.show();
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

}
