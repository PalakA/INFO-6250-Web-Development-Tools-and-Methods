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
public class Music {
    List<base> music = new ArrayList<>();

    public Music() {
        this.music = new ArrayList<>();
        music.add(new base("I'm Going to Tell You a Secret by Madonna", 26.99f));
        music.add(new base("Baby One More Time by Britney Spears", 10.95f));
        music.add(new base("Justified by Justin Timberlake", 9.77f));
        music.add(new base("Loose by Nelly Furtado", 13.98f));
        music.add(new base("Gold Digger by Kanye West", 27.99f));
    }

    public List<base> getMusic() {
        return music;
    }

    public void setMusic(List<base> music) {
        this.music = music;
    }

}
