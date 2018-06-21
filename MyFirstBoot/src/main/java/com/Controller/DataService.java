package com.Controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Controller.Data;

@Service
public class DataService 
{

private List<Data> data=new ArrayList<Data>(Arrays.asList
	(
	new Data("firoz","indore","firoz"),
	new Data("abc","abc123","qwe"),
	new Data("abc","abc123","zxc")
	));

public 	List<Data> getAlldata()
{
	return data;	
}

public 	Data getAlldataById(String name)
{
	return data.stream().filter(t -> t.getName().equals(name)).findFirst().get();	
}

public 	void addData(Data d)
{
	data.add(d);
}

public 	void updateData(String name,Data da)
{	
	for(int i=0;i<data.size();i++) 
	{
		Data d=data.get(i);
			if(d.getName().equals(name)) 
			{
				
				data.set(i, da);
				return;

			}
		
	}
}

public 	void deleteData(String name)
{	
	data.removeIf(t -> t.getName().equals(name));
}
}
