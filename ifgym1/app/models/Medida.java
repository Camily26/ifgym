package models;

import javax.persistence.Entity;

import play.data.validation.Min;
import play.data.validation.Required;
import play.db.jpa.Model;

@Entity
public class Medida extends Model {
    @Required
    @Min(0)
    public Integer peso;
    
    @Required
    @Min(0)
    public Integer altura;

    @Required
    @Min(0)
    public Double ombro;
    
    @Required
    @Min(0)
    public Double biceps;
    
    @Required
    @Min(0)
    public Double antebraco;
    
    @Required
    @Min(0)
    public Double busto;
    
    @Required
    @Min(0)
    public Double abdomen;
    
    @Required
    @Min(0)
    public Double quadril;
    
    @Required
    @Min(0)
    public Double cintura;
    
    @Required
    @Min(0)
    public Double gluteo;
    
    @Required
    @Min(0)
    public Double quadriceps;
    
    @Required
    @Min(0)
    public Double panturrilha;
}
