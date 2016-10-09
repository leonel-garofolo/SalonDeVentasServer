/*
 * Created on 9 oct 2016 ( Time 10:28:26 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package org.salondeventas.server.modelo.jpa;

import java.io.Serializable;
import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;

import java.util.Date;

import javax.persistence.*;

/**
 * Persistent class for entity stored in table "licencias"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="licencias", catalog="salon_de_ventas" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="LicenciasEntity.countAll", query="SELECT COUNT(x) FROM LicenciasEntity x" )
} )
public class LicenciasEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="numero", nullable=false)
	private Integer    numero       ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_desde")
		    private Date       fechaDesde   ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="fecha_hasta")
		    private Date       fechaHasta   ;

    @Column(name="usada")
		    private Boolean    usada        ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public LicenciasEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setNumero( Integer numero ) {
        this.numero = numero ;
    }
    public Integer getNumero() {
        return this.numero;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : fecha_desde ( DATETIME ) 
    public void setFechaDesde( Date fechaDesde ) {
        this.fechaDesde = fechaDesde;
    }
    public Date getFechaDesde() {
        return this.fechaDesde;
    }

    //--- DATABASE MAPPING : fecha_hasta ( DATETIME ) 
    public void setFechaHasta( Date fechaHasta ) {
        this.fechaHasta = fechaHasta;
    }
    public Date getFechaHasta() {
        return this.fechaHasta;
    }

    //--- DATABASE MAPPING : usada ( BIT ) 
    public void setUsada( Boolean usada ) {
        this.usada = usada;
    }
    public Boolean getUsada() {
        return this.usada;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(numero);
        sb.append("]:"); 
        sb.append(fechaDesde);
        sb.append("|");
        sb.append(fechaHasta);
        sb.append("|");
        sb.append(usada);
        return sb.toString(); 
    } 

}
