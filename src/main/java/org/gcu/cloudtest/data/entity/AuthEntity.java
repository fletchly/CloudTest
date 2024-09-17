package org.gcu.cloudtest.data.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "authorities")
public class AuthEntity
{
    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "authority")
    private String authority;

    public AuthEntity()
    {
        this.username = null;
        this.authority = null;
    }

    public AuthEntity(String username, String authority)
    {
        this.username = username;
        this.authority = authority;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public String getAuthority()
    {
        return authority;
    }

    public void setAuthority(String authority)
    {
        this.authority = authority;
    }
}
