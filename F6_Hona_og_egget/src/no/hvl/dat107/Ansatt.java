package no.hvl.dat107;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "f5d")
public class Ansatt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String navn;
    
    @ManyToOne
    @JoinColumn(name = "avd_id")
    private Avdeling avdeling;

    public Ansatt() {}
    
    public Ansatt(String navn, Avdeling avdeling) {
        this.navn = navn;
        this.avdeling = avdeling;
    }

    public void skrivUt() {
        System.out.printf("   Ansatt %d(%s): Jobber i %s%n", 
                id, navn, avdeling.getNavn());
    }

	public int getId() {
		return id;
	}

	public String getNavn() {
		return navn;
	}

	public Avdeling getAvdeling() {
		return avdeling;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void setAvdeling(Avdeling avdeling) {
		this.avdeling = avdeling;
	}

    

}
