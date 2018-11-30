package entidades;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Diego Muniz -- diego2605@gmail.com
 */
@Entity
@Table(name="PARAMETROS")
public class Parameter implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="ID")
    private Long ID;
    
    @Column(name="NOME")
    private String name;
    

    @Column(name="VALOR")
    private String value;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }
public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

 
}