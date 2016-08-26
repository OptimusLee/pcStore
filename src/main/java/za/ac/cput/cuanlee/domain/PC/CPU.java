package za.ac.cput.cuanlee.domain.PC;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by User on 2016/07/19.
 */
@Entity
public class CPU implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String description;
    private Integer socket;
    private String processorBrand;
    private double speed_Ghz;
    private double cache_MB;
    private Integer cores;
    private Integer stock;
    private Integer activeStock;

    public CPU() {
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public Integer getSocket() {
        return socket;
    }

    public String getProcessorBrand() {
        return processorBrand;
    }

    public double getSpeed_Ghz() {
        return speed_Ghz;
    }

    public double getCache_MB() {
        return cache_MB;
    }

    public Integer getCores() {
        return cores;
    }

    public Integer getStock() {
        return stock;
    }

    public Integer getActiveStock() {
        return activeStock;
    }

    private CPU(Builder builder)
    {
        this.id = builder.id;
        this.code = builder.code;
        this.description = builder.description;
        this.socket = builder.socket;
        this.processorBrand= builder.processorBrand;
        this.speed_Ghz = builder.speed_Ghz;
        this.cache_MB = builder.cache_MB;
        this.cores = builder.cores;
        this.stock = builder.stock;
        this.activeStock = builder.activeStock;
    }

    public static class Builder{
        private Long id;
        private String code;
        private String description;
        private Integer socket;
        private String processorBrand;
        private double speed_Ghz;
        private double cache_MB;
        private Integer cores;
        private Integer stock;
        private Integer activeStock;

        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }

        public Builder code(String value)
        {
            this.code = value;
            return this;
        }

        public Builder description(String value)
        {
            this.description = value;
            return this;
        }

        public Builder socket(Integer value)
        {
            this.socket = value;
            return this;
        }

        public Builder processorBrand(String value)
        {
            this.processorBrand = value;
            return this;
        }

        public Builder speed_Ghz(double value)
        {
            this.speed_Ghz = value;
            return this;
        }

        public Builder cache_MB(double value)
        {
            this.cache_MB = value;
            return this;
        }

        public Builder cores(Integer value)
        {
            this.cores = value;
            return this;
        }

        public Builder stock(Integer value)
        {
            this.stock = value;
            return this;
        }

        public Builder activeStock(Integer value)
        {
            this.activeStock = value;
            return this;
        }

        public Builder copy(CPU value)
        {
            this.id = value.id;
            this.code = value.code;
            this.description = value.description;
            this.socket = value.socket;
            this.processorBrand = value.processorBrand;
            this.speed_Ghz = value.speed_Ghz;
            this.cache_MB = value.cache_MB;
            this.cores = value.cores;
            this.stock = value.stock;
            this.activeStock = value.activeStock;

            return this;
        }

        public CPU build(){
            return new CPU(this);
        }
    }
}

