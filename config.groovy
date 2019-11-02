import groovy.transform.CompileStatic
import groovy.transform.TypeChecked

withConfig(configuration) {
  ast(TypeChecked)
  ast(CompileStatic)
}