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
public class RAM implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String description;
    private String memorySize;
    private double voltage;
    private String memoryConfiguration;
    private Integer stock;
    private Integer activeStock;

    public RAM() {
    }

    public Long getId() {
        return id;
    }

    public String getMemorySize() {
        return memorySize;
    }

    public double getVoltage() {
        return voltage;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public String getMemoryConfiguration() {
        return memoryConfiguration;
    }

    public Integer getStock() {
        return stock;
    }

    public Integer getActiveStock() {
        return activeStock;
    }

    private RAM(Builder builder)
    {
        this.id = builder.id;
        this.code = builder.code;
        this.description = builder.description;
        this.memoryConfiguration = builder.memoryConfiguration;
        this.voltage = builder.voltage;
        this.memorySize = builder.memorySize;
        this.stock = builder.stock;
        this.activeStock = builder.activeStock;
    }

    public static class Builder{
        private Long id;
        private String memorySize;
        private double voltage;
        private String code;
        private String description;
        private String memoryConfiguration;
        private Integer stock;
        private Integer activeStock;

        public Builder id(Long value)
        {
            this.id = value;
            return this;
        }

        public Builder memorySize(String value)
        {
            this.memorySize = value;
            return this;
        }

        public Builder voltage(double value)
        {
            this.voltage = value;
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

        public Builder memoryConfiguration(String value)
        {
            this.memoryConfiguration = value;
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

        public Builder copy(RAM value)
        {
            this.id = value.id;
            this.memorySize = value.memorySize;
            this.voltage = value.voltage;
            this.code = value.code;
            this.description = value.description;
            this.memoryConfiguration = value.memoryConfiguration;
            this.stock = value.stock;
            this.activeStock = value.activeStock;

            return this;
        }

        public RAM build(){
            return new RAM(this);
        }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
