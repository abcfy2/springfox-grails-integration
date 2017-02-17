package springfox.documentation.grails

import spock.lang.Specification


class ActionsSpec extends Specification implements GrailsControllerSupport {
  def "Cannot instantiate this class"() {
    when:
      new Actions()
    then:
      thrown(UnsupportedOperationException)
  }

  def "Detects grails actions"() {
    given:
      def controller = aController()
    when:
      def handlerMethods = Actions.actionsToHandler(controller)
    then:
      handlerMethods.size() == 1
      handlerMethods.containsKey("index")
    and:
      handlerMethods["index"].method.name == "index"
  }
}