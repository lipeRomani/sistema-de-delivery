package br.com.cantinhodamarmita.entitys;


import br.com.cantinhodamarmita.converters.LocalDateConverter;
import br.com.cantinhodamarmita.services.UserServiceImp;
import br.com.cantinhodamarmita.validators.Unique;
import br.com.cantinhodamarmita.validators.UniqueEntity;
import br.com.cantinhodamarmita.validators.ValidateGroup;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

@Component
@Document(collection = "users")
@Unique(primaryKey = "id",uniqueField = "email",service = UserServiceImp.class,message = "{user.email.unique}",groups = {ValidateGroup.onCreate.class, ValidateGroup.onUpdate.class})
public class User implements UniqueEntity, UserDetails {

    @Id
    private String id;

    @NotBlank(groups = {ValidateGroup.onCreate.class, ValidateGroup.onUpdate.class})
    private String email;

    @NotBlank(groups = {ValidateGroup.onCreate.class, ValidateGroup.onPasswordUpdate.class})
    private String password;
    @NotBlank(groups = {ValidateGroup.onCreate.class, ValidateGroup.onUpdate.class})
    private String name;
    private Address address;
    @NotBlank(groups = {ValidateGroup.onCreate.class, ValidateGroup.onUpdate.class})
    private String cellphone;
    private String telephone;

    @LocalDateConverter
    @NotNull(groups = {ValidateGroup.onCreate.class, ValidateGroup.onUpdate.class})
    private LocalDate birthDate;
    private List<Roles> roles;

    public User(String email, String password, String name, Address address, String cellphone, String telephone, LocalDate birthDate, List<Roles> roles) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.cellphone = cellphone;
        this.telephone = telephone;
        this.birthDate = birthDate;
        this.roles = roles;
    }

    public User(){
        this.setRoles(new ArrayList<>());
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return name;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return !(email != null ? !email.equals(user.email) : user.email != null);

    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }

    public enum Roles implements GrantedAuthority{
        ROLE_ADMIN("ROLE_ADMIN"), ROLE_CONSUMER("ROLE_CONSUMER");

        private String role;

        private Roles(String role){
            this.role = role;
        }

        @Override
        public String getAuthority() {
            return role;
        }
    }

}
