package fr.dawan.formationjpa.presentation;

import java.util.List;
import java.util.Scanner;

import fr.dawan.formationjpa.dao.FormateurDAO;
import fr.dawan.formationjpa.dao.FormationDAO;
import fr.dawan.formationjpa.entities.Formateur;

public class App9 {

	public static void main(String[] args) {
		
		System.out.println("Veuillez saisir un nom, ou une partie du nom");
		Scanner sc = new Scanner(System.in);
		String saisie = sc.nextLine();
		
		//testFindByNameNativeSQL(saisie);
		testFindByNameJPLPositionalParameter(saisie);
		//testFindByNameJPLNamedParameter(saisie);
	}

	private static void testFindByNameJPLPositionalParameter(String saisie) {
		List<Formateur> formateurs =  FormateurDAO.findByNameJPQLPositionalParameter(saisie);
		for (Formateur formateur : formateurs) {
			System.out.println(formateur);
		}
		
	}

	private static void testFindByNameNativeSQL(String saisie) {
		List<Formateur> formateurs =  FormateurDAO.findByNameNativeSQL(saisie);
		for (Formateur formateur : formateurs) {
			System.out.println(formateur);
		}
	}
	

}
