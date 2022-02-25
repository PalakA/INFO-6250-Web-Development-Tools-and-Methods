/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mvc.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author palak
 */
public class Computer {
    List<base> computer = new ArrayList<>();

    public Computer() {
        this.computer = new ArrayList<>();
        computer.add(new base("Apple MacBook Pro with 13.3' Display", 1299.99f));
        computer.add(new base("Asus Laptop with Centrino 2 Black", 949.95f));
        computer.add(new base("HP Pavilion Laptop with Centrino 2 DV7", 1199.95f));
        computer.add(new base("Toshiba Satellite Laptop with Centrino 2-Copper", 899.99f));
        computer.add(new base("Sony VADO Laptop with Core 2 Duo Cosmopolitan Pink", 779.99f));
    }

    public List<base> getComputer() {
        return computer;
    }

    public void setComputer(List<base> computer) {
        this.computer = computer;
    }
}
