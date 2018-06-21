package com.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

	//Auto wiring
@Autowired
private WelcomeService service;
@Autowired
private DataService dataservice;

	@RequestMapping("/welcome")
	public String welcome() 
	{
		return service.retrieveWelcomeMessage();
	}

	@GetMapping("/data")
	public List<Data> getdata() {
		return dataservice.getAlldata();
	}
	
	
@GetMapping("/data/{name}")
public Data getdataById(@PathVariable String name) 
{	
	return dataservice.getAlldataById(name);
}

@RequestMapping(method=RequestMethod.POST,value="/data")
public void addData(@RequestBody Data data) 
{
dataservice.addData(data);
	
}
@RequestMapping(method=RequestMethod.PUT,value="/data/{name}")
public void updateData(@RequestBody Data data,@PathVariable String name) 
{
	dataservice.updateData(name,data);	
}

@RequestMapping(method=RequestMethod.DELETE,value="/data/{name}")
public void deleteData(@PathVariable String name) 
{
	dataservice.deleteData(name);	
}



}