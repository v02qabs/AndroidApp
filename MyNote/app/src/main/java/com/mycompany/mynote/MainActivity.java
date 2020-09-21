package com.mycompany.mynote;

import android.app.*;
import android.os.*;
import android.support.v7.app.*;
import android.widget.*;

public class MainActivity extends Activity 
{
	private Toolbar tbar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

		setContentView(R.layout.main);
		setActionBar((Toolbar)findViewById(R.id.tbar));
		
    }
}
