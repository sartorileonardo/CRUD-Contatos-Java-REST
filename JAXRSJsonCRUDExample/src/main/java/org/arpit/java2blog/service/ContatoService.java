package org.arpit.java2blog.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.arpit.java2blog.bean.Contato;

/*
 * It is just a helper class which should be replaced by database implementation.
 * It is not very well written class, it is just used for demonstration.
 */
public class ContatoService {

	static HashMap<Integer,Contato> contatoIdMap=getContatoIdMap();


	public ContatoService() {
		super();

		if(contatoIdMap==null)
		{
			contatoIdMap=new HashMap<Integer,Contato>();
		// Creating some object of countries while initializing
			
			Date today = new Date();
			SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
			
			DATE_FORMAT = new SimpleDateFormat("dd/MM/yy");
	        String date = DATE_FORMAT.format(today);
			
			Contato c1 = new Contato(1, "Joao", "(48) 8896-9658", date);
			Contato c2 = new Contato(2, "Maria", "(48) 8896-9658", date);
			Contato c3 = new Contato(3, "Pedro", "(48) 8896-9658", date);
			Contato c4 = new Contato(4, "Jose", "(48) 8896-9658", date);

			contatoIdMap.put(1,c1);
			contatoIdMap.put(2,c2);
			contatoIdMap.put(3,c3);
			contatoIdMap.put(4,c4);
		}
	}

	public List<Contato> getAllContatos()
	{
		List<Contato> contatos = new ArrayList<Contato>(contatoIdMap.values());
		return contatos;
	}

	public Contato getContato(int id)
	{
		Contato contato= contatoIdMap.get(id);
		return contato;
	}
	public Contato addContato(Contato contato)
	{
		contato.setId(contatoIdMap.size()+1);
		contatoIdMap.put(contato.getId(), contato);
		return contato;
	}
	
	public Contato updateContato(Contato contato)
	{
		if(contato.getId()<=0)
			return null;
		contatoIdMap.put(contato.getId(), contato);
		return contato;

	}
	public void deleteContato(int id)
	{
		contatoIdMap.remove(id);
	}

	public static HashMap<Integer, Contato> getContatoIdMap() {
		return contatoIdMap;
	}


}
