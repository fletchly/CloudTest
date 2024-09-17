package org.gcu.cloudtest.data.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("authorities")
public class AuthEntity implements Persistable<String>
{
    @Id
    @Column("username")
    private String username;

    @Column("authority")
    private String authority;

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

    @Override
    public String getId()
    {
        return this.username;
    }

    @Override
    public boolean isNew()
    {
        return true;
    }
}
