package no.hvl.dat107.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(schema = "forelesning6c")
public class Ansatt extends Person { 

    private String stilling;

    public Ansatt() {}
    
    public Ansatt(String fNr, String fornavn, String etternavn, String stilling) {
        super(fNr, fornavn, etternavn);
        this.stilling = stilling;
    }
    
    @Override
    public String toString() {
        return super.toString() + ", stilling=" + stilling;
    }


}

