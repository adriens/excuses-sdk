/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.excuses;

import com.github.adriens.excuses.sdk.Excuse;
import com.github.adriens.excuses.sdk.Excuses;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 *
 * @author 3004SAL
 */
public class ExcusesTest {
    
    @DisplayName("Récupération de toutes les excuss")
    @Test
    void testGetAll() {
        try{
            Excuses excuses = new Excuses();
            List<Excuse> lExcuses = excuses.getAll();
            Assertions.assertTrue(lExcuses != null);
            Assertions.assertTrue(lExcuses.size() > 0);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    @DisplayName("Récupération des catégories")
    @Test
    void testGetCategories() {
        try{
            Excuses excuses = new Excuses();
            List<String> lCats = excuses.getCategories();
            Assertions.assertTrue(lCats != null);
            Assertions.assertTrue(lCats.size() > 0);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    @DisplayName("Récupération d'une excuse au hasard")
    @Test
    void testPickRandomExcuse() {
        try{
            Excuses excuses = new Excuses();
            Excuse lExc = excuses.pickRandomly();
            Assertions.assertTrue(lExc != null);
            Assertions.assertTrue(lExc.getExcuse().length() > 0);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    @DisplayName("Récupération d'une excuse au hasard dans une catégorie")
    @Test
    void testPickRandomExcuseBoulot() {
        try{
            Excuses excuses = new Excuses();
            Excuse lExc = excuses.pickRandomly("boulot");
            Assertions.assertTrue(lExc != null);
            Assertions.assertTrue(lExc.getExcuse().length() > 0);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    @DisplayName("Récupération d'une excuse par son id")
    @Test
    void testPickExcuseById() {
        try{
            Excuses excuses = new Excuses();
            Excuse lExc = excuses.getById(666);
            Assertions.assertTrue(lExc != null);
            Assertions.assertTrue(lExc.getExcuse().length() > 0);
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
    
    @DisplayName("Récupération des excuses d'une longueur inférieure à x")
    @Test
    void testGetAllExcusesShorterThan() {
        try{
            Excuses excuses = new Excuses();
            List<Excuse> lExcuses = excuses.getAll(5);
            Assertions.assertTrue(lExcuses != null);
            Assertions.assertTrue(lExcuses.size() > 0);
            Iterator<Excuse> excIter = lExcuses.iterator();
            while (excIter.hasNext()){
                Excuse lExc = excIter.next();
                Assertions.assertTrue(lExc.getExcuse().length() <= 5 );
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
