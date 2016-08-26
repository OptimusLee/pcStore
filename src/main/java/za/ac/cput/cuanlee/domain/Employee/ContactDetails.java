package za.ac.cput.cuanlee.domain.Employee;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by User on 2016/07/19.
 */
@Embeddable
public class ContactDetails implements Serializable{
    private String telephone;
    private String email;

    public ContactDetails(){

    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public ContactDetails(Builder builder){
        telephone = builder.telephone;
        email = builder.email;
    }

    public static class Builder{
        private String telephone;
        private String email;

        public Builder telephone(String telephone){
            this.telephone = telephone;
            return this;
        }

        public Builder email(String value){
            this.email = value;
            return this;
        }

        public Builder copy(ContactDetails value)
        {
            this.telephone = value.telephone;
            this.email = value.email;

            return this;
        }

        public ContactDetails build(){return new ContactDetails(this);}
    }

}

