package edu.cs2340.supercoders.financialtracker.activities;

import edu.cs2340.supercoders.financialtracker.R;
import edu.cs2340.supercoders.financialtracker.model.Transaction;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewTransaction extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_transaction);
		
		/*
		 * Setting up the button to create a new transaction. See my descriptions in
		 * Register and Welcome if you're confused.
		 */
		Button create = (Button) findViewById(R.id.newTransaction_create);
		
		create.setOnClickListener(new OnClickListener() {

			
			@Override
			public void onClick(View v) {
				String name = ((EditText) findViewById(R.id.newTransaction_transactionName)).getText().toString();
				String type = ((EditText) findViewById(R.id.newTransaction_transactionType))
						.getText().toString();
				try{
					double amount = Double.parseDouble(((EditText) findViewById(R.id.newTransaction_transactionAmount))
						.getText().toString());
					Transaction nTrans = new Transaction(name, amount, type);
					Welcome.getCurrAccount().addTrans(nTrans);
				} catch (Exception e){
					Toast error = Toast.makeText(getApplicationContext(), "Please enter a valid amount (a number)", Toast.LENGTH_SHORT);
					error.show();
				}

				NewTransaction.this.finish();
			}

		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.new_transaction, menu);
		return true;
	}
	
	public void onPause(){
		Welcome.save();
		super.onPause();
	}

}
