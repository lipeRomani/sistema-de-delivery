package br.com.cantinhodamarmita.entitys;


public class UpdatePasswordDto {

    String olderPassword;
    String newPassword;
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
