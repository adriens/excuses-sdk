/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.excuses.sdk;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
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

    public static final String DATA_FILE = "/excuses.csv";

    public List<Excuse> getAll() throws Exception {
        List<Excuse> out;
        getClass().getResourceAsStream(DATA_FILE);
        //ClassLoader classLoader = getClass().getClassLoader();
        InputStream fileStream = getClass().getResourceAsStream(DATA_FILE);
        Reader targetReader = new InputStreamReader(fileStream,StandardCharsets.UTF_8);
        
        out = new CsvToBeanBuilder(targetReader)
                .withType(Excuse.class)
                .build()
                .parse();
        //out.forEach(System.out::println);
        fileStream.close();
        return out;
    }
    
    public List<Excuse> getAll(int maxLength) throws Exception {
        List<Excuse> out = new ArrayList<>();
        Iterator<Excuse> iter = getAll().iterator();
        while(iter.hasNext()){
            Excuse lExc = iter.next();
            if(lExc.getExcuse().length() <= maxLength){
                out.add(lExc);
            }
        }
        return out;
    }

    public List<String> getCategories() throws Exception {
        Set<String> out = new HashSet<String>();
        
        Iterator<Excuse> catsIter = getAll().iterator();
        while (catsIter.hasNext()) {
            String lCat = catsIter.next().getCategory();
            if(lCat.length() > 0){
                out.add(lCat);
            }
        }
        return new ArrayList<>(out);
    }

    //TODO  inject to HashSet then filter and return
    public List<Excuse> getByCategory(String cat) throws Exception {
        //System.out.println("Get excuses for <" + cat + "> :");
        Iterator<Excuse> excIter = getAll().iterator();
        ArrayList<Excuse> out = new ArrayList<Excuse>();
        while (excIter.hasNext()) {
            Excuse ex = excIter.next();
            if (ex.getCategory().equalsIgnoreCase(cat)) {
                out.add(ex);
                //System.out.println(ex);
            }
        }
        if(out.size() == 0){
            throw new CategoryNotFoundException("Pas d'excuse pour la catégorie <" + cat + ">");
        }
        return out;
    }

    public List<Excuse> getByCategory(String cat, int maxLength) throws Exception{
        ArrayList<Excuse> out = new ArrayList<Excuse>();
        Iterator<Excuse> iter = getByCategory(cat).iterator();
        while(iter.hasNext()){
            Excuse lExc = iter.next();
            if(lExc.getExcuse().length() <= maxLength){
                out.add(lExc);
            }
        }
        return out;
    }
    public Excuse getById(int id) throws Exception{
        Excuse out = new Excuse();
        try{
            out = getAll().get(id-1);
        }
        catch(IndexOutOfBoundsException ex){
            throw new ExcuseNotFoundException("L'excuse <" + id + "> n'exite pas."); 
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
    public Excuse pickRandomly(int maxLength) throws Exception {
        Excuse out = new Excuse();
        Random rand = new Random();
        List<Excuse> excList = getAll(maxLength);
        if(excList.size() < 1){
            return null;
        }
        int randomIndex = rand.nextInt(excList.size()); 
        //System.out.println("Random index : <" + randomIndex + ">");
        out = excList.get(randomIndex);
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
    public Excuse pickRandomly(String aCategory, int maxLength) throws Exception{
        Excuse out = new Excuse();
        Random rand = new Random();
        List<Excuse> theList = getByCategory(aCategory, maxLength);
        // on cache les "shadow excuses" que je cache dans la data LOOOOOL
        if(theList.size() < 1){
            return null;
        }
        int randomIndex = rand.nextInt(theList.size()); 
        //System.out.println("Random index : <" + randomIndex + ">");
        out = theList.get(randomIndex);
        return out;
    }
    public static void main(String[] args) {
        try {
            Excuses excuses = new Excuses();
            //tes collègue te gonflent avec le sport ?
            //List<Excuse> exc = excuses.getByCategory("Sport");
            //System.out.println("Random excuse : <" + excuses.pickRandomly() + ">");
            //System.out.println("Random excuse for BOULOT: <" + excuses.pickRandomly("boulot") + ">");
            //System.out.println("Excuse 3 : " + excuses.getById(3));
            //System.out.println(excuses.pickRandomly(2));
            //System.out.println(excuses.pickRandomly("boulot", 2));
            //System.out.println(excuses.getByCategory("boulot", 15));
            System.out.println(excuses.getCategories());
            System.exit(0);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println(1);
        }
    }
}
