/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.excuses.sdk;

import com.opencsv.bean.CsvBindByPosition;

/**
 *
 * @author 3004SAL
 */
public class Excuse {
    
    @CsvBindByPosition(position = 0)
    private int id;
    
    @CsvBindByPosition(position = 1)
    private String category;
    
    @CsvBindByPosition(position = 2)
    private String excuse;
    
    public String toString (){
        return this.getExcuse();
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * @return the category
     */
    public String getCategory() {
        return category;
    }

    /**
     * @param category the category to set
     */
    public void setCategory(String category) {
        this.category = category;
    }

    /**
     * @return the excuse
     */
    public String getExcuse() {
        return excuse;
    }

    /**
     * @param excuse the excuse to set
     */
    public void setExcuse(String excuse) {
        this.excuse = excuse;
    }    
}
