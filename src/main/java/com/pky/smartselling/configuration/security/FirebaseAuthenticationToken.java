package com.pky.smartselling.configuration.security;

import com.pky.smartselling.domain.employee.Employee;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class FirebaseAuthenticationToken extends AbstractAuthenticationToken {
    /**
     * Creates a token with the supplied array of authorities.
     *
     * @param authorities the collection of <tt>GrantedAuthority</tt>s for the principal
     *                    represented by this authentication object.
     */
    final Employee employee;
    public FirebaseAuthenticationToken(Employee employee) {
        super(employee.getAuthorities());
        this.employee = employee;
        setAuthenticated(true);
    }

    @Override
    public void setAuthenticated(boolean authenticated) {
        super.setAuthenticated(authenticated);
    }

    @Override
    public Object getCredentials() {
        return null;
    }

    @Override
    public Object getPrincipal() {
        return employee;
    }
}
