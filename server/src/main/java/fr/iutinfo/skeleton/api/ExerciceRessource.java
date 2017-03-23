package fr.iutinfo.skeleton.api;

import java.io.File;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/exercice")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ExerciceRessource {
	
	@POST
	public String createExercice(String code) {
		File fichier = Exercice.StringtoJava(code.split(":")[1].substring(1, code.split(":")[1].length()-1), "./test.java");
		StringBuffer reponseCompilation = new StringBuffer();
		ArrayList<String> l = (ArrayList<String>) JavaCompilerproject.CompilationIJava(fichier);
		for (String string : l) {
			reponseCompilation.append(string+"\n");
		}
		System.out.println("ICI ==============> " + reponseCompilation.toString());
		return reponseCompilation.toString();
	}

}
