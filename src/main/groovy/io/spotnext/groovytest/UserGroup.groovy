package io.spotnext.groovytest

import groovy.transform.*

import static groovy.transform.AutoCloneStyle.SERIALIZATION

@ToString
@AutoClone(style = SERIALIZATION)
@EqualsAndHashCode
@Immutable
@TupleConstructor
class UserGroup implements Serializable {
	int id
	String name
}
