/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.github.adriens.excuses.sdk;

/**
 *
 * @author 3004SAL
 */
public class ExcuseNotFoundException extends Exception {
    public ExcuseNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
