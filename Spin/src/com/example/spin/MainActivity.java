package com.example.spin;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {

	List<String> li;
	AutoCompleteTextView auto;
	 Spinner sp;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        li=new ArrayList<String>();
        li.add("Item 1");
        li.add("Item 2");
        li.add("Item 3");
        
        auto=(AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        Button b1=(Button) findViewById(R.id.button1);
        sp=(Spinner)findViewById(R.id.spinner1);
       
        add();
        
        b1.setOnClickListener(new View.OnClickListener() {
			
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
				
			li.add(auto.getText().toString());
			auto.setText(null);
			
			add();
			
			Toast.makeText(getBaseContext(), "Item Added",
				Toast.LENGTH_SHORT).show();
		}
	});
        auto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View arg0) {
         	   auto.showDropDown();
            }
        });
    }
 
   private void add() {
	// TODO Auto-generated method stub
    	
	ArrayAdapter<String> adp=new ArrayAdapter<String>(this,
		android.R.layout.simple_dropdown_item_1line,li);
	    	
	adp.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
	auto.setThreshold(1);
	auto.setAdapter(adp);
	sp.setAdapter(adp);
	
    }
   

}
