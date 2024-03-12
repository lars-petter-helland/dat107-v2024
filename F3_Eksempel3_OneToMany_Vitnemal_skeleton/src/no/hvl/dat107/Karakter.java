package no.hvl.dat107;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "forelesning3_one2many")
public class Karakter {
	
	@Id	//autogenerert ... ?
	private int karNr;
	private String emnekode;
	private LocalDate eksdato;
	private String bokstav;
	
	//ref til vitnemål ... ?
	//private int studNr;
	
}
