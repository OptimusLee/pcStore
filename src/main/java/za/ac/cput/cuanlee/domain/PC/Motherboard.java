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
public class Motherboard implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String description;
    private String chipset;
    private Integer sataPorts;
    private Integer usb2;
    private Integer usb3;
    private String formFactor;
    private Integer stock;
    private Integer activeStock;

    public Motherboard() {
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


    public String getChipset() {
        return chipset;
    }

    public Integer getSataPorts() {
        return sataPorts;
    }

    public Integer getUsb2() {
        return usb2;
    }

    public Integer getUsb3() {
        return usb3;
    }

    public String getFormFactor() {
        return formFactor;
    }

    public Integer getStock() {
        return stock;
    }

    public Integer getActiveStock() {
        return activeStock;
    }

    private Motherboard(Builder builder)
    {
        this.id = builder.id;
        this.code = builder.code;
        this.description = builder.description;
        this.chipset = builder.chipset;
        this.sataPorts = builder.sataPorts;
        this.usb2 = builder.usb2;
        this.usb3 = builder.usb3;
        this.formFactor = builder.formFactor;
        this.stock = builder.stock;
        this.activeStock = builder.activeStock;
    }

    public static class Builder{
        private Long id;
        private String code;
        private String description;
        private String chipset;
        private Integer sataPorts;
        private Integer usb2;
        private Integer usb3;
        private String formFactor;
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

        public Builder chipset(String value)
        {
            this.chipset = value;
            return this;
        }

        public Builder sataPorts(Integer value)
        {
            this.sataPorts = value;
            return this;
        }

        public Builder usb2(Integer value)
        {
            this.usb2 = value;
            return this;
        }

        public Builder usb3(Integer value)
        {
            this.usb3 = value;
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

        public Builder copy(Motherboard value)
        {
            this.id = value.id;
            this.code = value.code;
            this.description = value.description;
            this.chipset = value.chipset;
            this.sataPorts = value.sataPorts;
            this.usb2 = value.usb2;
            this.usb3 = value.usb3;
            this.stock = value.stock;
            this.formFactor = value.formFactor;
            this.activeStock = value.activeStock;

            return this;
        }

        public Motherboard build(){
            return new Motherboard(this);
        }
    }
}

