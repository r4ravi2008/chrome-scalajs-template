package com.alexitc.popup

import com.alexitc.background.BackgroundAPI
import com.alexitc.common.I18NMessages
import org.scalajs.dom._

import scala.concurrent.ExecutionContext

class Runner(messages: I18NMessages, backgroundAPI: BackgroundAPI) {

  def run(): Unit = {
    log("This was run by the popup script")
    document.write(s"<p>${messages.appName}!!!</p>")
    backgroundAPI.sendBrowserNotification(messages.appName, "I'm on the Pop-up")
  }

  private def log(msg: String): Unit = {
    println(s"popup: $msg")
  }
}

object Runner {

  def apply()(implicit ec: ExecutionContext): Runner = {
    val messages = new I18NMessages
    val backgroundAPI = new BackgroundAPI()
    new Runner(messages, backgroundAPI)
  }
}
