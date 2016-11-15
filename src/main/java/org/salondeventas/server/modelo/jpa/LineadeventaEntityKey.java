/*
 * Created on 13 nov 2016 ( Time 23:45:00 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.salondeventas.server.modelo.jpa;
import java.io.Serializable;

import javax.persistence.*;

/**
 * Composite primary key for entity "LineadeventaEntity" ( stored in table "lineadeventa" )
 *
 * @author Telosys Tools Generator
 *
 */
 @Embeddable
public class LineadeventaEntityKey implements Serializable {
    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY KEY ATTRIBUTES 
    //----------------------------------------------------------------------
    @Column(name="idlineadeventa", nullable=false)
	private Integer    idlineadeventa ;
    
    @Column(name="idproducto", nullable=false)
	private Integer    idproducto   ;
    
    @Column(name="idVenta", nullable=false)
	private Integer    idventa      ;
    

    //----------------------------------------------------------------------
    // CONSTRUCTORS
    //----------------------------------------------------------------------
    public LineadeventaEntityKey() {
        super();
    }

    public LineadeventaEntityKey( Integer idlineadeventa, Integer idproducto, Integer idventa ) {
        super();
        this.idlineadeventa = idlineadeventa ;
        this.idproducto = idproducto ;
        this.idventa = idventa ;
    }
    
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR KEY FIELDS
    //----------------------------------------------------------------------
    public void setIdlineadeventa( Integer value ) {
        this.idlineadeventa = value;
    }
    public Integer getIdlineadeventa() {
        return this.idlineadeventa;
    }

    public void setIdproducto( Integer value ) {
        this.idproducto = value;
    }
    public Integer getIdproducto() {
        return this.idproducto;
    }

    public void setIdventa( Integer value ) {
        this.idventa = value;
    }
    public Integer getIdventa() {
        return this.idventa;
    }


    //----------------------------------------------------------------------
    // equals METHOD
    //----------------------------------------------------------------------
	public boolean equals(Object obj) { 
		if ( this == obj ) return true ; 
		if ( obj == null ) return false ;
		if ( this.getClass() != obj.getClass() ) return false ; 
		LineadeventaEntityKey other = (LineadeventaEntityKey) obj; 
		//--- Attribute idlineadeventa
		if ( idlineadeventa == null ) { 
			if ( other.idlineadeventa != null ) 
				return false ; 
		} else if ( ! idlineadeventa.equals(other.idlineadeventa) ) 
			return false ; 
		//--- Attribute idproducto
		if ( idproducto == null ) { 
			if ( other.idproducto != null ) 
				return false ; 
		} else if ( ! idproducto.equals(other.idproducto) ) 
			return false ; 
		//--- Attribute idventa
		if ( idventa == null ) { 
			if ( other.idventa != null ) 
				return false ; 
		} else if ( ! idventa.equals(other.idventa) ) 
			return false ; 
		return true; 
	} 


    //----------------------------------------------------------------------
    // hashCode METHOD
    //----------------------------------------------------------------------
	public int hashCode() { 
		final int prime = 31; 
		int result = 1; 
		
		//--- Attribute idlineadeventa
		result = prime * result + ((idlineadeventa == null) ? 0 : idlineadeventa.hashCode() ) ; 
		//--- Attribute idproducto
		result = prime * result + ((idproducto == null) ? 0 : idproducto.hashCode() ) ; 
		//--- Attribute idventa
		result = prime * result + ((idventa == null) ? 0 : idventa.hashCode() ) ; 
		
		return result; 
	} 


    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() {
		StringBuffer sb = new StringBuffer(); 
		sb.append(idlineadeventa); 
		sb.append("|"); 
		sb.append(idproducto); 
		sb.append("|"); 
		sb.append(idventa); 
        return sb.toString();
    }
}
