package com.example.mapnotes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.MongoRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;



import java.util.Collections;
import java.util.List;



@SpringBootApplication
public class MapnotesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MapnotesApplication.class, args);
	}

}




@Document(collection = "notes")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
class Note {
    @Id
    private String id;
    private String description;

    @Override
    public String toString() {
        return description;
    }
	
}

interface NotesRepository extends MongoRepository<Note, String> {

}

@Controller
class MapnotesController {

    @Autowired
    private NotesRepository notesRepository;
	@GetMapping("/knote")
    public String index(Model model) {
        getAllNotes(model);
        return "index";
    }

    private void getAllNotes(Model model) {
        List<Note> notes = notesRepository.findAll();
        Collections.reverse(notes);
        model.addAttribute("notes", notes);
    }
	private void saveNote(String description, Model model) {
		if (description != null && !description.trim().isEmpty()) {
		  notesRepository.save(new Note(null, description.trim()));
		  //After publish you need to clean up the textarea
		  model.addAttribute("description", "");
		}
	  }
	  
}