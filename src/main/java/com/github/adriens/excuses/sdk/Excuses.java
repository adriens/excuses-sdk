/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.excuses.sdk;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *
 * @author 3004SAL
 */
public class Excuses {

    public static final String DATA_FILE = "excuses.csv";

    public List<Excuse> getAll() throws Exception {
        List<Excuse> out;
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(DATA_FILE).getFile());

        out = new CsvToBeanBuilder(new FileReader(file))
                .withType(Excuse.class)
                .build()
                .parse();
        out.forEach(System.out::println);
        return out;
    }

    public List<String> getCategories() throws Exception {
        Set<String> out = new HashSet<String>();
        
        Iterator<Excuse> catsIter = getAll().iterator();
        while (catsIter.hasNext()) {
            out.add(catsIter.next().getCategory());
        }
        return new ArrayList<>(out);
    }

    //TODO  inject to HashSet then filter and return
    public List<Excuse> getByCategory(String cat) throws Exception {
        System.out.println("Get excuses for <" + cat + "> :");
        Iterator<Excuse> excIter = getAll().iterator();
        ArrayList<Excuse> out = new ArrayList<Excuse>();
        while (excIter.hasNext()) {
            Excuse ex = excIter.next();
            if (ex.getCategory().equalsIgnoreCase(cat)) {
                out.add(ex);
                System.out.println(ex);
            }
        }
        if(out.size() == 0){
            throw new CategoryNotFoundException("Pas d'excuse pour la catégorie <" + cat + ">");
        }
        return out;
    }

    
    public Excuse pickRandomly() throws Exception{
        Excuse out = new Excuse();
        Random rand = new Random();
        int randomIndex = rand.nextInt(getAll().size()); 
        //System.out.println("Random index : <" + randomIndex + ">");
        out = getAll().get(randomIndex);
        return out;
    }
    
    public Excuse pickRandomly(String aCategory) throws Exception{
        Excuse out = new Excuse();
        Random rand = new Random();
        int randomIndex = rand.nextInt(getByCategory(aCategory).size()); 
        //System.out.println("Random index : <" + randomIndex + ">");
        out = getByCategory(aCategory).get(randomIndex);
        return out;
    }
    
    public static void main(String[] args) {
        try {
            Excuses excuses = new Excuses();
            //tes collègue te gonflent avec le sport ?
            //List<Excuse> exc = excuses.getByCategory("Sport");
            //System.out.println("Random excuse : <" + excuses.pickRandomly() + ">");
            System.out.println("Random excuse for BOULOT: <" + excuses.pickRandomly("bidon") + ">");
            System.exit(0);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(1);
        }
    }
}
