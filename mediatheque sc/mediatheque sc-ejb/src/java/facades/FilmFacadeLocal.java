/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import enitite.Film;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author enjoy
 */
@Local
public interface FilmFacadeLocal {

    void create(Film film);

    void edit(Film film);

    void remove(Film film);

    Film find(Object id);

    List<Film> findAll();

    List<Film> findRange(int[] range);

    int count();
    
    public Film findByTitreRealisateur(String titre, String realisateur);
    
    public List<Film> findDistinctFilm();
    
    public Film findDispoByTitreRealisateur(String titre, String realisateur);
    
    public List<Film> findAllCopyFilm(String titre, String realisateur);
    
    public List<Film> findByTitre(String titre);
    
    public List<Film> findByRealisateur(String realisateur);
    
    public List<Film> findByActeur(String acteur);
    
}
