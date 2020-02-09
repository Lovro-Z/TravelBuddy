package zubcic.travel.travelapplication.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ADMIN, CLIENT;

    public String getAuthority(){
        return name();
    }
}
