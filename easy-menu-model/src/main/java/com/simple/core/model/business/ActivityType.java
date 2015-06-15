package com.simple.core.model.business;

import com.simple.core.model.generic.AbstractDomain;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;

/**
 * Created by dzhao on 7/06/2015.
 */
@Entity
@Table(name = "my_activity_type")
public class ActivityType extends AbstractDomain {

    @NotNull(message = "activity type name cannot be null")
    @Column(length = 50)
    private String name;
    @Column(length = 100)
    private String description;
    @Column
    private String templateInfo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTemplateInfo() {
        return templateInfo;
    }

    public void setTemplateInfo(String templateInfo) {
        this.templateInfo = templateInfo;
    }
}
