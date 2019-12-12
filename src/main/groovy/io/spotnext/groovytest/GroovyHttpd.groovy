package io.spotnext.groovytest
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue
import java.util.concurrent.ScheduledExecutorService
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

import javax.net.ssl.SSLContext

import com.sun.net.httpserver.HttpServer

import groovy.json.JsonOutput
import groovy.util.logging.Log

@Log
class GroovyHttpd {
	static void main(String...args) {
		final def startTime = System.currentTimeMillis()

		final def port = 8080
		final def socket = new InetSocketAddress(port)
//		final def scheduler = new ThreadPoolExecutor(20, 64, 10, TimeUnit.SECONDS, new ArrayBlockingQueue(100))

		final def server = HttpServer.create(socket, 1000).tap {
//			executor = scheduler
			createContext("/hello") { http ->
				if (http.requestMethod == 'GET') {
					http.responseHeaders.add("Content-type", "application/json")
					http.sendResponseHeaders(200, 0)
					final def ret = JsonOutput.toJson([
						name: "test",
						host: http.remoteAddress.hostName
					])

					http.responseBody.withWriter { out ->
						out << ret
					}
				}
			}
			start()
		}

		final def endTime = System.currentTimeMillis()
		log.info("Server started in ${(endTime - startTime) / 1000}s on port ${port}")
	}
}
