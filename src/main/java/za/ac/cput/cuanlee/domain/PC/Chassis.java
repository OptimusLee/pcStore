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
public class Chassis implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String description;
    private Integer hddBays;
    private Integer caseFans;
    private String formFactor;
    private Integer stock;
    private Integer activeStock;

    public Chassis() {
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

    public Integer getActiveStock() {
        return activeStock;
    }

    public Integer getHddBays() {
        return hddBays;
    }

    public Integer getCaseFans() {
        return caseFans;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public Integer getStock() {
        return stock;
    }

    private Chassis(Builder builder)
    {
        this.id = builder.id;
        this.code = builder.code;
        this.description = builder.description;
        this.hddBays = builder.hddBays;
        this.caseFans = builder.caseFans;
        this.formFactor = builder.formFactor;
        this.stock = builder.stock;
        this.activeStock = builder.activeStock;
    }

    public static class Builder{
        private Long id;
        private String code;
        private String description;
        private Integer activeStock;
        private Integer hddBays;
        private Integer caseFans;
        private String formFactor;
        private Integer stock;

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

        public Builder hddBays(Integer value)
        {
            this.hddBays = value;
            return this;
        }

        public Builder caseFans(Integer value)
        {
            this.caseFans = value;
            return this;
        }

        public Builder formFactor(String value)
        {
            this.formFactor = value;
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

        public Builder copy(Chassis value)
        {
            this.id = value.id;
            this.code = value.code;
            this.description = value.description;
            this.hddBays = value.hddBays;
            this.caseFans = value.caseFans;
            this.formFactor = value.formFactor;
            this.stock = value.stock;
            this.activeStock = value.activeStock;

            return this;
        }

        public Chassis build(){
            return new Chassis(this);
        }
    }
}

