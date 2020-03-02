package zubcic.travel.travelapplication.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ADMIN("ROLE_ADMIN"), CLIENT("ROLE_CLIENT");

    private String authority;

    Role(String authority) {
        this.authority = authority;
    }

    public String getAuthority(){
        return authority;
    }
}
