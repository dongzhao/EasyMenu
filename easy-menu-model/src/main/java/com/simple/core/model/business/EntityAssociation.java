package com.simple.core.model.business;

import javax.persistence.DiscriminatorValue;

/**
 * Created by dzhao on 7/06/2015.
 */
@javax.persistence.Entity
@DiscriminatorValue(value = "EE")
public class EntityAssociation extends AbstractAssociation {
}