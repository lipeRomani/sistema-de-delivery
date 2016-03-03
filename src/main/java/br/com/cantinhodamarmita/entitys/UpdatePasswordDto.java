package br.com.cantinhodamarmita.entitys;


import br.com.cantinhodamarmita.validators.CurrentPassword;
import br.com.cantinhodamarmita.validators.FieldMatch;
import org.hibernate.validator.constraints.NotBlank;

@FieldMatch(first = "newPassword",second = "reNewPassword",message = "Senhas precisam ser iguais")
public class UpdatePasswordDto {

    @NotBlank
    @CurrentPassword
    String olderPassword;

    @NotBlank
    String newPassword;

    @NotBlank
    String reNewPassword;

    public UpdatePasswordDto(String olderPassword, String newPassword, String reNewPassword) {
        this.olderPassword = olderPassword;
        this.newPassword = newPassword;
        this.reNewPassword = reNewPassword;
    }

    public UpdatePasswordDto(){}

    public String getOlderPassword() {
        return olderPassword;
    }

    public void setOlderPassword(String olderPassword) {
        this.olderPassword = olderPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }

    @Override
    public String toString() {
        return "UpdatePasswordDto{" +
                "olderPassword='" + olderPassword + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", reNewPassword='" + reNewPassword + '\'' +
                '}';
    }
}
