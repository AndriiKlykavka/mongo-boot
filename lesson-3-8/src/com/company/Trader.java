package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Trader {
    String name;
    Share[] target;
    static boolean[] shareStatus = new boolean[2];


    public String getName() {
        return name;
    }

    public Trader(String name, Share[] target) {
        this.name = name;
        this.target = target;
        setShareStatus(target);
    }

    public boolean[] setShareStatus(Share[] target){

        for(int i = 0; i < target.length; i++){
            shareStatus[i] = true;
        }

        return shareStatus;
    }

    public void changeShareStatusToFalse(Share share) {
        for(int i = 0; i < target.length; i++){
            if(Objects.equals(target[i].getName(), share.getName())){
                shareStatus[i] = false;
            }
        }

    }

    public boolean getShareStatus(Share share){
        for(int i = 0; i < target.length; i++){
            if(Objects.equals(target[i].getName(), share.getName())){
                return shareStatus[i];
            }
        }
        return true;
    }
}
