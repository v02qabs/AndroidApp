package com.mycompany.mynote;

import java.lang.Runnable;
import android.widget.*;
import android.content.*;
import android.os.*;

public class MyRunnable extends Thread
{
	Context context;
	public MyRunnable(Context context)
	{
		this.context = context;
	}
	public void run()
	{

		Handler main = new Handler(Looper.getMainLooper());
		main.post(new Runnable()
		{
			@Override
			public void run()
			{
				
			}
		});
	}
}
