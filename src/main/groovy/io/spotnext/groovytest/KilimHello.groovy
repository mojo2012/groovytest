package io.spotnext.groovytest

import java.util.logging.Level

import groovy.json.JsonOutput
import groovy.util.logging.Log
import kilim.Pausable
import kilim.http.HttpRequest
import kilim.http.HttpResponse
import kilim.http.HttpServer
import kilim.http.HttpSession

@Log
public class KilimHello extends HttpSession {
	def bytes = "hello world".getBytes()

	static void main(String... args) throws IOException {
		if (kilim.tools.Kilim.trampoline(false, args)) return
		new HttpServer(8080, KilimHello.class)
	}

	void execute() throws Pausable, Exception {
		try {
			def req = new HttpRequest()
			def resp = new HttpResponse()
			
			while (true) {
				super.readRequest(req)
				
				if (req.keepAlive()) {
					resp.addField("Connection", "Keep-Alive")
				}
				
				final def ret = JsonOutput.toJson([
					name: "test",
					method: req.method
				])
				
				resp.outputStream << ret.bytes
				sendResponse(resp)
				
				if (!req.keepAlive()) {
					break
				}
			}
		}
		catch (def e) {
			log.log(Level.SEVERE, e.getMessage())
		}
		
		super.close()
	}
}
