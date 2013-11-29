package com.example.agendasimpus;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Build;
//import android.widget.Toast;

@SuppressLint("NewApi")
class MyTabsListener implements ActionBar.TabListener {
    public Fragment fragment;
    public Context mContexto;

    public MyTabsListener(Fragment fragment, Context context) {
	    this.fragment = fragment;
	    mContexto = context;
    }

    @Override
    public void onTabReselected(Tab tab, FragmentTransaction ft) {
//    	Toast.makeText(mContexto, "Seleccionado", Toast.LENGTH_SHORT).show();
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
    public void onTabSelected(Tab tab, FragmentTransaction ft) {
    	ft.replace(R.id.fragment_container, fragment);
    }

    @SuppressLint("NewApi")
	@Override
    public void onTabUnselected(Tab tab, FragmentTransaction ft) {
    	ft.remove(fragment);
    }

    }  