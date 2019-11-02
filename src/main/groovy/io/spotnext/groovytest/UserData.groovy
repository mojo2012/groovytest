package io.spotnext.groovytest

import groovy.transform.AutoClone
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.TupleConstructor

import static groovy.transform.AutoCloneStyle.SERIALIZATION

@ToString
@AutoClone(style = SERIALIZATION)
@EqualsAndHashCode
@TupleConstructor
class UserData implements Serializable {
    int id
    String name
    UserGroup group

    public void setName(String name) {
        this.name = name
    }
}
