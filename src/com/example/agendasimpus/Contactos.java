package com.example.agendasimpus;

import android.app.ActionBar;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Contactos extends Fragment implements OnClickListener{
	
	public ActionBar action;
	public Context contexto;
	public Button btn1, btn2;
	public ImageView up_down;
	public boolean up2down=false;
	
	public Contactos(ActionBar c, Context context){
		action=c;
		contexto = context;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View vista = inflater.inflate(R.layout.contactos, container, false);
		
		btn1 = (Button) vista.findViewById(R.id.button1);
		btn1.setOnClickListener(this);
		
		btn2 = (Button) vista.findViewById(R.id.button2);
		btn2.setOnClickListener(this);
		
		up_down = (ImageView) vista.findViewById(R.id.up_down);
		up_down.setOnClickListener(this);
	
		return vista;
	}
 
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}

	@Override
	public void onClick(View v) {
		switch(v.getId()){
			case R.id.button1:
				Toast.makeText(contexto, "Mostrar", Toast.LENGTH_SHORT).show();
				action.show();
			break;
			
			case R.id.button2:
				Toast.makeText(contexto, "Ocultar", Toast.LENGTH_SHORT).show();
				action.hide();
			break;
			
			case R.id.up_down:
				if(up2down == false){
					up2down=true;
					action.hide();
					up_down.setBackgroundResource(R.drawable.down);
				} 
				else{
					up2down=false;
					action.show();
					up_down.setBackgroundResource(R.drawable.up);
				}
					
				break;
		}
		
	}



}
