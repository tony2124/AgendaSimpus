package com.example.agendasimpus;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat.OnActionExpandListener;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.SearchView.OnQueryTextListener;

public class Agenda_Simpus extends Activity implements OnActionExpandListener, OnQueryTextListener{
	
	public ActionBar actionbar;
	@Override  
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_agenda__simpus);
		 
		actionbar = getActionBar();
		actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		actionbar.setTitle("Simpus");
		actionbar.setSubtitle("Agenda");
		actionbar.setIcon(R.drawable.ic_launcher);
		actionbar.setDisplayHomeAsUpEnabled(true);
		
		 /*Tab tab = actionbar.newTab()
                 .setText("Contactos")
                 .setTabListener(new TabListener(this, "Contactos", Prueba.class));*/
		
		//Se crean los tabs
		ActionBar.Tab ContactosTab = actionbar.newTab().setText("Contactos");
		ActionBar.Tab EventosTab = actionbar.newTab().setText("Eventos");
		
		//Se crean los fragmentos par mostrar informacion en los tabs
		Fragment fragmentoContactos = new Contactos(actionbar,this); 
		Fragment fragmentoEventos = new Eventos();
		
		//Se les da un listener a los tabs por una clase
		ContactosTab.setTabListener(new MyTabsListener(fragmentoContactos,this));
		EventosTab.setTabListener(new MyTabsListener(fragmentoEventos, this));
		
		actionbar.addTab(ContactosTab);
		actionbar.addTab(EventosTab);

	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.agenda__simpus, menu);
		
		SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
		SearchView searchView = (SearchView) menu.findItem(R.id.buscar).getActionView();
		searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
		//Crear_Menu(menu);
		return true;
	}
	
//	public void Crear_Menu(Menu menu){
////		Declara los objetos o elementos de timo MenuItem
//		MenuItem item1;
//		item1 = menu.add(0, 1, 1, "Buscar");
//		item1.setIcon(R.drawable.buscar);
//		item1.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
//	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.agregar:
			Toast.makeText(getApplicationContext(), "Agregar", Toast.LENGTH_SHORT).show();
			actionbar.hide();
			break;
			
		case R.id.buscar:
			Toast.makeText(getApplicationContext(), "Buscar", Toast.LENGTH_SHORT).show();
			break;
		}
		
		return true;
	}

	@Override
	public boolean onMenuItemActionCollapse(MenuItem arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onMenuItemActionExpand(MenuItem arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onQueryTextChange(String newText) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean onQueryTextSubmit(String query) {
		// TODO Auto-generated method stub
		return false;
	}

}