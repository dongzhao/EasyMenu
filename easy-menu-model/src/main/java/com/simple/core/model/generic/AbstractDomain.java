package com.simple.core.model.generic;

import com.simple.core.util.IdGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by dzhao on 7/06/2015.
 */
@MappedSuperclass
public abstract class AbstractDomain implements BaseDomain<String>{

    @Id
    protected String id = IdGenerator.generateId();

    @Temporal(value = javax.persistence.TemporalType.TIMESTAMP)
    @NotNull(message = "created datetime cannot be null")
    @Column(name = "created_datetime")
    protected Date createdDatetime;

    @Column(name = "created_by")
    private String createdBy;

    @Version
    protected Long version;

    public String getId() {
        return id;
    }

/*    public void setId(String id) {
        this.id = id;
    }*/

    protected Long getVersion() {
        return version;
    }

    /**
     * Set to protected as it's not supposed to be called externally
     * @param version
     */
    protected void setVersion(Long version) {
        this.version = version;
    }


    public Date getCreatedDatetime() {
        return createdDatetime;
    }

    public void setCreatedDatetime(Date createdDatetime) {
        this.createdDatetime = createdDatetime;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

}
