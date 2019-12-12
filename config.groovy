import org.codehaus.groovy.control.ParserPluginFactory

import groovy.transform.CompileStatic
import groovy.transform.TypeChecked

withConfig(configuration) {

	// inject compile static annotation into every class except for test classes
	source(classValidator: { ClassNode cn -> !cn.name.endsWith("Test") && !cn.name.endsWith("IT") }) {
		ast(CompileStatic)
		ast(TypeChecked)
	}
	
	//enable new groovy 3/java 11 syntax
	//	configuration.pluginFactory = ParserPluginFactory.antlr4(configuration)
}
