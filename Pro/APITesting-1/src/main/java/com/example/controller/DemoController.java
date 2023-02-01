package com.example.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.Dto.EntriesDTO;
import com.example.exception.EntriesException;
import com.example.models.Entries;
import com.example.models.EntriesallData;
import com.example.services.EntriesService;

@RestController
public class DemoController {
	
       @Autowired
       private RestTemplate restTemp;
       
       @Autowired
       private EntriesService entriesSer;
       
    
       
   	@GetMapping("/entries/{category}")
   	public List<EntriesDTO> getEntriesHandler(@PathVariable("category") String category){
   		
   		EntriesallData data=restTemp.getForObject("https://api.publicapis.org/entries",EntriesallData.class );
   		
   		List<Entries> entries =data.getEntries();
   		
//   		List<EntriesDTO> list=entries.stream().filter(e->e.getCategory()
//   				                            .equals(category))
//   				                            .map(e->new EntryDTO(e.getApi(),e.getDescription()));
//   				                          
   		List<EntriesDTO> listAllDto = entries.stream().filter(i->i.getCategory().equals(category)).map(i->new EntriesDTO(i.getApi(),i.getDescription())).toList();
   		return listAllDto;
   	}
   	
   	@PostMapping("/add")
	public ResponseEntity<Entries> addEntryHandler(@RequestBody Entries entry) throws EntriesException{
		Entries saveEntry=entriesSer.AddNewEntries(entry);
		return new ResponseEntity<Entries>(saveEntry,HttpStatus.CREATED);
	}
   	
   
   	
   	
   	
   	@PostMapping("/category")
    public String saveByCategory(@PathVariable("category") String category) throws EntriesException{
		
		String url ="https://api.publicapis.org/entries";
		
		ResponseEntity<EntriesallData> desc = restTemp.getForEntity(url, EntriesallData.class);
		
		if(desc.getStatusCodeValue()==200) {
			EntriesallData data = desc.getBody();
			List<Entries> list =  data.getEntries().stream().filter((e)->e.getCategory().equals(category)).collect(Collectors.toList());

			for(Entries item:list) {
				Entries newentries = new Entries();
				entriesSer.AddNewEntries(newentries);
			}
			return "Saved";
		}
		return "not saved...!";
		
	}
   	
   	
   	
       
}
