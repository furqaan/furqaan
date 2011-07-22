package com.github.furqaan.servlet

import org.mortbay.jetty.Server
import org.mortbay.jetty.servlet.{Context, ServletHolder}

object JettyLauncher {

  def main(args: Array[String]): Unit = {  
    val server = new Server(8080)
    val root   = new Context(server, "/", Context.SESSIONS)
    root.addServlet(new ServletHolder(new FurqaanServlet), "/*")
    server.start()
    server.join()
  }

}