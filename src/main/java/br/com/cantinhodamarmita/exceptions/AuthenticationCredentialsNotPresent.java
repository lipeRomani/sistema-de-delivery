package br.com.cantinhodamarmita.exceptions;

public class AuthenticationCredentialsNotPresent extends RuntimeException {
    public AuthenticationCredentialsNotPresent(String s) {
        super(s);
    }
}
