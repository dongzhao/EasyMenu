package com.simple.core.model.generic;

/**
 * Created by dzhao on 7/06/2015.
 */
import java.io.Serializable;

public interface BaseDomain<ID extends Serializable> extends Serializable{

    ID getId();

    //void setId(ID id);

}
