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
import edu.cs2340.supercoders.financialtracker.model.Account;

public class CreateAccount extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_account);

		/*
		 * Setting up the button to create a new account. See my descriptions in
		 * Register and Welcome if you're confused.
		 */
		Button create = (Button) findViewById(R.id.createAcccount_createButton);
		create.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String name = ((EditText) findViewById(R.id.createAccount_accountName)).getText().toString();
				String type = ((EditText) findViewById(R.id.createAccount_accountType))
						.getText().toString();
				try{
					double balance = Double.parseDouble(((EditText) findViewById(R.id.createAccount_accountBalance))
						.getText().toString());
					
					Account newAccount = new Account(name, type, balance);
					Welcome.getData().getCurrent().addAccount(newAccount);
				} catch (Exception e){
					Toast error = Toast.makeText(getApplicationContext(), "Please enter a valid balance (A number)", Toast.LENGTH_SHORT);
					error.show();
				}

				CreateAccount.this.finish();
			}

		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_account, menu);
		return true;
	}

}
