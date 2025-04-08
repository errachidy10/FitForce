package org.example.sport.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Homecontroller {

    // Méthode pour afficher la page d'accueil
    @GetMapping("/acceuil")
    public String home() {
        return "acceuil";  // Le nom du fichier HTML sans l'extension .html
    }
}
