package com.github.furqaan.servlet

import org.scalatra._
import org.scalatra.scalate.ScalateSupport

class FurqaanServlet extends ScalatraServlet with ScalateSupport {

  before {
    contentType = "text/html"
  } 
  
  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        Say <a href="hello-scalate">hello to Scalate</a>.
      </body>
    </html>
  }
  
  get("/hello-scalate") {
	templateEngine.layout("WEB-INF/scalate/templates/hello-scalate.scaml", Map("content" -> "Hello scalatra with scalate!"))
  }
}
