package io.spotnext.groovytest

import groovy.transform.AutoClone
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import groovy.transform.TupleConstructor
import groovy.transform.builder.Builder
import groovy.transform.builder.InitializerStrategy
import groovy.transform.builder.SimpleStrategy

import static groovy.transform.AutoCloneStyle.SERIALIZATION

@ToString
@AutoClone(style = SERIALIZATION)
@EqualsAndHashCode
@TupleConstructor
@Builder(builderStrategy=SimpleStrategy.class)
class UserData implements Serializable {
	int id
	String name
	UserGroup group

}
